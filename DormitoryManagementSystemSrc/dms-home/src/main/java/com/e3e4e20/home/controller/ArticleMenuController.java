package com.e3e4e20.home.controller;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.model.controller.BaseController;
import com.e3e4e20.model.service.HomeMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Description: home页面文章显示种类的菜单选项
 * Created: 2020-04-20 13:58 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@CrossOrigin
@RestController
@RequestMapping("/home")
public class ArticleMenuController extends BaseController {
    @Autowired
    HomeMenuService homeMenuService;
    @RequestMapping("/articleMenu")
    public ResponseData initArticleMenu () {
        return ResponseData.SUCCESS("InitArticleMenu",homeMenuService.selectAllMenu());
    }
}
