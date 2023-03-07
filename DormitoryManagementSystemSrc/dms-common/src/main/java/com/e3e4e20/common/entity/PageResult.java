package com.e3e4e20.common.entity;

/*
 * Description: 分页对象
 * Created: 2020-04-04 20:32 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页对象
 *      {
 *          "code": Integer 200
 *          "info": true
 *          "message": String "查询成功！"
 *          "data": Object {
 *              total: Long //总条数
 *              rows: List<T> //数据列表
 *          }
 *      }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}
