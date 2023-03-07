package com.e3e4e20.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 * Description: 文明宿舍实体类
 * Created: 2020-04-17 20:16 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 文明宿舍实体类
 *      {
 *          "id": 表行号
 *          "articleId": 文章编号
 *          "dorNum": 宿舍
 *          "collegeName": 学院名称
 *          "classHead": 班主任
 *          "assistant": 辅导员
 *          "grade": 等级
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CivilDomain implements Serializable {
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
     * 学院名称
     */
    private String collegeName;
    /**
     * 班主任
     */
    private String classHead;
    /**
     * 辅导员
     */
    private String assistant;
    /**
     * 等级
     */
    private String grade;
}
