package com.e3e4e20.model.mapper;

/*
 * Description: 菜单项持久层接口
 * Created: 2020-04-09 19:06 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.CtrlMenuDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 菜单项持久层接口 -- sys_menu
 */
@Mapper
@Repository
public interface CtrlMenuMapper {
    /**
     * 通过权限编号查询对应的菜单项
     * @param permId
     * @return CtrlMenuDomain
     */
    CtrlMenuDomain selectById (@Param("permId") String permId);

    /**
     * 通过 表行号和权限编号 修改菜单项信息
     * @param map
     * @return int
     */
    int updateById (Map map);

    /**
     * 添加菜单项
     * @param ctrlMenuDomain
     * @return int
     */
    int insertMenu (CtrlMenuDomain ctrlMenuDomain);

    /**
     * 通过 表行号和权限编号 删除菜单项
     * @param permId
     * @return int
     */
    int deleteById (@Param("permId") String permId);
}
