package com.e3e4e20.model.mapper;

/*
 * Description: 功能点(按钮)持久层接口
 * Created: 2020-04-09 19:25 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.CtrlPointDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 功能点(按钮)持久层接口 -- sys_point
 */
@Mapper
@Repository
public interface CtrlPointMapper {
    /**
     * 通过权限编号查询对应的功能点(按钮)
     * @param permId
     * @return PermDomain
     */
    List<CtrlPointDomain> selectById (@Param("permId") String permId);

    /**
     * 通过 权限编号 修改功能点(按钮)信息
     * @param map
     * @return int
     */
    int updateById (Map map);

    /**
     * 添加功能点(按钮)
     * @param ctrlPointDomain
     * @return int
     */
    int insertPoint (CtrlPointDomain ctrlPointDomain);

    /**
     * 通过 表行号和权限编号 删除功能点(按钮)
     * @param permId
     * @return int
     */
    int deleteById (@Param("permId") String permId);
}
