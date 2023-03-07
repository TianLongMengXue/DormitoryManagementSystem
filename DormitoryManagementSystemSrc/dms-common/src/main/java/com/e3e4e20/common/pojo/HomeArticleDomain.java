package com.e3e4e20.common.pojo;

/*
 * Description: home页面文章实体类
 * Created: 2020-04-17 18:25 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * home页面文章实体类
 *      {
 *          "articleId": 文章编号
 *          "collegeId": 学院编号
 *          "menuId": 菜单编号
 *          "articleTime": 文章发布时间
 *          "checkTime": 检查时间
 *          "articleTitle": 文章标题
 *          "articleDesc": 文章说明
 *          "articlePost": 文章发布者
 *          "articleType": 文章类型
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeArticleDomain implements Serializable {
    /**
     * 文章编号
     */
    private String articleId;
    /**
     * 学院编号
     */
    private String collegeId;
    /**
     * 菜单编号
     */
    private Integer menuId;
    /**
     * 文章发布时间
     */
    private Date  articleTime;
    /**
     * 检查时间
     */
    private Date checkTime;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章说明
     */
    private String articleDesc;
    /**
     * 文章发布者
     */
    private String articlePost;
    /**
     * 文章类型
     * 1252111655584735232 例检、抽检 case
     * 1252111661351903232 晚归 night
     * 1252111665160331264 通报 criticize
     * 1252111668083761152 星级 star
     * 1252111671279820800 文明 civil
     * 1252111674438131712 班级考评 checkClass
     */
    private String articleType;
}
