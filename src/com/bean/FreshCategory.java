package com.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 商品类别
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FreshCategory {
	// 类别编号
	private Integer id;
	// 类别名称
	private String name;
	// 类别描述
	private String desc;

}
