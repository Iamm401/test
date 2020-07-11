package com.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 限时促销
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LimitedTimePromotion {
	//促销编号
    private Integer id;
    //商品编号
    private Integer commodity_id;
    //促销价格
    private Double promotion_money;
    //促销数量
    private Integer promotion_amount;
    //起始日期
    private Date start_date;
    //结束日期
    private Date end_date;
}	
