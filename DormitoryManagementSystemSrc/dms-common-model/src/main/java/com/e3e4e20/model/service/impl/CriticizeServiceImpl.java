package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.CriticizeDomain;
import com.e3e4e20.model.mapper.CriticizeMapper;
import com.e3e4e20.model.service.CriticizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 通报批评业务层实现
 * Created: 2020-04-18 14:05 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class CriticizeServiceImpl implements CriticizeService {
    @Autowired
    CriticizeMapper criticizeMapper;
    @Override
    public List<CriticizeDomain> selectById(String articleId) {
        return criticizeMapper.selectById(articleId);
    }

    @Override
    public void insertRecord(CriticizeDomain criticizeDomain) {
        criticizeMapper.insertRecord(criticizeDomain);
    }
}
