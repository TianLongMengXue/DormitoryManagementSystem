package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.StarDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Description: 星级宿舍持久层 -- result_star
 * Created: 2020-04-18 0:09 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface StarMapper {
    /**
     * 根据 文章编号 查询星级宿舍信息
     * @param articleId
     * @return List<StarDomain>
     */
    List<StarDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加星级宿舍记录
     * @param starDomain
     * @return
     */
    int insertRecord (StarDomain starDomain);
}
