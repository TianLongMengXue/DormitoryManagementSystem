package com.e3e4e20.model.mapper;

/*
 * Description: 用户持久层接口类
 * Created: 2020-04-05 1:41 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Map;

/**
 * 用户持久层接口类 - sys_user
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 根据 userId 查询用户的基本信息
     * @param userId
     * @return UserDomain
     */
    UserDomain selectById (@Param("userId") String userId);

    /**
     * 根据 userId 查询用户的姓名
     * @param userId
     * @return String
     */
    String selectNameById (@Param("userId") String userId);

    /**
     * 根据 userId 修改用户基本信息
     * @param map
     * @return int
     */
    int updateById (Map map);

    /**
     * 添加用户基本信息
     * @param userDomain
     * @return int
     */
    int insertUser (UserDomain userDomain);

    /**
     * 根据 userId 删除用户基本信息
     * @param userId
     * @return int
     */
    int deleteById (@Param("userId") String userId);
}
