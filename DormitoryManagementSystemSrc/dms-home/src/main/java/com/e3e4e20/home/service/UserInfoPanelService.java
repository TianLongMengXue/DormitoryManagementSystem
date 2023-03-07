package com.e3e4e20.home.service;

import com.e3e4e20.common.entity.home.UserInfo;
import org.springframework.stereotype.Service;

/*
 * Description: 构造home页面需要显示用户信息
 * Created: 2020-04-15 23:59 星期三
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 构造home页面需要显示用户信息
 * 1. 获取用户基本信息
 * 2. 获取用户最近一次登录时间
 * 3. 封装成home页面所需要的对象
 */
@Service
public interface UserInfoPanelService {
    UserInfo userInfo (String userId);
}
