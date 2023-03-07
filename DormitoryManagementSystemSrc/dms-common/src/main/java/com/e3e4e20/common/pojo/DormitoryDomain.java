package com.e3e4e20.common.pojo;

/*
 * Description: 宿舍实体类
 * Created: 2020-04-06 22:48 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 宿舍实体类
 *      {
 *          "dorId": 宿舍编号
 *          "buildNum": 栋数
 *          "dorNum": 宿舍号
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormitoryDomain implements Serializable {
    /**
     * 宿舍编号
     */
    private String dorId;
    /**
     * 栋数
     */
    private String buildNum;
    /**
     * 宿舍号
     */
    private String dorNum;
}
