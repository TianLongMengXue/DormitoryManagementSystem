package com.e3e4e20.model.mapper;

import com.e3e4e20.common.pojo.HomeIntroduceDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/*
 * Description: home页面宿管简介持久层接口
 * Created: 2020-04-19 14:10 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Mapper
@Repository
public interface HomeIntroduceMapper {
    /**
     * 查询简介内容
     * @return HomeIntroduceDomain
     */
    HomeIntroduceDomain select ();

    /**
     * 修改简介信息
     * @param map
     * @return
     */
    int update (Map map);

    /**
     * 添加简介
     * @param homeIntroduceDomain
     * @return
     */
    int insert (HomeIntroduceDomain homeIntroduceDomain);
}
