package com.e3e4e20.system.service.impl;

import com.e3e4e20.common.constant.ResultMessage;
import com.e3e4e20.common.pojo.LoginDomain;
import com.e3e4e20.model.service.UserIdCheckService;
import com.e3e4e20.model.service.UserWordCheckService;
import com.e3e4e20.system.service.LoginCheckService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Filename: com.e3e4e20.system.service.impl
 * Description: 登录校验服务接口实现类
 * Version: 1.0
 * Created: 2020-04-10 13:21 星期五
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 登录校验服务接口实现类
 */
@Service
public class LoginCheckServiceImpl implements LoginCheckService {
    @Autowired
    private UserIdCheckService userIdCheckService;
    @Autowired
    private UserWordCheckService userWordCheckService;
    @Override
    public String loginCheck(LoginDomain loginDomain) throws AuthenticationException {
        // 获取 userId 和 userWord
        String userId = loginDomain.getUserId();
        String userWord = loginDomain.getUserWord();
        // 1. 调用 service 提供的校验方法进行学号/职工号校验
        // 1.1 学号/职工号 为空校验
        if (userIdCheckService.idEmptyCheck(userId)) {
            throw new AuthenticationException(ResultMessage.ID_EMPTY_ERROR);
        }
        // 1.2 学号/职工号 位数校验
        if (userIdCheckService.idLengthCheck(userId)) {
            throw new AuthenticationException(ResultMessage.ID_LENGTH_ERROR);
        }
        // 1.3 学号/职工号 存在校验
        if (userIdCheckService.idNullCheck(userId)) {
            throw new AuthenticationException(ResultMessage.ID_NULL_ERROR);
        }
        // 2. 调用 service 提供的校验方法进行密码校验
        // 2.1 密码 为空校验
        if (userWordCheckService.wordEmptyCheck(userWord)) {
            throw new AuthenticationException(ResultMessage.WORD_EMPTY_ERROR);
        }
        // 2.2 密码 位数校验
        if (userWordCheckService.wordLengthCheck(userWord)) {
            throw new AuthenticationException(ResultMessage.WORD_LENGTH_ERROR);
        }
        // 2.3 密码格式 校验
        if (userWordCheckService.wordFormatCheck(userWord)) {
            throw new AuthenticationException(ResultMessage.WORD_FORMAT_ERROR);
        }
        // 2.4 密码 加密 数据库中密码是加密之后才存储的 使用的是shiro提供的 Md5Hash 加密 (密码, 盐, 加密的迭代次数)
        String userWordMD5 = new Md5Hash(userWord, userId, 3).toBase64();
        // 2.5 密码存在校验
        if (userWordCheckService.wordNullCheck(userId, userWordMD5)){
            throw new AuthenticationException(ResultMessage.WORD_NULL_ERROR);
        }

        /*try {
            // 3. 构造登录令牌 UsernamePasswordToken (封装学号/职工号和密码)
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userId, userWordMD5);
            // 4. 创建Subject (创建当前"用户",即用户主体)
            Subject subject = SecurityUtils.getSubject();
            // 5. 调用shiro的login方法,进入UserRealm进行用户认证(登录验证)
            subject.login(usernamePasswordToken);
            // 6. 获得shiro为当前用户的生成的sessionId (作为token使用)
            String token = (String) subject.getSession().getId();
            // 7. 封装数据响应给前端处理
            return ResponseData.SUCCESS(ResultMessage.LOGIN_SUCCESS, token);
        } catch (AuthenticationException message) {
            // 8. 捕获异常错误并返回给前端
            return ResponseData.ERROR(message.getMessage());
        }*/

        return userWordMD5;
    }
}
