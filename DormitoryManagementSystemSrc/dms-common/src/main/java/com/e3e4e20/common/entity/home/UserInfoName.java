package com.e3e4e20.common.entity.home;

/*
 * Description: home页面的用户信息的信息名称
 * Created: 2020-04-16 22:14 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import java.io.Serializable;

/**
 * home页面的用户信息的信息名称
 *      {
 *          "id": 学号 职工号
 *          "name": 姓名
 *          "college": 学院
 *          "lastTime": 上一次登录
 *      }
 */
public class UserInfoName implements Serializable {
    private String id;
    private String name = "姓名：";
    private String college = "学院：";
    private String lastTime = "上次登录：";

    public UserInfoName() {}

    public UserInfoName(String id) {
        this.id = id+"：";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public String toString() {
        return "HomeUserInfoName{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", lastTime='" + lastTime + '\'' +
                '}';
    }
}
