package com.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * 管理员工信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
	//员工编号
    private Integer id;
    //员工姓名
    private String name;
    //账号
    private String account;
    //密码
    private String password;
}
