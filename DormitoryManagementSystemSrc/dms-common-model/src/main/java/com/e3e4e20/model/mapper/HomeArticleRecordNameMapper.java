package com.e3e4e20.model.mapper;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Description: 文章详情列名
 * Created: 2020-04-21 17:27 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface HomeArticleRecordNameMapper {
    /**
     * 查询例检抽检的列名
     * @return List<ArticleRecordName>
     */
    List<ArticleDetailRecordName> selectRecordName ();

}
