package com.e3e4e20.common.exception;

/*
 * Description: 自定义异常类
 * Created: 2020-04-06 11:59 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */


/**
 * 自定义异常类 ==> 继承 Exception
 * 用来抛出一些自定义的的错误,方便构造前端响应
 * 自定义错误 ResultMessage
 * 前端响应 ResponseData
 */
public class MessageException extends Exception {

    public MessageException(String message) {
        super(message);
    }
}
