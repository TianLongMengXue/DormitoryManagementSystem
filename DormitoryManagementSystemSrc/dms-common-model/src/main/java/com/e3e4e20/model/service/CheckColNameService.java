package com.e3e4e20.model.service;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 班级考评表列名
 * Created: 2020-04-20 17:21 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface CheckColNameService {
    /**
     * 获取班级考评表的表列名
     * @return List<ArticleRecordName>
     */
    List<ArticleDetailRecordName> getCaseColName ();
}
