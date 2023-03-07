package com.e3e4e20.home.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/*
 * Description: 登录时间记录服务类
 * Created: 2020-04-16 13:39 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface LoginTimeService {
    /**
     * 根据用户的id获取用户的最近一次登录时间
     * @param userId
     * @return
     */
    Date lastTime (String userId);
}
