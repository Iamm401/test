package com.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 满折商品关联表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullDiscountCommodity {
	// 满折编号
	private Integer full_discount_id;
	// 商品编号
	private Integer commodity_id;
	// 起始日期
	private Date start_date;
	// 结束日期
	private Date end_date;
}
