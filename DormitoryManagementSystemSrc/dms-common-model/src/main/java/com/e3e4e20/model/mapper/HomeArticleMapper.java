package com.e3e4e20.model.mapper;

/*
 * Description: home页面文章持久层
 * Created: 2020-04-17 21:03 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.HomeArticleDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * home页面文章持久层 -- home_article
 */
@Mapper
@Repository
public interface HomeArticleMapper {
    /**
     * 根据 菜单编号 学院编号 查询文章列表
     * @param map
     * @return List<HomeArticleDoamin>
     */
    List<HomeArticleDomain> selectByMenuCollegeId (Map<String, Object> map);

    /**
     * 根据 菜单编号 学院编号 查询文章列表
     * @param map
     * @return HomeArticleDoamin
     */
    HomeArticleDomain selectOneByMenuCollegeId (Map<String, Object> map);

    /**
     * 添加home页面文章
     * @param homeArticleDomain
     * @return int
     */
    int insertArticle (HomeArticleDomain homeArticleDomain);

    /**
     * 修改home页面文章信息
     * @param map
     * @return int
     */
    int updateArticle (Map<String, Object> map);

    /**
     * 根据 文章编号 删除home页面文章
     * @param articleId
     * @return int
     */
    int deleteArticleById (@Param("articleId") String articleId);

    /**
     * 统计文章的总条数
     * @param map
     * @return Long
     */
    Long countRows (Map<String, Object> map);
}
