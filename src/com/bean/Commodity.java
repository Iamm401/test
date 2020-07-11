package com.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 商品信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commodity {
	// 商品编号,
	private Integer id;
	// 商品名称,
	private String name;
	// 价格,
	private Double price;
	// 会员价,
	private Double vip_price;
	// 数量,
	private Integer amount;
	// 规格,
	private Integer size;
	// 详情
	private String details;
	//类别
	private Integer category_id;
	private FreshCategory category;
}
