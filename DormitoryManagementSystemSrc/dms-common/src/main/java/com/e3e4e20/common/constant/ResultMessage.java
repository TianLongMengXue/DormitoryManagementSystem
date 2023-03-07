package com.e3e4e20.common.constant;

/*
 * Description: 自定义消息返回内容
 * Created: 2020-04-04 21:10 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
public class ResultMessage {
    public static final String ID_EMPTY_ERROR = "请输入学号/职工号！";
    public static final String ID_LENGTH_ERROR = "学号/职工号长度在 8 到 16 个字符！";
    public static final String ID_NULL_ERROR = "学号/职工号不存在";
    public static final String WORD_EMPTY_ERROR = "请输入密码！";
    public static final String WORD_LENGTH_ERROR = "密码长度在 8 到 16 个字符！";
    public static final String WORD_FORMAT_ERROR = "密码必须包含大小写字母、数字、特殊字符！";
    public static final String WORD_NULL_ERROR = "密码错误！";
    public static final String LOGIN_SUCCESS = "登录成功！";
    public static final String UNAUTHENTICATED = "请登录！";
    public static final String UNAUTHORIZED = "权限不足,无法访问！";
    public static final String LOGOUT_SUCCESS = "退出成功";
}
