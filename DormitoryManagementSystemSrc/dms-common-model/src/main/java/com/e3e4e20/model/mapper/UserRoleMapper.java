package com.e3e4e20.model.mapper;

/*
 * Description: 用户关联角色表持久层接口
 * Created: 2020-04-09 14:15 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户关联角色表持久层接口 -- sys_user_role
 */
@Mapper
@Repository
public interface UserRoleMapper {
    /**
     * 通过用户的学号/职工号查询出对应的角色编号
     * @param userId
     * @return List<String>
     */
    List<String> selectRoleIdByUserId (@Param("userId") String userId);

    /**
     * 通过角色编号查询具有该角色身份的用户
     * @param roleId
     * @return List<String>
     */
    List<String> selectUserIdByRoleId (@Param("roleId") String roleId);

    /**
     * 为用户添加角色身份
     * @param map
     * @return int
     */
    int insertRelation (Map<String, Object> map);

    /**
     * 删除用户的角色身份
     * @param userId
     * @return int
     */
    int deleteRelation (@Param("userId") String userId);
}
