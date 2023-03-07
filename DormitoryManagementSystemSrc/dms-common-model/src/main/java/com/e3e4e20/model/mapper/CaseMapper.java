package com.e3e4e20.model.mapper;

/*
 * Description: 例检、抽检持久层
 * Created: 2020-04-17 21:43 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.CaseDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 例检、抽检持久层 -- home_case
 */
@Mapper
@Repository
public interface CaseMapper {
    /**
     * 根据 文章编号 查询例检内容
     * @param articleId
     * @return List<CaseDomain>
     */
    List<CaseDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加例检、抽检记录
     * @param caseDomain
     * @return
     */
    int insertRecord (CaseDomain caseDomain);
}
