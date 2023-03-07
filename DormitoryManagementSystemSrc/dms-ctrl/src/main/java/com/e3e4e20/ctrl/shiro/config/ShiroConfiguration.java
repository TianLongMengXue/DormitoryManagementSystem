package com.e3e4e20.ctrl.shiro.config;

import com.e3e4e20.model.shiro.config.SessionManager;
import com.e3e4e20.model.shiro.realm.DMSRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Filename: com.e3e4e20.system.shiro.config
 * Description: system的shiro相关配置
 * Version: 1.0
 * Created: 2020-04-04 15:31 星期六
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Configuration
public class ShiroConfiguration {
    /**
     * 创建Realm
     *
     * @return UserRealm
     */
    @Bean(name = "dmsRealm")
    public DMSRealm getRealm() {
        return new DMSRealm();
    }

    /**
     * 创建DefaultWebSecurityManager
     *
     * @return DefaultWebSecurityManager
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("dmsRealm") DMSRealm realm) {
        // 创建Web安全管理器
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联Realm
        securityManager.setRealm(realm);
        // 将自定义的会话管理器注册到安全管理器中
        securityManager.setSessionManager(shiroSessionManager());
        // 将自定义的 redis 缓存管理器注册到安全管理器中
        securityManager.setCacheManager(redisCacheManager());
        return securityManager;
    }

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        // 1. 创建过滤器工厂
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 2. 设置安全管理器
        factoryBean.setSecurityManager(securityManager);
        // 3. 通用配置: 未登录配置 未授权配置
        factoryBean.setLoginUrl("/unknown"); // 配置未登录跳转的url地址
        factoryBean.setUnauthorizedUrl("/unauthorized"); // 配置未授权的url地址
        /*
         * shiro 的内置过滤器
         *  常用的：
         *      anon: 无需认证(登录)可以访问
         *      authc: 必须认证(登录)才可以访问
         *      user: 如果使用rememberMe的功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */
        /*
         * 设置过滤器集合
         * 设置所有的过滤器,使用有顺序的map
         *      key = url地址
         *      value = 过滤器类型
         */
        // 4. 设置过滤器集合
        Map<String, String> filterMap = new LinkedHashMap<>();
        // anon -- 匿名访问 登录-注册-通用配置url
        filterMap.put("/sys/login", "anon");
        filterMap.put("/unknown", "anon");
        filterMap.put("/unauthorized", "anon");
        // authc 认证之后才能访问(登录之后)
        filterMap.put("/**", "authc");
        // perms 中具有某种权限
        factoryBean.setFilterChainDefinitionMap(filterMap);
        return factoryBean;
    }

    /**
     * 配置shiro注解支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    // 配置 shiro 的 DefaultWebSessionManager
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.database}")
    private int database;

    /**
     * 1. redis控制器,用于操控redis
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host + ":" + port);
        redisManager.setPassword(password);
        redisManager.setTimeout(timeout);
        redisManager.setDatabase(database);
        return redisManager;
    }

    /**
     * 2. sessionDao
     */
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * 3. 会话管理器
     */
    public DefaultWebSessionManager shiroSessionManager() {
        SessionManager sessionManager = new SessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        // 禁用cookie
        sessionManager.setSessionIdCookieEnabled(false);
        // 禁用url重写  url;jsessionid=id 的形式
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /**
     * 4. 缓存管理器
     */
    public RedisCacheManager redisCacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        /*
        * class com.e3e4e20.common.entity.ProfileDomain must has getter for field:
        * 'id' We need a field to identify this Cache Object in Redis.
        * So you need to defined an id field which you can get unique id to identify this principal.
        * For example, if you use UserInfo as Principal class, the id field maybe userId, userName, email, etc.
        * For example, getUserId(), getUserName(), getEmail(), etc.
        * Default value is "id", that means your principal object has a method called "getId()"
        * 即在认证Realm域中构造的安全数据时,需要指定安全数据中的一个具有标志性的字段,作为唯一标志redis存储时的标志名
        * return new SimpleAuthenticationInfo(profile ,userWord,this.getName());
        * */
        redisCacheManager.setPrincipalIdFieldName("userId");
        return redisCacheManager;
    }
}
