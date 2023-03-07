package com.e3e4e20.model.service;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 文明宿舍表列名
 * Created: 2020-04-20 17:22 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface CivilColNameService {
    /**
     * 获取文明宿舍表的表列名
     * @return List<ArticleRecordName>
     */
    List<ArticleDetailRecordName> getCaseColName ();
}
