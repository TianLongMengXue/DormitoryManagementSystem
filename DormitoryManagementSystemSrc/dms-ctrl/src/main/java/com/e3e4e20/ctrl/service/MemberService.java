package com.e3e4e20.ctrl.service;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.common.pojo.LoginDomain;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 * Description: 个人中心业务层
 * Created: 2020-05-07 15:08 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface MemberService {
    /**
     * 获取个人信息
     * @param userId
     * @return ResponseData
     */
    ResponseData getUserInfo (String userId);

    /**
     * 修改个人信息 姓名 手机号 邮箱
     * @param map
     * @return
     */
    ResponseData alterUserInfo (Map<String,String> map);

    /**
     * 修改登录密码
     * @param loginDomain
     * @return
     */
    ResponseData alterUserWord (LoginDomain loginDomain);
}
