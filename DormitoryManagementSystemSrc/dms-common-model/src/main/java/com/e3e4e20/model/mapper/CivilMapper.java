package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.CivilDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Description: 文明宿舍持久层 -- result_civil
 * Created: 2020-04-18 0:23 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface CivilMapper {
    /**
     * 根据 文章编号 查询文明宿舍相关信息
     * @param articleId
     * @return
     */
    List<CivilDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加文明宿舍记录
     * @param civilDomain
     * @return
     */
    int insertRecord (CivilDomain civilDomain);
}
