package com.e3e4e20.common.pojo;

/*
 * Description: 接口实体类
 * Created: 2020-04-09 15:35 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 接口实体类
 *      {
 *          "permId": 权限编码
 *          "apiMethod": 请求方式
 *          "apiURL": 请求地址
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CtrlApisDomain implements Serializable {
    /**
     * 权限编码
     */
    private String permId;
    /**
     * 请求方式
     */
    private String apiMethod;
    /**
     * 请求地址
     */
    private String apiURL;
}
