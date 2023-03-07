package com.e3e4e20.common.pojo;

/*
 * Description: 功能点(按钮)实体类
 * Created: 2020-04-09 15:36 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 功能点(按钮)实体类
 *      {
 *          "permId": 权限编码
 *          "pointStyle": 按钮样式
 *          "pointIcon": 按钮图标
 *          "pointStatus": 按钮状态
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CtrlPointDomain implements Serializable {
    /**
     * 权限编码
     */
    private String permId;
    /**
     * 按钮样式 primary success info warning danger
     */
    private String pointStyle;
    /**
     * 按钮图标 图标按钮 或 按钮文字
     */
    private String pointIcon;
    /**
     * 按钮状态 0 禁用或隐藏 1 正常使用
     */
    private Integer pointStatus;
}
