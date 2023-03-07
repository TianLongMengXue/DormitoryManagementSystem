package com.e3e4e20.system.service;
import com.e3e4e20.common.pojo.LoginDomain;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Service;

/*
 * Filename: com.e3e4e20.system.service
 * Description: 登录校验服务接口
 * Version: 1.0
 * Created: 2020-04-10 13:08 星期五
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 登录校验服务接口
 */
@Service
public interface LoginCheckService {
    /**
     * 1. 调用 学号/职工号 校验服务
     * 2. 调用 登录密码 校验服务
     * @Param loginDomain
     * @throws AuthenticationException
     */
    String loginCheck (LoginDomain loginDomain) throws AuthenticationException;
}
