package com.e3e4e20.model.service;

import com.e3e4e20.common.pojo.HomeMenuDomain;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Description: home页面文章菜单服务类
 * Created: 2020-04-16 23:27 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * home页面文章菜单服务类
 * 1. 查询全部的菜单项
 */
@Service
public interface HomeMenuService {
    /**
     * 查询全部的菜单项
     * @return List<HomeMenuDomain>
     */
    List<HomeMenuDomain> selectAllMenu ();

    /**
     * 添加首页菜单项
     * @param homeMenuDomain
     */
    void insertMenu (HomeMenuDomain homeMenuDomain);

    /**
     * 删除首页菜单项
     * @param menuId
     */
    void deleteMenu (Integer menuId);
}
