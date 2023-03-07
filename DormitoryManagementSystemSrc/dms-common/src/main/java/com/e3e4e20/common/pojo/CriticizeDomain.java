package com.e3e4e20.common.pojo;

/*
 * Description: 通报批评实体类
 * Created: 2020-04-17 20:59 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通报批评实体类
 *      {
 *          "id": 表行号
 *          "articleId": 文章编号
 *          "checkTime": 检查时间
 *          "className": 班级
 *          "userName": 姓名
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriticizeDomain implements Serializable {
    /**
     * 表行号
     */
    private String id;
    /**
     * 文章编号
     */
    private String articleId;
    /**
     * 检查时间
     */
    private String checkTime;
    /**
     * 班级
     */
    private String className;
    /**
     * 姓名
     */
    private String userName;
}
