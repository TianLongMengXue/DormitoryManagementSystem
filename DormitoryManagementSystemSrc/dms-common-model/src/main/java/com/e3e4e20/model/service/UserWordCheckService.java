package com.e3e4e20.model.service;

/*
 * Description: 登录校验服务接口类
 * Created: 2020-04-06 15:48 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */

import org.springframework.stereotype.Service;

/**
 * 对登录用户的 密码 进行相关检验
 * 1. 为空检验
 * 2. 位数检验
 * 3. 格式校验
 * 4. 存在检验
 */
@Service
public interface UserWordCheckService {
    /**
     * 登录密码是否为空
     * @param userWord
     * @return Boolean
     */
    boolean wordEmptyCheck (String userWord);

    /**
     * 登录密码的长度是否在 8 到 16 个字符
     * @param userWord
     * @return Boolean
     */
    boolean wordLengthCheck (String userWord);

    /**
     * 登录密码是否包含大小写字母、数字、特殊字符
     * @param userWord
     * @return Boolean
     */
    boolean wordFormatCheck (String userWord);

    /**
     * 对应的用户在于数据库中密码是否正确
     * @param userId
     * @param userWord
     * @return Boolean
     */
    boolean wordNullCheck (String userId, String userWord);
}
