package com.e3e4e20.common.pojo;

/*
 * Description: 班级实体类
 * Created: 2020-04-06 22:44 星期一
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 班级实体类:
 *      {
 *          "classId": 班级编号
 *          "className": 班级名称
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassDomain implements Serializable {
    /**
     * 班级编号
     */
    private String classId;
    /**
     * 班级名称
     */
    private String className;
}
