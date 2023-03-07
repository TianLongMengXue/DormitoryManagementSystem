package com.e3e4e20.common.entity.home;

/*
 * Description: 文章详情列名
 * Created: 2020-04-21 17:11 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 文章详情列名
 *      {
 *          label: 列名_CN
 *          value: 列名_EN
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailRecordName implements Serializable {
    /**
     * 列名_CN
     */
    private String label;
    /**
     * 列名_EN
     */
    private String value;
}
