package com.e3e4e20.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
 * Description: 学生关联班级持久层 --- ctrl_stu_class
 * Created: 2020-05-07 13:10 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface StuClassMapper {
    /**
     * 根据班级编号查询学生学号
     * @param classId
     * @return List<String>
     */
    List<String> selectUserIdByClassId (@Param("classId") String classId);

    /**
     * 根据学生学号查询班级编号
     * @param userId
     * @return
     */
    String selectClassIdByUserId (@Param("userId") String userId);

    /**
     * 为班级添加学生
     * @param map
     * @return
     */
    int insertRelation (Map<String,Object> map);
}
