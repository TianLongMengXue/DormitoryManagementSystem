package com.e3e4e20.home.service.impl;

import com.e3e4e20.common.entity.home.ArticleList;
import com.e3e4e20.common.entity.PageResult;
import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.common.pojo.HomeArticleDomain;
import com.e3e4e20.home.service.ArticleListService;
import com.e3e4e20.model.service.HomeArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Description: 将数据库内返回的文章信息进行格式化操作业务实现
 * Created: 2020-04-18 20:13 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class ArticleListServiceImpl implements ArticleListService {
    @Autowired
    HomeArticleService homeArticleService;

    @Override
    public ResponseData articleList(Map<String, Object> map) {
        // 获取文章列表信息
        List<HomeArticleDomain> articleList = homeArticleService.getAllArticle(map);
        // 文章总数
        long total = homeArticleService.countRows(map);
        // 实例化分页对象
        PageResult<ArticleList> pageResult = new PageResult<>();
        // 文章总数
        pageResult.setTotal(total);
        // 文章列表
        List<ArticleList> lists = new ArrayList<>();
        for (HomeArticleDomain homeArticleDomain: articleList) {
            // 实例化文章对象
            ArticleList article = new ArticleList();
            // 文章编号
            article.setId(homeArticleDomain.getArticleId());
            // 文章发布时间
            SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd");
            article.setDate(dateTime.format(homeArticleDomain.getArticleTime()));
            // 文章标题
            article.setTitle(homeArticleDomain.getArticleTitle());
            // 文章说明
            article.setDesc(homeArticleDomain.getArticleDesc());
            // 文章发布者
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            article.setPost(date.format(homeArticleDomain.getArticleTime()) + " " + homeArticleDomain.getArticlePost());
            // 文章类型
            article.setType(homeArticleDomain.getArticleType());
            // 添加到文章列表中
            lists.add(article);
        }
        // 将文章列表添加到分页对象中
        pageResult.setRows(lists);
        return ResponseData.SUCCESS("ArticleList",pageResult);
    }
}
