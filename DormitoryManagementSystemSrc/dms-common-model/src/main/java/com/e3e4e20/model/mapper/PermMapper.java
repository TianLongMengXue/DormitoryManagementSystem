package com.e3e4e20.model.mapper;

/*
 * Description: 权限持久层接口
 * Created: 2020-04-09 15:52 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.pojo.PermDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 权限持久层接口 -- sys_perm
 */
@Mapper
@Repository
public interface PermMapper {
    /**
     * 通过权限编号查询对应的权限信息
     * @param permId
     * @return PermDomain
     */
    PermDomain selectById (@Param("permId") String permId);

    /**
     * 通过 权限编号 修改权限信息
     * @param map
     * @return int
     */
    int updateById (Map map);

    /**
     * 添加权限信息
     * @param permDomain
     * @return int
     */
    int insertPerm (PermDomain permDomain);

    /**
     * 通过权限编号删除权限信息
     * @param permId
     * @return int
     */
    int deleteById (@Param("permId") String permId);
}
