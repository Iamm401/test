package com.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 满折信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullDiscountInformation {
	//满折编号
    private Integer id;
    //内容
    private String content;
    //适用商品数量
    private Integer apply_commodity_amount;
    //折扣
    private Double discount;
    //起始日期
    private Date start_date;
    //结束日期
    private Date end_date;
}
