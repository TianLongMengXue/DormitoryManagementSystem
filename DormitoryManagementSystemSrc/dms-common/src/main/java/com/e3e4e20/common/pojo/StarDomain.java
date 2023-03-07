package com.e3e4e20.common.pojo;

/*
 * Description: 星级宿舍实体类
 * Created: 2020-04-17 20:10 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 星级宿舍实体类
 *      {
 *          "id": 表行号
 *          "articleId": 文章编号
 *          "dorNum": 宿舍
 *          "s1": 第一次
 *          "s2": 第二次
 *          "s3": 第三次
 *          "s4": 第四次
 *          "s5": 第五次
 *          "s6": 第六次
 *          "s7": 第七次
 *          "s8": 第八次
 *          "hygieneScore": 卫生得分
 *          "ruleScore": 纪律得分
 *          "aveScore": 得分
 *          "grade": 对应星级
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarDomain implements Serializable {
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
     * 第一次
     */
    private Integer s1;
    /**
     * 第二次
     */
    private Integer s2;
    /**
     * 第三次
     */
    private Integer s3;
    /**
     * 第四次
     */
    private Integer s4;
    /**
     * 第五次
     */
    private Integer s5;
    /**
     * 第六次
     */
    private Integer s6;
    /**
     * 第七次
     */
    private Integer s7;
    /**
     * 第八次
     */
    private Integer s8;
    /**
     * 卫生得分
     */
    private Double hygieneScore;
    /**
     * 纪律得分
     */
    private Double ruleScore;
    /**
     * 得分
     */
    private Double aveScore;
    /**
     * 对应星级
     */
    private String grade;
}
