package com.e3e4e20.common.pojo;

/*
 * Description: 例检、抽检实体类
 * Created: 2020-04-17 19:55 星期五
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 例检、抽检实体类
 *      {
 *          "id": 表行号
 *          "articleId": 文章编号
 *          "buildNum": 栋数
 *          "dorNum": 宿舍
 *          "className": 班级
 *          "score": 卫生情况
 *          "caseDesc": 备注
 *          "classHead": 班主任
 *          "dorHead": 宿舍长
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseDomain implements Serializable {
    /**
     * 表行号
     */
    private String id;
    /**
     * 文章编号
     */
    private String articleId;
    /**
     * 栋数
     */
    private String buildNum;
    /**
     * 宿舍
     */
    private String dorNum;
    /**
     * 班级
     */
    private String className;
    /**
     * 卫生情况
     */
    private Double score;
    /**
     * 备注
     */
    private String caseDesc;
    /**
     * 班主任
     */
    private String classHead;
    /**
     * 宿舍长
     */
    private String dorHead;
}
