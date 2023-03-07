package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.HomeIntroduceDomain;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 * Description: home页面宿管简介业务层接口
 * Created: 2020-04-19 14:28 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface HomeIntroduceService {
    /**
     * 获取宿管简介信息
     * @return
     */
    HomeIntroduceDomain getIntroduce();

    /**
     * 添加宿管简介
     * @param homeIntroduceDomain
     */
    void addIntroduce (HomeIntroduceDomain homeIntroduceDomain);

    /**
     * 修改宿管信息
     * @param map
     */
    void alterIntroduce (Map map);
}
