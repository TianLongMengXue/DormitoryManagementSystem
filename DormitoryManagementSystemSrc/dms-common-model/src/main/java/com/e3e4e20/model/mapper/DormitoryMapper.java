package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.DormitoryDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/*
 * Description: 宿舍持久层 --- ctrl_dor
 * Created: 2020-04-06 22:59 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface DormitoryMapper {
    /**
     * 根据宿舍编号查询宿舍信息
     * @param dorId
     * @return DormitoryDomain
     */
    DormitoryDomain selectById (@Param("dorId") String dorId);

    /**
     * 添加宿舍
     * @param dormitoryDomain
     * @return int
     */
    int insertRelation (DormitoryDomain dormitoryDomain);
}
