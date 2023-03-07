package com.e3e4e20.ctrl.service;

import com.e3e4e20.common.entity.ResponseData;
import org.springframework.stereotype.Service;

import java.util.Map;

/*
 * Description: 控制台的菜单项加载业务层
 * Created: 2020-04-22 23:14 星期三
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public interface MenuService {
    /**
     * 获取控制台的菜单项
     * @return ResponseData
     */
    ResponseData getMenuItem (Map map);
}
