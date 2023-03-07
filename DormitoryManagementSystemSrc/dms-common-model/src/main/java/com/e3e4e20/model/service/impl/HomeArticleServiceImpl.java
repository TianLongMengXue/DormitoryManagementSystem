package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.HomeArticleDomain;
import com.e3e4e20.model.mapper.HomeArticleMapper;
import com.e3e4e20.model.service.HomeArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * Description: home页面文章业务层实现
 * Created: 2020-04-18 13:45 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class HomeArticleServiceImpl implements HomeArticleService {
    @Autowired
    HomeArticleMapper articleMapper;

    @Override
    public List<HomeArticleDomain> getAllArticle(Map<String, Object> map) {
        return articleMapper.selectByMenuCollegeId(map);
    }

    @Override
    public HomeArticleDomain getOneArticle(Map<String, Object> map) {
        return articleMapper.selectOneByMenuCollegeId(map);
    }

    @Override
    public void insertArticle(HomeArticleDomain homeArticleDomain) {
        articleMapper.insertArticle(homeArticleDomain);
    }

    @Override
    public void updateArticle(Map<String, Object> map) {
        articleMapper.updateArticle(map);
    }

    @Override
    public void deleteArticleById(String articleId) {
        articleMapper.deleteArticleById(articleId);
    }

    @Override
    public Long countRows(Map<String, Object> map) {
        return articleMapper.countRows(map);
    }
}
