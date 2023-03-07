package com.e3e4e20.home.service;

import com.e3e4e20.common.entity.ResponseData;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 * Description: 将数据库内返回的文章信息进行格式化操作业务接口
 * Created: 2020-04-18 19:40 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface ArticleListService {

    /**
     * 根据条件获取文章信息
     * @param map
     * @return
     */
    ResponseData articleList(Map<String, Object> map);
}
