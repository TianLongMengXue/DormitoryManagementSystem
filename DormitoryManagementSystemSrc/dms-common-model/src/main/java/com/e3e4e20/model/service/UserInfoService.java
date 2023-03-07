package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.UserDomain;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 * Description: 用户信息服务接口
 * Created: 2020-04-15 15:37 星期三
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 用户信息服务接口
 */
@Service
public interface UserInfoService {
    /**
     * 查询用户基本信息
     */
    UserDomain selectUserInfo(String userId);

    /**
     * 查询用户姓名
     */
    String selectNameById(String userId);

    /**
     * 修改用户信息
     */
    void update (Map map);
}
