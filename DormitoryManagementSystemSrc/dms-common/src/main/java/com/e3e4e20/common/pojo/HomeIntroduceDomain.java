package com.e3e4e20.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 * Description: home页面的宿管简介实体类
 * Created: 2020-04-19 13:56 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * home页面的宿管简介实体类
 *      {
 *          "menuId": 菜单编号
 *          "title": 标题
 *          "subTitle": 简介一
 *          "subImg": 合照一
 *          "qin": 简介二
 *          "qinImg": 合照二
 *          "mi": 简介三
 *          "miImg": 合照三
 *          "kao": 简介四
 *          "kaoImg": 合照四
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeIntroduceDomain implements Serializable {
    /**
     * 菜单编号
     */
    private Integer menuId;
    /**
     * 标题
     */
    private String title;
    /**
     * 简介一
     */
    private String subTitle;
    /**
     * 合照一
     */
    private String subImg;
    /**
     * 简介二
     */
    private String qin;
    /**
     * 合照二
     */
    private String qinImg;
    /**
     * 简介三
     */
    private String mi;
    /**
     * 合照三
     */
    private String miImg;
    /**
     * 简介四
     */
    private String kao;
    /**
     * 合照四
     */
    private String kaoImg;
}
