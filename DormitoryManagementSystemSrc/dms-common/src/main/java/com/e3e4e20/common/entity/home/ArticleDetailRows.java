package com.e3e4e20.common.entity.home;

/*
 * Description: 文章详情记录列表内容
 * Created: 2020-04-21 17:13 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 文章详情记录列表内容
 *      {
 *          "miniTitle": 小标题
 *          "record": 记录内容
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailRows implements Serializable {
    /**
     * 小标题
     */
    private String miniTitle;
    /**
     * 记录内容
     */
    private List<Object> record;
}
