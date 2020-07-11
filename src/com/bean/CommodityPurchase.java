package com.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommodityPurchase {
	// 采购单编号
	private Integer id;
	// 食材编号
	private Integer commodity_id;
	// 数量
	private Integer amount;
	// 状态（0.下单，1.在途，2.入库）
	private Integer status;
	//食材
	private Commodity commodity;
}
