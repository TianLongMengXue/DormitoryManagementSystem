package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.StuDorDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/*
 * Description: 学生关联宿舍持久层 --- ctrl_stu_dor
 * Created: 2020-05-07 14:08 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface StuDorMapper {
    /**
     * 根据学生学号查询宿舍号以及床位号
     * @param userId
     * @return StuDorDomain
     */
    StuDorDomain selectByUserId (@Param("userId") String userId);

    /**
     * 宿舍添加学生
     * @param stuDorDomain
     * @return int
     */
    int insertRelation (StuDorDomain stuDorDomain);
}
