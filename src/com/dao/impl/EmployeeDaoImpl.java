package com.dao.impl;

import java.sql.Connection;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.util.JDBCUtils;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {

	@Override
	public Employee getEmployeeByAccount(String account) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT * FROM `employee` WHERE `account`=?";
			return this.query(connection, sql, account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
