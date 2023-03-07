package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.CriticizeDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Description: 通报批评持久层 -- result_criticize
 * Created: 2020-04-18 0:30 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface CriticizeMapper {
    /**
     * 根据 文章编号 查询通报批评相关信息
     * @param articleId
     * @return List<CriticizeDomain>
     */
    List<CriticizeDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加通报批评记录
     * @param criticizeDomain
     * @return int
     */
    int insertRecord (CriticizeDomain criticizeDomain);
}
