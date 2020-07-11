package com.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * 商品订单表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommodityOrder {
	//订单编号
    private Integer id;
    //用户编号
    private Integer user_id;
    //原始金额
    private Double original_money;
    //结算金额
    private Double settlement_amount;
    //优惠券编号
    private Integer discount_coupon_id;
    //送达时间
    private Date delivery_time;
    //配送地址编号
    private Integer delivery_address_id;
    //订单状态（0.下单，1.配送，2.送达，3.退货)
    private Integer status;
}
