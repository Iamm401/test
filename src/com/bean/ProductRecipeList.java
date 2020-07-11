package com.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 商品菜谱推荐表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRecipeList {
	//商品编号
    private Integer commodity_id;
    //菜谱编号
    private Integer cookbook_id;
    //描述
    private String desc;
}
