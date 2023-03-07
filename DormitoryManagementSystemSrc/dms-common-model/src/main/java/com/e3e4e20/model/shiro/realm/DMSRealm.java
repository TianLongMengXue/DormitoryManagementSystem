package com.e3e4e20.model.shiro.realm;

/*
 * Description: 宿舍管理系统的公共授权realm
 * Created: 2020-04-05 23:59 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.entity.ProfileDomain;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 宿舍管理系统的公共授权realm
 *  1. 获取安全数据
 *  2. 构造权限信息
 */
public class DMSRealm extends AuthorizingRealm {
    /**
     * 为该认证授权Realm指定一个固定的名称
     * @param name
     */
    @Override
    public void setName(String name) {
        super.setName("DMSRealm");
    }

    /**
     * 1. 获取安全数据
     * 2. 构造权限信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 1. 获取安全数据
//        ProfileDomain profile = (ProfileDomain) principalCollection.getPrimaryPrincipal();
        // 2. 获取权限信息 apis

        // 3. 构造权限数据
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // info.setStringPermissions("");
        return null;
    }

    /**
     * 认证的内容交由 system 模块进行重写
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
