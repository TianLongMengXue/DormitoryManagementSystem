package com.e3e4e20.system.shiro.realm;

import com.e3e4e20.common.entity.ProfileDomain;
import com.e3e4e20.common.pojo.UserDomain;
import com.e3e4e20.model.shiro.realm.DMSRealm;
import com.e3e4e20.model.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Filename: com.e3e4e20.system.shiro.realm
 * Description: 认证realm
 * Version: 1.0
 * Created: 2020-04-06 0:07 星期一
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */
public class UserRealm extends DMSRealm {
    @Autowired
    UserInfoService userInfoService;
    /**
     * 用户认证
     * @param authenticationToken
     * @return 通过了认证(登录成功)的用户的个人信息、权限、角色
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1. 获取用户的 学号/职工号 和 密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        usernamePasswordToken.setRememberMe(false);
        String userId = usernamePasswordToken.getUsername();
        String userWord = new String(usernamePasswordToken.getPassword());
        // 2. 构造安全数据 (用户的基本信息、权限信息)
        ProfileDomain profile = new ProfileDomain();
        // 3. 调用service方法查询用户基本信息
        UserDomain userInfo = userInfoService.selectUserInfo(userId);
        // 4. 封装查询的用户权限信息(Profile)
        profile.setUserId(userInfo.getUserId());
        profile.setCollegeId(userInfo.getCollegeId());
        profile.setCollegeName(userInfo.getCollegeName());
        // 5. 构造安全数据 安全数据 密码 realm域名
        return new SimpleAuthenticationInfo(profile ,userWord,this.getName());
    }
}
