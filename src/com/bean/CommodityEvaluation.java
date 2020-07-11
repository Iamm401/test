package com.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 商品评价表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommodityEvaluation {
	//商品编号
    private Integer commodity_id;
    //用户编号
    private Integer user_id;
    //评价内容
    private String content;
    //评价日期
    private Date add_time;
    //星级
    private Integer star;
    //照片
    private String image;
}
