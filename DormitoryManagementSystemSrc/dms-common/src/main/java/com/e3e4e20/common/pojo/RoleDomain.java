package com.e3e4e20.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 * Description: 角色实体类
 * Created: 2020-04-06 22:51 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 角色实体类
 *      {
 *          "roleId": 角色编号
 *          "roleName": 角色名称
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDomain implements Serializable {
    /**
     * 角色编号
     */
    private String roleId;
    /**
     * 身份名
     */
    private String roleName;
}
