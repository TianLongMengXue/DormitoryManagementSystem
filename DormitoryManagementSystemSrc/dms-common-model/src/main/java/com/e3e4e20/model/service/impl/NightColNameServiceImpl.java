package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import com.e3e4e20.model.mapper.NightColNameMapper;
import com.e3e4e20.model.service.NightColNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 晚归通报表列名
 * Created: 2020-04-20 17:38 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class NightColNameServiceImpl implements NightColNameService {
    @Autowired
    NightColNameMapper nightColNameMapper;

    @Override
    public List<ArticleDetailRecordName> getCaseColName() {
        return nightColNameMapper.selectColName();
    }
}
