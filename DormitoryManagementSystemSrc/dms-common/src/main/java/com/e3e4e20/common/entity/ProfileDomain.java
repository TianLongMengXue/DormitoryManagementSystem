package com.e3e4e20.common.entity;

/*
 * Description: Realm的安全数据
 * Created: 2020-04-06 23:00 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.PermDomain;
import com.e3e4e20.common.pojo.RoleDomain;
import com.e3e4e20.common.pojo.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

/**
 * Realm的安全数据实体类
 *      {
 *          "userId": 用户的学号/职工号
 *          "collegeName": 学院名称
 *          "collegeId": 学院编号
 *          "roles": Set<String> 角色
 *          "menus": Set<String> 菜单项
 *          "apis": Set<String> 接口
 *          "points": Set<String> 功能点(按钮)
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDomain implements Serializable {
    /**
     * 用户的学号/职工号
     */
    private String userId;
    /**
     * 学院编号
     */
    private String collegeId;
    /**
     * 学院名称
     */
    private String collegeName;
    /**
     * 角色、菜单、接口、权限的封装
     */
    Map<String, Object> roles = new HashMap<>();

    public ProfileDomain (UserDomain userDomain, List<PermDomain> permDomains, List<RoleDomain> roleDomains){
        this.userId = userDomain.getUserId();
        this.collegeId = userDomain.getCollegeId();
        this.collegeName = userDomain.getCollegeName();
        Set<String> menus = new HashSet<>();
        Set<String> points = new HashSet<>();
        Set<String> apis = new HashSet<>();
        Set<String> roles = new HashSet<>();
        for (PermDomain permDomain : permDomains){
            String permId = permDomain.getPermId();
            if (permDomain.getPermType() == 0) {
                menus.add(permId);
            } else if (permDomain.getPermType() == 1) {
                points.add(permId);
            } else {
                apis.add(permId);
            }
        }
        for (RoleDomain roleDomain : roleDomains){
            roles.add(roleDomain.getRoleId());
        }
        this.roles.put("roles",roles);
        this.roles.put("menus",menus);
        this.roles.put("points",points);
        this.roles.put("apis",apis);
    }
}
