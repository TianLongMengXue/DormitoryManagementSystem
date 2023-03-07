package com.e3e4e20.common.pojo;

/*
 * Description: 晚归通报实体类
 * Created: 2020-04-17 20:01 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 晚归通报实体类
 *      {
 *          "id": 表行号
 *          "articleId": 文章编号
 *          "dorNum": 宿舍
 *          "className": 班级
 *          "userName": 姓名
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NightDomain implements Serializable {
    /**
     * 表行号
     */
    private String id;
    /**
     * 文章编号
     */
    private String articleId;
    /**
     * 宿舍
     */
    private String dorNum;
    /**
     * 班级
     */
    private String className;
    /**
     * 姓名
     */
    private String userName;
}
