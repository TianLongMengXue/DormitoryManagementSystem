package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.CaseDomain;
import com.e3e4e20.common.pojo.NightDomain;
import com.e3e4e20.model.mapper.NightMapper;
import com.e3e4e20.model.service.NightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 晚归通报业务层实现
 * Created: 2020-04-18 14:05 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class NightServiceImpl implements NightService {
    @Autowired
    NightMapper nightMapper;
    @Override
    public List<NightDomain> selectById(String articleId) {
        return nightMapper.selectById(articleId);
    }

    @Override
    public void insertRecord(NightDomain nightDomain) {
        nightMapper.insertRecord(nightDomain);
    }
}
