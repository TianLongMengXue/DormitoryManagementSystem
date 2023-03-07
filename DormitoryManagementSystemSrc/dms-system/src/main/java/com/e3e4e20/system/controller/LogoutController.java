package com.e3e4e20.system.controller;

import com.e3e4e20.common.constant.ResultMessage;
import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.model.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Filename: com.e3e4e20.system.controller
 * Description:
 * Version: 1.0
 * Created: 2020-04-11 20:59 星期六
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class LogoutController extends BaseController {
    @PostMapping("/logout")
    public ResponseData logoutHandle (){
        // 1. 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 2. 对当前用户执行退出登录
        subject.logout();
        // System.out.println("====> 用户退出！");
        // 3. 结束系统
        // System.exit(0);
        return ResponseData.SUCCESS(ResultMessage.LOGOUT_SUCCESS, null);
    }
}
