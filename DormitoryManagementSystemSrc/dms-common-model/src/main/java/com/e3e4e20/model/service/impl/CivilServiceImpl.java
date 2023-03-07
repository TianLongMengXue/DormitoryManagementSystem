package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.CivilDomain;
import com.e3e4e20.model.mapper.CivilMapper;
import com.e3e4e20.model.service.CivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 文明宿舍业务层实现
 * Created: 2020-04-18 14:04 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class CivilServiceImpl implements CivilService {
    @Autowired
    CivilMapper civilMapper;
    @Override
    public List<CivilDomain> selectById(String articleId) {
        return civilMapper.selectById(articleId);
    }

    @Override
    public void insertRecord(CivilDomain civilDomain) {
        civilMapper.insertRecord(civilDomain);
    }
}
