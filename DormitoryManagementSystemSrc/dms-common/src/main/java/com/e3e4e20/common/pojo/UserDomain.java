package com.e3e4e20.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*
 * Description: 登录用户的实体类
 * Created: 2020-04-04 22:32 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 登录用户的实体类
 *      {
 *          "userId": 用户的学号/职工号
 *          "userName": 用户的姓名
 *          "userTel": 手机号
 *          "userMail": 邮箱
 *          "createTime": 注册时间
 *          "collegeId": 学院编号
 *          "collegeName": 学院名称
 *      }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain implements Serializable {
    /**
     * 用户的学号/职工号
     */
    private String userId;
    /**
     * 用户的姓名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userTel;
    /**
     * 用户的邮箱
     */
    private String userMail;
    /**
     * 用户注册时间
     */
    private Date createTime;
    /**
     * 学院编号
     */
    private String collegeId;
    /**
     * 学院名称
     */
    private String collegeName;
}
