package com.e3e4e20.model.service.impl;

import com.e3e4e20.model.mapper.LoginMapper;
import com.e3e4e20.model.service.UserWordCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Description: 密码校验服务实现类
 * Created: 2020-04-06 15:54 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class UserWordCheckServiceImpl implements UserWordCheckService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public boolean wordEmptyCheck(String userWord) {
        return userWord.equals("");
    }

    @Override
    public boolean wordLengthCheck(String userWord) {
        return userWord.length() > 16 || userWord.length() < 8;
    }

    @Override
    public boolean wordFormatCheck(String userWord) {
        return !userWord.matches("(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,16}");
    }

    @Override
    public boolean wordNullCheck(String userId, String userWord) {
        return null == loginMapper.selectByIdWord(userId, userWord);
    }
}
