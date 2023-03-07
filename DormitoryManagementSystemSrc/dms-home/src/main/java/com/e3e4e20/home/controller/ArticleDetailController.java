package com.e3e4e20.home.controller;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.home.service.ArticleDetailService;
import com.e3e4e20.model.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
 * Description: 文章详情页面文章内容
 * Created: 2020-04-21 16:22 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */
@CrossOrigin
@RestController
@RequestMapping("/home")
public class ArticleDetailController extends BaseController {
    @Autowired
    ArticleDetailService articleDetailService;
    @RequestMapping("/articleDetail")
    public ResponseData getArticleDetail (@RequestBody Map map){
        Map<String,String> condition = new HashMap<>();
        condition.put("articleId",(String) map.get("id"));
        condition.put("articleType", (String) map.get("type"));
        condition.put("collegeId", collegeId);
        condition.put("collegeName", collegeName);
        return articleDetailService.getArticleDetail(condition);
    }
}
