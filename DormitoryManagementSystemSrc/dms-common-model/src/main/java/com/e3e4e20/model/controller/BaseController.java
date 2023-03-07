package com.e3e4e20.model.controller;

/*
 * Description: 基本控制类
 * Created: 2020-04-15 15:24 星期三
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.entity.ProfileDomain;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基本控制类
 * 继承该控制类的控制类都会在执行的时候,
 * 从shiro中获取相关数据
 *      userId
 *      userName
 *      collegeId
 *      collegeName
 */
@CrossOrigin
@RestController
public class BaseController {
    public HttpServletRequest request;
    public HttpServletResponse response;
    protected String userId;
    protected String collegeId;
    protected String collegeName;

    //使用shiro获取
    //进入控制器之前执行的方法
    @ModelAttribute
    public void serResAndReq(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

        //获取session中的安全数据
        Subject subject = SecurityUtils.getSubject();
        //subject获取所有的安全集合
        PrincipalCollection principals = subject.getPrincipals();
        if (principals != null && !principals.isEmpty()) {
            //获取安全数据
            ProfileDomain result = (ProfileDomain) principals.getPrimaryPrincipal();
            this.userId = result.getUserId();
            this.collegeId = result.getCollegeId();
            this.collegeName = result.getCollegeName();
        }
    }
}
