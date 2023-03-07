package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.UserDomain;
import com.e3e4e20.model.mapper.UserMapper;
import com.e3e4e20.model.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 * Description: 用户信息服务接口
 * Created: 2020-04-15 15:40 星期三
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDomain selectUserInfo(String userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public String selectNameById(String userId) {
        return userMapper.selectNameById(userId);
    }

    @Override
    public void update(Map map) {
        userMapper.updateById(map);
    }
}
