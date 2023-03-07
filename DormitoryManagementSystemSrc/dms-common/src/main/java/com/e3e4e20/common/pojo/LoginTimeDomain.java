package com.e3e4e20.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*
 * Description: 登录时间记录实体类
 * Created: 2020-04-16 13:08 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 登录时间记录实体类
 *      {
 *          "id": 表列名,自增,实体类不进行封装
 *          "userId": 学号/职工号
 *          "loginTime": 登录时间
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginTimeDomain implements Serializable {
    /**
     * 学号/职工号
     */
    private String userId;
    /**
     * 登录时间
     */
    private Date loginTime;
}
