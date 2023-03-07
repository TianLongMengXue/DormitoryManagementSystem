package com.e3e4e20.ctrl.service.impl;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.common.entity.ctrl.Menu;
import com.e3e4e20.common.entity.ctrl.MenuItem;
import com.e3e4e20.common.pojo.CtrlMenuDomain;
import com.e3e4e20.common.pojo.PermDomain;
import com.e3e4e20.ctrl.service.MenuService;
import com.e3e4e20.model.mapper.*;
import com.e3e4e20.model.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/*
 * Description: 控制台的菜单项加载业务层
 * Created: 2020-04-22 23:18 星期三
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RolePermMapper rolePermMapper;
    @Autowired
    PermMapper permMapper;
    @Autowired
    CtrlMenuMapper ctrlMenuMapper;
    @Override
    public ResponseData getMenuItem(Map map) {
        // 获取当前用户的姓名
        String userId = userInfoService.selectNameById((String) map.get("userId"));
        // 获取当前用户的持有的角色编号
        List<String> roleIdList = userRoleMapper.selectRoleIdByUserId((String) map.get("userId"));
        // 封装菜单列表
        /*List<Map<String,Object>> menuList = new ArrayList<>();*/
        List<Menu<MenuItem>> menuList = new ArrayList<>();
        // 遍历角色编号列表
        for (String roleId:roleIdList) {
            // 获取角色持有的权限编号列表
            List<String> permIdList = rolePermMapper.selectPermIdByRoleId(roleId);
            // 遍历权限表号列表
            for (String permId:permIdList) {
                // 获取权限内容
                PermDomain permDomain = permMapper.selectById(permId);
                // 获取菜单内容
                CtrlMenuDomain menuDomain = ctrlMenuMapper.selectById(permId);
                // 封装菜单列表
                /*Map<String,Object> menu = new HashMap<>();
                menu.put("id", permDomain.getPermId());
                menu.put("name", permDomain.getPermName());
                menu.put("desc", permDomain.getPermDesc());
                menu.put("code", permDomain.getPermCode());
                menu.put("order", menuDomain.getMenuOrder());
                menu.put("icon", menuDomain.getMenuIcon());*/
                // 当菜单项为主菜单项时
                if (permDomain.getPermType() == 0 && permDomain.getParPerm() == null){
                    // 添加子菜单列表
                    Menu<MenuItem> menu = new Menu<>(permDomain.getPermId(), permDomain.getPermName(),
                            permDomain.getPermDesc(), permDomain.getPermCode(), menuDomain.getMenuIcon(),
                            menuDomain.getMenuOrder(), new ArrayList<>());
                    menuList.add(menu);
                }
                // 当菜单项为子菜单项时
                else if (permDomain.getPermType() == 1 || (permDomain.getPermType() == 0 && permDomain.getParPerm() != null)){
                    // 添加子菜单的路由路径
                    MenuItem menuItem = new MenuItem(permDomain.getPermId(), permDomain.getPermName(),
                            permDomain.getPermDesc(), permDomain.getPermCode(), menuDomain.getMenuIcon(),
                            menuDomain.getMenuOrder(), menuDomain.getMenuPath());
                    // 遍历菜单项将子菜单项添加待对应的菜单项中
                    for (Menu<MenuItem> item:menuList) {
                        if (item.getId().equals(permDomain.getParPerm())) {
                            item.getChildren().add(menuItem);
                        }
                    }
                }
            }
        }
        Map<String,Object> res = new HashMap<>();
        res.put("name", userId);
        res.put("menuList", menuList);
        return ResponseData.SUCCESS("init",res);
    }
}
