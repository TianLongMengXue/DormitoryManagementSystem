package com.e3e4e20.home.service;

import com.e3e4e20.common.entity.ResponseData;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 * Description: 文章详情页面业务层
 * Created: 2020-04-21 16:21 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface ArticleDetailService {
    ResponseData getArticleDetail (Map map);
}
