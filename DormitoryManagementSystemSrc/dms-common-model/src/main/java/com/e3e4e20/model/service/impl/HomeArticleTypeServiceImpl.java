package com.e3e4e20.model.service.impl;

import com.e3e4e20.model.mapper.HomeArticleTypeMapper;
import com.e3e4e20.model.service.HomeArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Description: home页面文章类型的业务层
 * Created: 2020-04-21 16:19 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class HomeArticleTypeServiceImpl implements HomeArticleTypeService {
    @Autowired
    HomeArticleTypeMapper homeArticleTypeMapper;
    @Override
    public String getArticleTypeName(String articleType) {
        return homeArticleTypeMapper.selectTypeById(articleType);
    }
}
