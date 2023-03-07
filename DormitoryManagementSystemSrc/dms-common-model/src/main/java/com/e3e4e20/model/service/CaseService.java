package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.CaseDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 例检、抽检业务层接口
 * Created: 2020-04-18 13:52 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface CaseService {
    /**
     * 根据 文章编号 查询例检内容
     * @param articleId
     * @return List<CaseDomain>
     */
    List<CaseDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加例检、抽检记录
     * @param caseDomain
     */
    void insertRecord (CaseDomain caseDomain);
}
