package com.e3e4e20.model.mapper;

/*
 * Description: 角色持久层接口类
 * Created: 2020-04-06 22:59 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.RoleDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 角色持久层接口类 -- sys_role
 */
@Mapper
@Repository
public interface RoleMapper {
    /**
     * 通过 roleId 查询角色名称
     * @param roleId
     * @return RoleDomain
     */
    RoleDomain selectNameById (@Param("roleId") String roleId);

    /**
     * 通过 roleId 修改角色名称
     * @param roleDomain
     * @return int
     */
    int updateById (RoleDomain roleDomain);

    /**
     * 添加角色
     * @param roleDomain
     * @return int
     */
    int insertRole (RoleDomain roleDomain);

    /**
     * 通过 roleId 删除角色
     * @param roleId
     * @return int
     */
    int deleteById (@Param("roleId") String roleId);
}
