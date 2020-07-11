package com.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 用户信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	//用户编号
    private Integer id;
    //姓名
    private String name;
    //性别
    private Integer sex;
    //账号
    private String account;
    //密码
    private String password;
    //手机号
    private String phone;
    //邮箱
    private String email;
    //所在城市
    private String city;
    //注册时间
    private Date reg_time;
    //是否是会员
    private Integer is_vip;
    //会员截止时间
    private Date vip_deadline;
}
