package com.e3e4e20.model.service;

import org.springframework.stereotype.Service;

/*
 * Description: home页面文章类型的业务层
 * Created: 2020-04-21 16:17 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface HomeArticleTypeService {
    /**
     * 根据文章类型编号查询文章类型名称
     * @param articleType
     * @return
     */
    String getArticleTypeName (String articleType);
}
