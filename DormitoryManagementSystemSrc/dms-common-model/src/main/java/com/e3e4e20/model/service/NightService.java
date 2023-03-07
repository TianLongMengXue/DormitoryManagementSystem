package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.CaseDomain;
import com.e3e4e20.common.pojo.NightDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 晚归通报业务层接口
 * Created: 2020-04-18 13:56 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface NightService {
    /**
     * 根据 文章编号 查询晚归通报信息
     * @param articleId
     * @return List<NightDomain>
     */
    List<NightDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加晚归通报记录
     * @param nightDomain
     */
    void insertRecord (NightDomain nightDomain);
}
