package com.e3e4e20.model.service;

/*
 * Description: 学号/职工号校验服务接口类
 * Created: 2020-04-05 1:49 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */

import org.springframework.stereotype.Service;

/**
 * 对用户的 学号/职工号 进行相关检验
 * 1. 为空检验
 * 2. 位数检验
 * 3. 存在检验
 */
@Service
public interface UserIdCheckService {
    /**
     * 学号/职工号 是否为空
     * @param userId
     * @return Boolean
     */
    boolean idEmptyCheck(String userId);

    /**
     * 学号/职工号 是否为 8 到 16 个字符长度
     * @param userId
     * @return Boolean
     */
    boolean idLengthCheck(String userId);

    /**
     * 学号/职工号 对应的用户是否存在于数据库中
     * @param userId
     * @return Boolean
     */
    boolean idNullCheck(String userId);

}
