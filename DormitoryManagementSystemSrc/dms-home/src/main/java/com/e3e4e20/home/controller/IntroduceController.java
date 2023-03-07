package com.e3e4e20.home.controller;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.model.controller.BaseController;
import com.e3e4e20.model.service.HomeIntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Description: home页面的宿管简介
 * Created: 2020-04-20 14:00 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@CrossOrigin
@RestController
@RequestMapping("/home")
public class IntroduceController extends BaseController {
    @Autowired
    HomeIntroduceService homeIntroduceService;
    @RequestMapping("introduce")
    public ResponseData introduce (){
        return ResponseData.SUCCESS("introduce",homeIntroduceService.getIntroduce());
    }
}
