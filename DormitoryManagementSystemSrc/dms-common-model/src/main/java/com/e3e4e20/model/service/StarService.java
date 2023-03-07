package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.StarDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 星级宿舍业务层
 * Created: 2020-04-18 13:56 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface StarService {
    /**
     * 根据 文章编号 查询星级宿舍信息
     * @param articleId
     * @return List<StarDomain>
     */
    List<StarDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加星级宿舍记录
     * @param starDomain
     */
    void insertRecord (StarDomain starDomain);
}
