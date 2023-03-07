package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.NightDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Description: 晚归通报持久层 -- result_night
 * Created: 2020-04-17 23:51 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface NightMapper {
    /**
     * 根据 文章编号 查询晚归通报信息
     * @param articleId
     * @return List<NightDomain>
     */
    List<NightDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加晚归通报记录
     * @param nightDomain
     * @return int
     */
    int insertRecord (NightDomain nightDomain);
}
