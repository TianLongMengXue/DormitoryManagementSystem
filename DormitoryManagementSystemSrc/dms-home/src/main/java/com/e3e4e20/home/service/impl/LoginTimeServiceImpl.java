package com.e3e4e20.home.service.impl;

import com.e3e4e20.home.service.LoginTimeService;
import com.e3e4e20.model.mapper.LoginTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/*
 * Description: 查询用户登录时间记录
 * Created: 2020-04-16 14:13 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class LoginTimeServiceImpl implements LoginTimeService {
    @Autowired
    LoginTimeMapper loginTimeMapper;
    @Override
    public Date lastTime(String userId) {
        return loginTimeMapper.selectById(userId);
    }
}
