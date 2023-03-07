package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.ClassDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/*
 * Description: 班级持久层接口 -- ctrl_class
 * Created: 2020-05-07 11:52 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface ClassMapper {
    /**
     * 根据班级编号查询班级名称
     * @param classId
     * @return String
     */
    String selectNameById (@Param("classId") String classId);

    /**
     * 添加班级
     * @param classDomain
     * @return int
     */
    int insertClass (ClassDomain classDomain);
}
