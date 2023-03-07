package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.HomeArticleDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * Description: home页面文章业务层接口
 * Created: 2020-04-18 10:38 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface HomeArticleService {
    /**
     * 根据 菜单编号 学院编号 获取对应的文章内容
     * @param map
     * @return List<HomeArticleDomain>
     */
    List<HomeArticleDomain> getAllArticle (Map<String, Object> map);

    /**
     * 根据 菜单编号 学院编号 获取对应的文章内容
     * @param map
     * @return HomeArticleDomain
     */
    HomeArticleDomain getOneArticle (Map<String, Object> map);

    /**
     * 添加文章内容
     * @param homeArticleDomain
     */
    void insertArticle (HomeArticleDomain homeArticleDomain);

    /**
     * 修改home页面文章信息
     * @param map
     */
    void updateArticle (Map<String, Object> map);

    /**
     * 根据 文章编号 删除home页面文章
     * @param articleId
     */
    void deleteArticleById (@Param("articleId") String articleId);

    /**
     * 获取文章的总条数
     * @return int
     */
    Long countRows (Map<String, Object> map);
}
