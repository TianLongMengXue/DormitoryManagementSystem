package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import com.e3e4e20.model.mapper.CaseColNameMapper;
import com.e3e4e20.model.service.CaseColNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 例检、抽检表列名
 * Created: 2020-04-20 17:33 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class CaseColNameServiceImpl implements CaseColNameService {
    @Autowired
    CaseColNameMapper caseColNameMapper;
    @Override
    public List<ArticleDetailRecordName> getCaseColName() {
        return caseColNameMapper.selectColName();
    }
}
