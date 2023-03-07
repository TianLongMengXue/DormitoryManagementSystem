package com.e3e4e20.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 * Description: 角色关联权限持久层接口类
 * Created: 2020-04-09 16:12 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 角色关联权限持久层接口类 -- sys_role_perm
 */
@Mapper
@Repository
public interface RolePermMapper {
    /**
     * 通过角色编号查询出对应的权限编号
     * @param roleId
     * @return List<String>
     */
    List<String> selectPermIdByRoleId (@Param("roleId") String roleId);

    /**
     * 通过权限编号查询具有该权限的角色编号
     * @param PermId
     * @return List<String>
     */
    List<String> selectRoleIdByPermId (@Param("PermId") String PermId);

    /**
     * 为角色添加权限
     * @param map
     * @return int
     */
    int insertRelation (Map<String, Object> map);

    /**
     * 删除角色的权限
     * @param RoleId
     * @return int
     */
    int deleteRelation (@Param("RoleId") String RoleId);
}
