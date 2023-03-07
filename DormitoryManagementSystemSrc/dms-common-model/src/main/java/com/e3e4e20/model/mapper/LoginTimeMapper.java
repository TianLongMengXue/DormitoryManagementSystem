package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.LoginTimeDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/*
 * Description: 登录时间记录持久层
 * Created: 2020-04-16 13:23 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface LoginTimeMapper {
    /**
     * 根据学号/职工号查询登录时间
     * @param userId
     * @return Date
     */
    Date selectById (@Param("userId") String userId);

    /**
     * 添加登录时间记录
     * @param loginTimeDomain
     * @return int
     */
    int insertDate (LoginTimeDomain loginTimeDomain);
}
