package com.e3e4e20.common.pojo;

/*
 * Description: home页面的文章菜单实体类
 * Created: 2020-04-16 23:11 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * home页面的文章菜单实体类
 *      {
 *          "menuId": 菜单编号
 *          "menuName": 菜单名称
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeMenuDomain implements Serializable {
    /**
     * 菜单编号
     * 0 1 2 3 4 5 6 7
     */
    private Integer menuId;
    /**
     * 0:简介,1:综合,2:例检,3:抽检,4:晚归,5:考评,6:宿管公告,7:下载
     */
    private String MenuName;
}
