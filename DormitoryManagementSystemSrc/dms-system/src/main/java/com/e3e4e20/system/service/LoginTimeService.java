package com.e3e4e20.system.service;

import org.springframework.stereotype.Service;

/*
 * Description: 登录时间记录服务类
 * Created: 2020-04-16 13:56 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface LoginTimeService {
    /**
     * 根据用户id为用户添加登录时间
     * @param userId
     */
    void insertDate (String userId);
}
