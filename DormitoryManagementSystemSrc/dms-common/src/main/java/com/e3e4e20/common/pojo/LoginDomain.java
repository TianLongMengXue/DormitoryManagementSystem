package com.e3e4e20.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 * Description: 登录表单实体类
 * Created: 2020-04-04 22:32 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 登录表单实体类
 *      {
 *          "userId": String 登录时使用的学号/职工号
 *          "userWord": String 登录时使用的密码
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDomain implements Serializable {
    /**
     * 登录时使用的学号/职工号
     */
    private String userId;
    /**
     * 登录时使用的密码
     */
    private String userWord;
}
