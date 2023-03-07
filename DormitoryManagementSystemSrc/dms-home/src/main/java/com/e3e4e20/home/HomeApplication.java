package com.e3e4e20.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Filename: com.e3e4e20.home
 * Description: 宿舍管理系统的主页模块启动类
 * Version: 1.0
 * Created: 2020-04-15 15:02 星期三
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 宿舍管理系统的主页模块启动类
 * 主页模块需要对主页模块以及和主页模块相关的内容进行加载处理
 * 需要对主页目录下以及公共目录下的代码文件执行扫描注册
 * 未被扫描注册的代码文件不会在本模块内加载执行
 */
@SpringBootApplication(scanBasePackages = "com.e3e4e20")
@MapperScan("com.e3e4e20.model.mapper")
public class HomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomeApplication.class, args);
    }
}
