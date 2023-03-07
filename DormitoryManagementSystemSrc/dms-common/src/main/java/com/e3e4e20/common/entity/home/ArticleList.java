package com.e3e4e20.common.entity.home;

/*
 * Description: home页面文章列表实体类
 * Created: 2020-04-18 19:50 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * home页面文章列表实体类
 *      {
 *          "id": 文章编号
 *          "type": 文章类型
 *          "date": 发布日期
 *          "title": 文章标题
 *          "desc": 文章简述
 *          "post": 发布者
 *      }
 */
@Data
@NoArgsConstructor
public class ArticleList implements Serializable {
    /**
     * 文章编号
     */
    private String id;
    /**
     * 文章类型
     */
    private String type;
    /**
     * 发布日期
     */
    private String date;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章简述
     */
    private String desc;
    /**
     * 发布者
     */
    private String post;

    public ArticleList(String id, String date, String title, String desc, String post) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.desc = desc;
        this.post = "posted @ " + post;
    }

    public void setPost (String post){
        this.post = "posted @ " + post;
    }
}
