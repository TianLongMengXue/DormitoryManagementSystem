package com.e3e4e20.common.pojo;

/*
 * Description: 学生关联宿舍实体类
 * Created: 2020-05-07 13:59 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 学生关联宿舍实体类
 *      {
 *          "userId": 学号
 *          "dorId": 宿舍编号
 *          "bedNum" 床位号
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuDorDomain implements Serializable {
    /**
     * 学号
     */
    private String userId;
    /**
     * 宿舍编号
     */
    private String dorId;
    /**
     * 床位号
     */
    private Integer bedNum;
}
