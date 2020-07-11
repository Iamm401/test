package com.dao.impl;

import java.sql.Connection;

import com.bean.User;
import com.dao.UserDao;
import com.util.JDBCUtils;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getUserByAccount(String account) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT * FROM `user` WHERE `account`=?";
			return this.query(connection, sql, account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
