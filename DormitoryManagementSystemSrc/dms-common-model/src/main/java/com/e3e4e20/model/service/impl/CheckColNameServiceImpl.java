package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import com.e3e4e20.model.mapper.CheckColNameMapper;
import com.e3e4e20.model.service.CheckColNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 班级考评表列名
 * Created: 2020-04-20 17:34 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class CheckColNameServiceImpl implements CheckColNameService {
    @Autowired
    CheckColNameMapper checkColNameMapper;
    @Override
    public List<ArticleDetailRecordName> getCaseColName() {
        return checkColNameMapper.selectColName();
    }
}
