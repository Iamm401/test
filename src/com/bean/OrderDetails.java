package com.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 订单详情表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetails {
	 //订单编号
    private String order_id;
    //商品编号
    private String commodity_id;
    //数量
    private String amount;
    //价格
    private String price;
    //折扣
    private String discount;
    //满折编号
    private String full_discount_commodity_id;
}
