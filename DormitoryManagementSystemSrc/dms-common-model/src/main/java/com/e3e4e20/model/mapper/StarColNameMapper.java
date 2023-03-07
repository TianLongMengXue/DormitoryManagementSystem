package com.e3e4e20.model.mapper;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Description: 星级宿舍表列名 -- result_star_col
 * Created: 2020-04-20 17:01 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface StarColNameMapper {
    /**
     * 查询文明宿舍表的表列名
     * @return List<ArticleRecordName>
     */
    List<ArticleDetailRecordName> selectColName ();
}
