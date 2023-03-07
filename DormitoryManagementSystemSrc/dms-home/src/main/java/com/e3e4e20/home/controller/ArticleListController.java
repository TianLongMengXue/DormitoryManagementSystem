package com.e3e4e20.home.controller;

/*
 * Description: home页面文章列表
 * Created: 2020-04-16 23:58 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.home.service.ArticleListService;
import com.e3e4e20.model.controller.BaseController;
import com.e3e4e20.model.service.HomeIntroduceService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据传递过来的文章类型响应给前端对应的文章列表
 */
@CrossOrigin
@RestController
@RequestMapping("/home")
public class ArticleListController extends BaseController {
    @Autowired
    ArticleListService articleListService;
    @RequestMapping("/articleList")
    public ResponseData articleList (@RequestBody /*Integer*/ /*String menuId, String index, String
    total*/ List<String> list){
        Map<String, Object> map = new HashMap<>();
        /*Integer menuIdVal = Integer.valueOf(menuId);
        Integer indexVal = Integer.valueOf(index);
        Integer totalVal = Integer.valueOf(total);*/
        Integer menuIdVal = Integer.valueOf(list.get(0));
        Integer indexVal = Integer.valueOf(list.get(1));
        Integer totalVal = Integer.valueOf(list.get(2));
        /*if (!menuId.equals(1)){
            map.put("menuId", menuId);
        }*/
        if (!menuIdVal.equals(1)){
            map.put("menuId", menuIdVal);
        }
        map.put("collegeId", collegeId);
        map.put("index", indexVal);
        map.put("total", totalVal);
        return articleListService.articleList(map);
    }
}
