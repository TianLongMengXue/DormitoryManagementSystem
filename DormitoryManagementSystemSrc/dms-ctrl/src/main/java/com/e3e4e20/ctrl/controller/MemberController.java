package com.e3e4e20.ctrl.controller;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.common.pojo.LoginDomain;
import com.e3e4e20.ctrl.service.MemberService;
import com.e3e4e20.model.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
 * Description: 个人中心控制器
 * Created: 2020-05-07 15:03 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@RestController
@RequestMapping("/ctrl")
public class MemberController extends BaseController {
    @Autowired
    MemberService memberService;
    @GetMapping("/userInfo/select")
    ResponseData userInfoSelect (){
        return memberService.getUserInfo(userId);
    }
    @PostMapping("userInfo/update")
    ResponseData userInfoUpdate (Map map){
        map.put("userId",userId);
        return memberService.alterUserInfo(map);
    }
    @PostMapping("/changeWord/update")
    ResponseData changeWordUpdate (Map map){
        return memberService.alterUserWord(new LoginDomain(userId, (String) map.get("userWord")));
    }
}
