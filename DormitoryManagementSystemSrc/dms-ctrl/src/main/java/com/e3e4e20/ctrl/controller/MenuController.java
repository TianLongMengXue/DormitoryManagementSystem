package com.e3e4e20.ctrl.controller;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.ctrl.service.MenuService;
import com.e3e4e20.model.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
 * Description: 控制台的菜单项加载控制器
 * Created: 2020-04-22 23:12 星期三
 * Author: DreamSnow·Draco
 * Company: none
 * */
@CrossOrigin
@RestController
@RequestMapping("/ctrl")
public class MenuController extends BaseController {
    @Autowired
    MenuService menuService;
    @RequestMapping("/menu")
    public ResponseData menu () {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        return menuService.getMenuItem(map);
    }
}
