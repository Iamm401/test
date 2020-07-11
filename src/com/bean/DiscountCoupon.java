package com.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 优惠券
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscountCoupon {
	//优惠券编号
    private Integer id;
    //内容
    private String content;
    //适用金额
    private Double apply_money;
    //减免金额
    private Double remission_money;
    //起始日期
    private Date start_date;
    //结束日期
    private Date end_date;
}
