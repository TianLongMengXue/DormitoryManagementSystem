package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import com.e3e4e20.model.mapper.CriticizeColNameMapper;
import com.e3e4e20.model.service.CriticizeColNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 通报批评表列名
 * Created: 2020-04-20 17:37 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class CriticizeColNameSercieImpl implements CriticizeColNameService {
    @Autowired
    CriticizeColNameMapper criticizeColNameMapper;
    @Override
    public List<ArticleDetailRecordName> getCaseColName() {
        return criticizeColNameMapper.selectColName();
    }
}
