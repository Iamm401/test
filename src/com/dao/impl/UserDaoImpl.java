package com.dao.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<User> getUserList() {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT * FROM `user`";
			return this.queryList(connection, sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT * FROM `user` WHERE id = ?";
			return this.query(connection, sql, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateById(Map<String, Object> params, Integer id) {
		Map<String, Object> conditionParams = new HashMap<String, Object>();
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			conditionParams.put("id", id);
			this.update(connection, "user", params, conditionParams);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "DELETE FROM `user` WHERE id = ?";
			this.execute(connection, sql, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(User user) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "INSERT INTO `user`(`name`,`sex`,`account`,`password`,`phone`,`email`,`city`,`reg_time`,`is_vip`,`vip_deadline`) VALUES(?,?,?,?,?,?,?,?,?,?)";
			this.execute(connection, sql, user.getName(),user.getSex(),user.getAccount(),user.getPassword(),user.getPhone(),user.getEmail(),user.getCity(),user.getReg_time(),user.getIs_vip(),user.getVip_deadline());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
