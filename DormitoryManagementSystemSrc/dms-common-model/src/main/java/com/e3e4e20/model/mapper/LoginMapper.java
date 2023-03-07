package com.e3e4e20.model.mapper;

/*
 * Description: 登录持久层接口类
 * Created: 2020-04-05 1:40 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.LoginDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 登录持久层接口类 - login
 */
@Mapper
@Repository
public interface LoginMapper {
    /**
     * 根据 userId 查询 userId 是否存在于 login 表中
     * @param userId
     * @return String
     */
    String selectIdById(@Param("userId") String userId);

    /**
     * 根据 userId 和 userWord 查询 userWord 是否存在于 login 表中
     * @param userId
     * @param userWord
     * @return LoginDomain
     */
    LoginDomain selectByIdWord(@Param("userId") String userId, @Param("userWord") String userWord);

    /**
     * 向 login 添加新的登录用户
     * @param loginDomain
     * @return int
     */
    int insertIdWord(LoginDomain loginDomain);

    /**
     * 从 login 删除登录用户
     * @param userId
     * @return int
     */
    int deleteById (@Param("userId") String userId);

    /**
     * 修改指定用户的登录密码
     * @param loginDomain
     * @return int
     */
    int updateById (LoginDomain loginDomain);
}
