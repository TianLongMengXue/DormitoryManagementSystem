package com.e3e4e20.model.controller;

/*
 * Description: 用户未登录情况下执行操作进行报错
 * Created: 2020-04-09 22:22 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import com.e3e4e20.common.constant.ResultMessage;
import com.e3e4e20.common.entity.ResponseData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户未登录情况下执行操作进行报错
 */
@CrossOrigin
@RestController
public class UnknownController {
    /**
     * 未登录的情况下访问需要登录的页面和使用需要登录的功能,提示用户进行登录
     * @return ResponseData
     */
    @RequestMapping("/unknown")
    public ResponseData unauthenticated (){
        return ResponseData.ERROR(ResultMessage.UNAUTHENTICATED);
    }
}
