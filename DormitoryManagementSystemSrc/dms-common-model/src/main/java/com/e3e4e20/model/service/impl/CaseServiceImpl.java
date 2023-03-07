package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.CaseDomain;
import com.e3e4e20.model.mapper.CaseMapper;
import com.e3e4e20.model.service.CaseService;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 例检、抽检业务层实现
 * Created: 2020-04-18 13:54 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    CaseMapper caseMapper;
    @Override
    public List<CaseDomain> selectById(String articleId) {
        return caseMapper.selectById(articleId);
    }

    @Override
    public void insertRecord(CaseDomain caseDomain) {
        caseMapper.insertRecord(caseDomain);
    }
}
