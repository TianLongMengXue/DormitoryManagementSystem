package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.CheckClassDomain;
import com.e3e4e20.model.mapper.CheckClassMapper;
import com.e3e4e20.model.service.CheckClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 班级考评业务层实现
 * Created: 2020-04-18 14:03 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class CheckClassServiceImpl implements CheckClassService {
    @Autowired
    CheckClassMapper checkClassMapper;
    @Override
    public List<CheckClassDomain> selectById(String articleId) {
        return checkClassMapper.selectById(articleId);
    }

    @Override
    public void insertRecord(CheckClassDomain checkClassDomain) {
        checkClassMapper.insertRecord(checkClassDomain);
    }
}
