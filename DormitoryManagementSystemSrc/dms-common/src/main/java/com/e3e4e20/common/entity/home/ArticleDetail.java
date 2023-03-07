package com.e3e4e20.common.entity.home;

/*
 * Description: 文章详情数据实体类
 * Created: 2020-04-21 17:03 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 文章详情数据实体类
 *      {
 *          "title": 文章标题
 *          "dataCol": 是否具有时间副标题
 *          "date": 检查时间
 *          "miniCol" 是否具有小标题
 *          "recordName": 记录的列名
 *          "rows": 记录内容列表
 *          "signature": 尾款署名
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetail<T> implements Serializable {
    /**
     * 文章标题
     */
    private String title;
    /**
     * 是否具有时间副标题
     */
    private Boolean dateCol;
    /**
     * 检查时间
     */
    private String date;
    /**
     * 是否具有小标题
     */
    private Boolean miniCol;
    /**
     * 记录的列名
     */
    private List<T> recordName;
    /**
     * 记录内容
     */
    private List<T> rows;
    /**
     * 尾款署名
     */
    private List<String> signature;
}
