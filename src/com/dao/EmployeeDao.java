package com.dao;

import com.bean.Employee;

public interface EmployeeDao extends BaseDao<Employee> {

	Employee getEmployeeByAccount(String account);

}
