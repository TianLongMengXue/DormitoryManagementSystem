package com.e3e4e20.home.controller;

import com.e3e4e20.common.entity.home.UserInfoName;
import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.model.controller.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Description: home页面用户信息面的各项信息的信息名称
 * Created: 2020-04-20 13:53 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@CrossOrigin
@RestController
@RequestMapping("/home")
public class InfoNameController extends BaseController {
    @RequestMapping("/infoName")
    public ResponseData initUserInfoName () {
        // 1. 获取当前对象
        // 2. 判断当前对象含有 学生 还是 老师 身份
        // 3. 为当前信息表的信息名赋值 学生(学号) 老师(职工号)
        return ResponseData.SUCCESS("InitUserInfoName", new UserInfoName("学号"));
    }
}
