package com.e3e4e20.model.mapper;

/*
 * Description: 接口持久层接口
 * Created: 2020-04-09 19:18 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.CtrlApisDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 接口持久层接口 -- sys_apis
 */
@Mapper
@Repository
public interface CtrlApisMapper {
    /**
     * 通过权限编号查询对应的接口
     * @param permId
     * @return PermDomain
     */
    List<CtrlApisDomain> selectById (@Param("permId") String permId);

    /**
     * 通过 表行号和权限编号 修改接口信息
     * @param map
     * @return int
     */
    int updateById (Map map);

    /**
     * 添加接口
     * @param ctrlApisDomain
     * @return int
     */
    int insertApi (CtrlApisDomain ctrlApisDomain);

    /**
     * 通过 表行号和权限编号 删除接口
     * @param permId
     * @return int
     */
    int deleteById (@Param("permId") String permId);
}
