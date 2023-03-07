package com.e3e4e20.ctrl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 宿舍管理系统的控制台模块启动类
 * 控制台模块需要对控制台模块以及和控制台模块相关的内容进行加载处理
 * 需要对控制台目录下以及公共目录下的代码文件执行扫描注册
 * 未被扫描注册的代码文件不会在本模块内加载执行
 */
@SpringBootApplication(scanBasePackages = "com.e3e4e20")
@MapperScan("com.e3e4e20.model.mapper")
public class CtrlApplication {
    public static void main(String[] args) {
        SpringApplication.run(CtrlApplication.class, args);
    }
}
