package com.e3e4e20.model.service;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 通报批评表列名
 * Created: 2020-04-20 17:25 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface CriticizeColNameService {
    /**
     * 获取通报批评表的表列名
     * @return List<ArticleRecordName>
     */
    List<ArticleDetailRecordName> getCaseColName ();
}
