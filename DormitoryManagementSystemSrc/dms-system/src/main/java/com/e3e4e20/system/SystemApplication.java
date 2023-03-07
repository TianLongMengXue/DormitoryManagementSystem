package com.e3e4e20.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Filename: com.e3e4e20.system
 * Description: 宿舍管理系统的系统模块启动类
 * Version: 1.0
 * Created: 2020-04-05 23:43 星期日
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 宿舍管理系统的系统模块启动类
 * 系统模块需要对系统模块以及和系统模块相关的内容进行加载处理
 * 需要对系统目录下以及公共目录下的代码文件执行扫描注册
 * 未被扫描注册的代码文件不会在本模块内加载执行
 */
@SpringBootApplication(scanBasePackages = "com.e3e4e20")
@MapperScan("com.e3e4e20.model.mapper")
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
