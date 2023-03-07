package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import com.e3e4e20.model.mapper.CivilColNameMapper;
import com.e3e4e20.model.service.CivilColNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 文明宿舍表列名
 * Created: 2020-04-20 17:35 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class CivilColNameServiceImpl implements CivilColNameService {
    @Autowired
    CivilColNameMapper civilColNameMapper;
    @Override
    public List<ArticleDetailRecordName> getCaseColName() {
        return civilColNameMapper.selectColName();
    }
}
