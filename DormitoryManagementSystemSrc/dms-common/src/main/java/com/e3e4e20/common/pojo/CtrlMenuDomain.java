package com.e3e4e20.common.pojo;

/*
 * Description: 菜单项实体类
 * Created: 2020-04-09 15:30 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 菜单项实体类
 *      {
 *          "permId": 权限编码
 *          "menuIcon": 菜单项图标
 *          "menuOrder": 菜单项顺序
 *          "menuPath": 路由路径
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CtrlMenuDomain implements Serializable {
    /**
     * 权限编码
     */
    private String permId;
    /**
     * 菜单项图标
     */
    private String menuIcon;
    /**
     * 菜单项顺序
     */
    private Integer menuOrder;
    /**
     * 路由路径
     */
    private String menuPath;
}
