package com.e3e4e20.home.service.impl;

import com.e3e4e20.common.entity.home.UserInfo;
import com.e3e4e20.common.pojo.UserDomain;
import com.e3e4e20.home.service.UserInfoPanelService;
import com.e3e4e20.home.service.LoginTimeService;
import com.e3e4e20.model.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/*
 * Description: 初始化home页用户信息服务实现类
 * Created: 2020-04-16 0:00 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class UserInfoPanelServiceImpl implements UserInfoPanelService {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    LoginTimeService loginTimeService;
    @Override
    public UserInfo userInfo(String userId) {
        UserDomain userDomain = userInfoService.selectUserInfo(userId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /*Map<Object, Object> userinfo = new HashMap<Object, Object>();
        userinfo.put("id",userDomain.getUserId());
        userinfo.put("name",userDomain.getUserName());
        userinfo.put("college",userDomain.getCollegeName());
        userinfo.put("lastTime",lastTime);*/
        return new UserInfo(userDomain.getUserId(),userDomain.getUserName(),userDomain.getCollegeName(), simpleDateFormat.format(loginTimeService.lastTime(userId)));
    }
}
