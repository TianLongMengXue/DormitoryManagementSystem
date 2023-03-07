package com.e3e4e20.home.service;

import com.e3e4e20.common.pojo.HomeMenuDomain;
import com.e3e4e20.model.service.HomeMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Description:
 * Created: 2020-04-17 10:25 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */
@SpringBootTest
public class HomeMenuServiceTest {
    @Autowired
    HomeMenuService homeMenuService;
    @Test
    public void selectAllTest () {
        System.out.println(homeMenuService.selectAllMenu());
    }
    @Test
    public void insertMenu (){
        homeMenuService.insertMenu(new HomeMenuDomain(0,"宿管简介"));
        homeMenuService.insertMenu(new HomeMenuDomain(1,"综合"));
        homeMenuService.insertMenu(new HomeMenuDomain(2,"例检"));
        homeMenuService.insertMenu(new HomeMenuDomain(3,"抽检"));
        homeMenuService.insertMenu(new HomeMenuDomain(4,"晚归"));
        homeMenuService.insertMenu(new HomeMenuDomain(5,"考评"));
        homeMenuService.insertMenu(new HomeMenuDomain(6,"宿管公告"));
        homeMenuService.insertMenu(new HomeMenuDomain(7,"下载"));
    }
}
