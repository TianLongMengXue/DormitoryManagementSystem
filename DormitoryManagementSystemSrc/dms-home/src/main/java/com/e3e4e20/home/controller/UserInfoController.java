package com.e3e4e20.home.controller;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.home.service.UserInfoPanelService;
import com.e3e4e20.model.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Description: home页面用户信息面板的各项信息内容
 * Created: 2020-04-20 13:56 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@CrossOrigin
@RestController
@RequestMapping("/home")
public class UserInfoController extends BaseController {
    @Autowired
    UserInfoPanelService userInfoPanelService;
    @RequestMapping("/userInfo")
    public ResponseData initUserInfo () {
        return ResponseData.SUCCESS("InitUSerInfo", userInfoPanelService.userInfo(userId));
    }
}
