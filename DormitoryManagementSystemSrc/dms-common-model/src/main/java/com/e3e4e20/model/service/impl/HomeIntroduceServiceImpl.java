package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.HomeIntroduceDomain;
import com.e3e4e20.model.mapper.HomeIntroduceMapper;
import com.e3e4e20.model.service.HomeIntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 * Description: home页面宿管简介业务层实现类
 * Created: 2020-04-19 14:35 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class HomeIntroduceServiceImpl implements HomeIntroduceService {
    @Autowired
    HomeIntroduceMapper introduceMapper;
    @Override
    public HomeIntroduceDomain getIntroduce() {
        return introduceMapper.select();
    }

    @Override
    public void addIntroduce(HomeIntroduceDomain homeIntroduceDomain) {
        introduceMapper.insert(homeIntroduceDomain);
    }

    @Override
    public void alterIntroduce(Map map) {
        introduceMapper.update(map);
    }
}
