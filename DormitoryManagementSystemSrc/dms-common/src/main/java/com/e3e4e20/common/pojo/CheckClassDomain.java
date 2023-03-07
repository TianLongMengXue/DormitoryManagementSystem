package com.e3e4e20.common.pojo;

/*
 * Description: 班级考评实体类
 * Created: 2020-04-17 20:39 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 班级考评实体类
 *      {
 *          "id": 表行号
 *          "articleId": 文章编号
 *          "classHead": 班主任
 *          "className": 班级
 *          "dorCount": 宿舍总数
 *          "checkCount": 检查次数
 *          "goodCount": 好寝个数
 *          "goodScore": 好寝得分
 *          "badCount": 差寝个数
 *          "badScore": 差寝扣分
 *          "bedCount": 未叠被子人数
 *          "bedScore": 未叠被子扣分
 *          "nightCount": 晚归缺寝人数
 *          "nightScore": 晚归缺寝扣分
 *          "banCount": 违禁物品
 *          "banScore": 违禁物品扣分
 *          "criticizeCount": 通报批评人数
 *          "criticizeScore": 通报批评扣分
 *          "praiseCount": 通报表扬人数
 *          "praiseScore": 通报表扬得分
 *          "finalScore": 考评得分
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckClassDomain implements Serializable {
    /**
     * 表行号
     */
    private String id;
    /**
     * 文章编号
     */
    private String articleId;
    /**
     * 班主任
     */
    private String classHead;
    /**
     * 班级
     */
    private String className;
    /**
     * 宿舍总数
     */
    private Integer dorCount;
    /**
     * 检查次数
     */
    private Integer checkCount;
    /**
     * 好寝个数
     */
    private Integer goodCount;
    /**
     * 好寝得分
     */
    private Double goodScore;
    /**
     * 差寝个数
     */
    private Integer badCount;
    /**
     * 差寝扣分
     */
    private Double badScore;
    /**
     * 未叠被子人数
     */
    private Integer bedCount;
    /**
     * 未叠被子扣分
     */
    private Double bedScore;
    /**
     * 晚归缺寝人数
     */
    private Integer nightCount;
    /**
     * 晚归缺寝扣分
     */
    private Double nightScore;
    /**
     * 违禁物品
     */
    private Integer banCount;
    /**
     * 违禁物品扣分
     */
    private Double banScore;
    /**
     * 通报批评人数
     */
    private Integer criticizeCount;
    /**
     * 通报批评扣分
     */
    private Double criticizeScore;
    /**
     * 通报表扬人数
     */
    private Integer praiseCount;
    /**
     * 通报表扬得分
     */
    private Double praiseScore;
    /**
     * 考评得分
     */
    private Double finalScore;
}
