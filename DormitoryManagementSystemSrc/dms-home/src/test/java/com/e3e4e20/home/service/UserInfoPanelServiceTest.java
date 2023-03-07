package com.e3e4e20.home.service;

import com.e3e4e20.common.entity.home.UserInfoName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/*
 * Description:
 * Created: 2020-04-16 14:19 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@SpringBootTest
public class UserInfoPanelServiceTest {
    @Resource
    UserInfoPanelService userInfoPanelService;
    @Test
    public void initUserInfoServiceTest  () {
        System.out.println(userInfoPanelService.userInfo("16478082"));
    }
    @Test
    public void homeUserInfoNameTest () {
        UserInfoName homeUserInfoName = new UserInfoName("学号");
        System.out.println(homeUserInfoName);
    }
}
