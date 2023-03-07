package com.e3e4e20.system.service.impl;

import com.e3e4e20.common.pojo.LoginTimeDomain;
import com.e3e4e20.model.mapper.LoginTimeMapper;
import com.e3e4e20.system.service.LoginTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/*
 * Description: 登录时间记录服务类
 * Created: 2020-04-16 13:58 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class LoginTimeServiceImpl implements LoginTimeService {
    @Autowired
    LoginTimeMapper loginTimeMapper;
    @Override
    public void insertDate(String userId) {
        loginTimeMapper.insertDate(new LoginTimeDomain(userId, new Date()));
    }
}
