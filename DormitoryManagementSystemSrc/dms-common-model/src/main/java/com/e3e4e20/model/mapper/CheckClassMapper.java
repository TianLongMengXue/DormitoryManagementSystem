package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.CheckClassDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Description: 班级考评持久层 -- result_check_class
 * Created: 2020-04-18 0:35 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface CheckClassMapper {
    /**
     * 根据 文章编号 查询文明宿舍相关信息
     * @param articleId
     * @return List<CheckClassDomain>
     */
    List<CheckClassDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加文明宿舍记录
     * @param checkClassDomain
     * @return int
     */
    int insertRecord (CheckClassDomain checkClassDomain);
}
