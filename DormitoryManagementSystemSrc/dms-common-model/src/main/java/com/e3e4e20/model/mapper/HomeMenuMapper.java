package com.e3e4e20.model.mapper;

/*
 * Description: home页面的文章菜单持久层
 * Created: 2020-04-16 23:10 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.HomeMenuDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * home页面的文章菜单持久层
 */
@Mapper
@Repository
public interface HomeMenuMapper {
    /**
     * 查询所有菜单项
     * @return List<HomeMenuDomain>
     */
    List<HomeMenuDomain> selectAll ();

    /**
     * 添加首页文章菜单项
     * @param homeMenuDomain
     * @return
     */
    int insertHomeMenu (HomeMenuDomain homeMenuDomain);

    /**
     * 删除首页文章菜单项
     * @param menuId
     * @return
     */
    int deleteHomeMenu (@Param("menuId") Integer menuId);
}
