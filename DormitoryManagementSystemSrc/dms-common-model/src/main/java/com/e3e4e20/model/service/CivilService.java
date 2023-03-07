package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.CivilDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 文明宿舍业务层接口
 * Created: 2020-04-18 13:57 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface CivilService {
    /**
     * 根据 文章编号 查询文明宿舍相关信息
     * @param articleId
     * @return
     */
    List<CivilDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加文明宿舍记录
     * @param civilDomain
     */
    void insertRecord (CivilDomain civilDomain);
}
