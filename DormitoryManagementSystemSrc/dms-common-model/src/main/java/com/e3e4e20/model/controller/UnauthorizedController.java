package com.e3e4e20.model.controller;

import com.e3e4e20.common.constant.ResultMessage;
import com.e3e4e20.common.entity.ResponseData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Description: 用户未被授予相应权限的情况下执行操作进行报错
 * Created: 2020-04-12 16:07 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */

/**
 * 用户未被授予相应权限的情况下执行操作进行报错
 */
@CrossOrigin
@RestController
public class UnauthorizedController {
    /**
     * 用户未被授予相应权限的情况下,执行未拥有的权限操作,提示用户未拥有相关权限
     * @return
     */
    @RequestMapping("/unauthorized")
    public ResponseData unauthorized (){
        return ResponseData.ERROR(ResultMessage.UNAUTHORIZED);
    }
}
