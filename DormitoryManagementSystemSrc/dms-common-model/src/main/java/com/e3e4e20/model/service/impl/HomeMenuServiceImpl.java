package com.e3e4e20.model.service.impl;

import com.e3e4e20.common.pojo.HomeMenuDomain;
import com.e3e4e20.model.mapper.HomeMenuMapper;
import com.e3e4e20.model.service.HomeMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: home页面文章菜单服务类实现类
 * Created: 2020-04-16 23:30 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class HomeMenuServiceImpl implements HomeMenuService {
    @Autowired
    HomeMenuMapper homeMenuMapper;
    @Override
    public List<HomeMenuDomain> selectAllMenu() {
        return homeMenuMapper.selectAll();
    }

    @Override
    public void insertMenu(HomeMenuDomain homeMenuDomain) {
        homeMenuMapper.insertHomeMenu(homeMenuDomain);
    }

    @Override
    public void deleteMenu(Integer menuId) {
        homeMenuMapper.deleteHomeMenu(menuId);
    }
}
