package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import com.e3e4e20.model.mapper.StarColNameMapper;
import com.e3e4e20.model.service.StarColNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 星级宿舍表列名
 * Created: 2020-04-20 17:39 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class StarColNameServiceImpl implements StarColNameService {
    @Autowired
    StarColNameMapper starColNameMapper;
    @Override
    public List<ArticleDetailRecordName> getCaseColName() {
        return starColNameMapper.selectColName();
    }
}
