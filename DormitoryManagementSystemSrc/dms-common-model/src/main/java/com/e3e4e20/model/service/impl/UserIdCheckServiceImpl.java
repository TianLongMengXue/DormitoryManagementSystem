package com.e3e4e20.model.service.impl;

import com.e3e4e20.model.mapper.LoginMapper;
import com.e3e4e20.model.service.UserIdCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Description: 登录校验服务实现类
 * Created: 2020-04-05 1:52 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class UserIdCheckServiceImpl implements UserIdCheckService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public boolean idEmptyCheck(String userId) {
        return userId.equals("");
    }

    @Override
    public boolean idLengthCheck(String userId) {
        return userId.length() > 16 || userId.length() < 8;
    }

    @Override
    public boolean idNullCheck(String userId) {
        return null == loginMapper.selectIdById(userId);
    }
}
