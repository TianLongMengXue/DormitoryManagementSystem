package com.e3e4e20.system.mapper;

import com.e3e4e20.model.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Filename: com.e3e4e20.system.mapper
 * Description: 用户基本信息接口测试
 * Version: 1.0
 * Created: 2020-04-08 22:32 星期三
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void selectByIdTest () {
        System.out.println(userMapper.selectById("16478080").toString());
    }
}
