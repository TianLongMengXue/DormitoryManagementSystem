package com.e3e4e20.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/*
 * Description: home页面文章的类型持久层 -- home_article_type
 * Created: 2020-04-21 16:13 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface HomeArticleTypeMapper {
    /**
     * 根据文章的类型编号查询对应的类型名称
     * @param articleType
     * @return String
     */
    String selectTypeById(@Param("articleType") String articleType);
}
