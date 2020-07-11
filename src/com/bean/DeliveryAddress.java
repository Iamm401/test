package com.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 配送地址表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryAddress {
	// 地址编号
	private Integer id;
	// 用户编号
	private Integer user_id;
	// 省
	private String province;
	// 市
	private String city;
	// 区
	private String district;
	// 地址
	private String address;
	// 联系人
	private String linkman;
	// 电话
	private String phone;
}
