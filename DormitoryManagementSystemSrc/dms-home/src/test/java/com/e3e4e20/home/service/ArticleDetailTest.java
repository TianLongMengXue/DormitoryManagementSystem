package com.e3e4e20.home.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/*
 * Description:
 * Created: 2020-04-21 21:13 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */
@SpringBootTest
public class ArticleDetailTest {
    @Autowired
    ArticleDetailService articleDetailService;
    @Test
    public void caseTest () {
        Map<String,String> map = new HashMap<>();
        map.put("articleType","1252111665160331264");
        map.put("articleId","1251470520445083655");
        map.put("collegeId","1250317154721492992");
        map.put("collegeName","信息与计算机工程学院");
        System.out.println(articleDetailService.getArticleDetail(map));
    }
}
