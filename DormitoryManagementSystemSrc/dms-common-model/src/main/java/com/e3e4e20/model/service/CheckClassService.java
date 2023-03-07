package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.CheckClassDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: 班级考评业务层接口
 * Created: 2020-04-18 13:57 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface CheckClassService {
    /**
     * 根据 文章编号 查询文明宿舍相关信息
     * @param articleId
     * @return List<CheckClassDomain>
     */
    List<CheckClassDomain> selectById (@Param("articleId") String articleId);

    /**
     * 添加文明宿舍记录
     * @param checkClassDomain
     */
    void insertRecord (CheckClassDomain checkClassDomain);
}
