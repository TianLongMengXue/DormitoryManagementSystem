package com.e3e4e20.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/*
 * Description: 宿舍长持久层 --- ctrl_dor_head
 * Created: 2020-05-07 14:35 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface DorHeadMapper {
    /**
     * 根据宿舍编号查询宿舍长学号
     * @param dorId
     * @return String
     */
    String selectUserIdByDorId (@Param("dorId") String dorId);

    /**
     * 根据宿舍长学号查询宿舍编号
     * @param userId
     * @return String
     */
    String selectDorIdByUserId (@Param("userId") String userId);

    /**
     * 添加宿舍长
     * @param map
     * @return int
     */
    int insertRelation (Map<String,Object> map);
}
