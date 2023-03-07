package com.e3e4e20.model.service;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 星级宿舍表列名
 * Created: 2020-04-20 17:32 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface StarColNameService {
    /**
     * 获取星级宿舍表的表列名
     * @return List<ArticleRecordName>
     */
    List<ArticleDetailRecordName> getCaseColName ();
}
