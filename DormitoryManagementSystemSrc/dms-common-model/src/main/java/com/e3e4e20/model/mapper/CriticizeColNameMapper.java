package com.e3e4e20.model.mapper;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Description: 通报批评表列名 -- result_criticize_col
 * Created: 2020-04-20 17:14 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface CriticizeColNameMapper {
    /**
     * 查询例检、抽检的表列名
     * @return List<ArticleRecordName>
     */
    List<ArticleDetailRecordName> selectColName ();
}
