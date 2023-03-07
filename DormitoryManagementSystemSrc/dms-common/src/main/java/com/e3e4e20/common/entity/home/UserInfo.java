package com.e3e4e20.common.entity.home;

/*
 * Description: home页面用户信息实体类
 * Created: 2020-04-16 15:48 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * home页面用户信息实体类
 *      {
 *          "id": 学号/职工号
 *          "name": 姓名
 *          "college": 学院名称
 *          "lastTime": 最近一次登录时间
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    /**
     * 学号/职工号
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学院名称
     */
    private String college;
    /**
     * 最近一次登录时间
     */
    private String lastTime;
}
