package com.e3e4e20.common.entity.ctrl;

/*
 * Description: 控制台主菜单项
 * Created: 2020-05-06 21:58 星期三
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 控制台主菜单项
 *      {
 *          "id": 编号
 *          "name": 菜单名称
 *          "desc": 菜单描述
 *          "code": 菜单编码
 *          "icon": 菜单图标
 *          "order": 菜单顺序
 *          "children": 子菜单项列表
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu<T> implements Serializable {
    /**
     * 编号
     */
    private String id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单描述
     */
    private String desc;
    /**
     * 菜单编码
     */
    private String code;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单顺序
     */
    private Integer order;
    /**
     * 子菜单项列表
     */
    private List<T> children;
}
