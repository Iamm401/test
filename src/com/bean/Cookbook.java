package com.bean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 菜谱信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cookbook {
	//菜谱编号,
    private Integer id;
    //菜谱名称,
    private String name;
    //菜谱用料,
    private String ingredient;
    //步骤,
    private String step;
    //图片
    private String image;
}
