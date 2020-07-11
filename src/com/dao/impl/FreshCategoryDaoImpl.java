package com.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.bean.FreshCategory;
import com.dao.FreshCategoryDao;
import com.util.JDBCUtils;

public class FreshCategoryDaoImpl extends BaseDaoImpl<FreshCategory> implements FreshCategoryDao {

	@Override
	public FreshCategory getFreshCategoryById(Integer category_id) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT * FROM `fresh_category` WHERE id = ?";
			return query(connection, sql, category_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FreshCategory> getAllFreshCategory() {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT * FROM `fresh_category`";
			return queryList(connection, sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "DELETE FROM `fresh_category` WHERE id = ?";
			this.execute(connection, sql, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
