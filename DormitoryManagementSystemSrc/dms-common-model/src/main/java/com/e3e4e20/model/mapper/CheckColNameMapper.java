package com.e3e4e20.model.mapper;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Description: 班级考评表列名 -- result_check_col
 * Created: 2020-04-20 16:57 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface CheckColNameMapper {
    /**
     * 查询班级考评表的表列名
     * @return List<ArticleRecordName>
     */
    List<ArticleDetailRecordName> selectColName ();
}
