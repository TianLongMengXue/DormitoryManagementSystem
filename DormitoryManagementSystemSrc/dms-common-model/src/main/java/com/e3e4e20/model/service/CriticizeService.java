package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.CriticizeDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 通报批评业务层接口
 * Created: 2020-04-18 13:57 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface CriticizeService {
    /**
     * 根据 文章编号 查询通报批评相关信息
     * @param articleId
     * @return List<CriticizeDomain>
     */
    List<CriticizeDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加通报批评记录
     * @param criticizeDomain
     */
    void insertRecord (CriticizeDomain criticizeDomain);
}
