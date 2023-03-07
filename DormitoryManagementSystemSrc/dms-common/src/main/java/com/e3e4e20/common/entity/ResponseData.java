package com.e3e4e20.common.entity;

/*
 * Description: 数据响应对象
 * Created: 2020-04-04 20:37 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据响应对象
 *    {
 *      "code": Integer 状态码
 *      "info": Boolean 指令执行成功否
 *      "message": String 返回信息
 *      "data": Object {
 *          //返回数据
 *      }
 *    }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    /*
    * 200: success
    * 400: failure
    * */
    private Integer code;
    /*
     * true: 指令执行成功
     * false: 指令执行失败
     */
    private Boolean info;
    /*
    * code 和 info 对应的属性值的文字说明
    * */
    private String message;
    /*
    * 返回给前端的数据
    * */
    private Object data;

    /**
     * 指令执行成功
     * code 200
     * info true
     * @param message
     * @param data
     * @return ResponseData
     */
    public static ResponseData SUCCESS(String message, Object data){
         return new ResponseData(200, true, message, data);
    }

    /**
     * 指令执行失败
     * code 400
     * info false
     * @param message
     * data null
     * @return ResponseData
     */
    public static ResponseData FAILURE(String message) {
        return new ResponseData(400, false, message, null);
    }

    /**
     * 抛出异常
     * code 500
     * info false
     * @param message
     * data null
     * @return ResponseData
     */
    public static ResponseData ERROR(String message) {
        return new ResponseData(500, false, message, null);
    }
}
