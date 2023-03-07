package com.e3e4e20.system.controller;

import com.e3e4e20.common.constant.ResultMessage;
import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.common.pojo.LoginDomain;
import com.e3e4e20.system.service.LoginCheckService;
import com.e3e4e20.system.service.LoginTimeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*
 * Filename: com.e3e4e20.login.controller
 * Description: 登录控制器
 * Version: 1.0
 * Created: 2020-04-05 1:28 星期日
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 登录控制器
 * 接收前端发来的登录表单,调用登录校验的服务接口进行相关校验,并返回一个结果给前端
 */
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    private LoginCheckService loginCheckService;
    @Autowired
    LoginTimeService loginTimeService;
    @PostMapping("/login")
    public ResponseData loginCheck (@RequestBody LoginDomain loginDomain) {
        /*try {
            // 1. 构造登录令牌 UsernamePasswordToken (封装学号/职工号和密码)
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginDomain.getUserId(), loginDomain.getUserWord());
            // 2. 创建Subject (创建当前"用户",即用户主体)
            Subject subject = SecurityUtils.getSubject();
            // 3. 调用shiro的login方法,进入UserRealm进行用户认证(登录验证)
            subject.login(usernamePasswordToken);
            // 4. 获得shiro为当前用户的生成的sessionId (作为token使用)
            String token = (String) subject.getSession().getId();
            // 5. 封装数据响应给前端处理
            return ResponseData.SUCCESS(ResultMessage.LOGIN_SUCCESS, token);
        } catch (AuthenticationException message) {
            // 6. 捕获登录表单错误并返回给前端
            return ResponseData.FAILURE(message.getMessage());
        }*/
        // LoginCheckService loginCheckService = new LoginCheckServiceImpl();
        /*try {
            // 调用登录校验服务进行登录表单校验
            return loginCheckService.loginCheck(loginDomain);
        } catch (MessageException message) {
            // 捕获登录表单错误并返回给前端
            return ResponseData.FAILURE(message.getMessage());
        }*/
        try {
            // 1. 调用登录校验服务进行登录表单校验
            String userWordMD5 = loginCheckService.loginCheck(loginDomain);
            // 2. 构造登录令牌 UsernamePasswordToken (封装学号/职工号和密码)
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginDomain.getUserId(), userWordMD5);
            // 3. 创建Subject (创建当前"用户",即用户主体)
            Subject subject = SecurityUtils.getSubject();
            // 4. 调用shiro的login方法,进入UserRealm进行用户认证(登录验证)
            subject.login(usernamePasswordToken);
            // 5. 获得shiro为当前用户的生成的sessionId (作为token使用)
            if (subject.isAuthenticated()){
                loginTimeService.insertDate(loginDomain.getUserId());
            }
            Map<String, String> token = new HashMap<String, String>();
            token.put("token", (String) subject.getSession().getId());
            // 6. 封装数据响应给前端处理
            return ResponseData.SUCCESS(ResultMessage.LOGIN_SUCCESS, token);
        } catch (AuthenticationException message) {
            message.printStackTrace();
            // 捕获登录表单错误并返回给前端
            return ResponseData.FAILURE(message.getMessage());
        }
    }
}
