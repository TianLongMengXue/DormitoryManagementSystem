package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.StarDomain;
import com.e3e4e20.model.mapper.StarMapper;
import com.e3e4e20.model.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description:
 * Created: 2020-04-18 14:05 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class StarServiceImpl implements StarService {
    @Autowired
    StarMapper starMapper;
    @Override
    public List<StarDomain> selectById(String articleId) {
        return starMapper.selectById(articleId);
    }

    @Override
    public void insertRecord(StarDomain starDomain) {
        starMapper.insertRecord(starDomain);
    }
}
