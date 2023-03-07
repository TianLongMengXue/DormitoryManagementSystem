package com.e3e4e20.common.pojo;

/*
 * Description: 用户权限实体类
 * Created: 2020-04-09 14:58 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户权限实体类
 *      {
 *          "permId": 权限编码
 *          "permName": 权限名称
 *          "permDesc": 权限描述
 *          "permCode": 权限编码
 *          "permType": 权限类型
 *          "parPerm": 父级权限
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermDomain implements Serializable {
    /**
     * 权限编码
     */
    private String permId;
    /**
     * 权限名称
     */
    private String permName;
    /**
     * 权限描述
     */
    private String permDesc;
    /**
     * 权限编码
     */
    private String permCode;
    /**
     * 权限类型 0菜单,1菜单+初始化接口,2功能按钮+接口
     */
    private Integer permType;
    /**
     * 父级权限
     */
    private String parPerm;
}
