package com.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dao.BaseDao;
import com.util.JDBCUtils;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T query(Connection connection, String sql, Object... args) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			T t = entityClass.getDeclaredConstructor().newInstance();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int count = metaData.getColumnCount();
			if (resultSet.next()) {
				for (int i = 0; i < count; i++) {
					Field field = entityClass.getDeclaredField(metaData.getColumnName(i + 1));
					field.setAccessible(true);
					field.set(t, resultSet.getObject(i + 1));
				}
				return t;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(resultSet, preparedStatement);
		}
	}

	@Override
	public List<T> queryList(Connection connection, String sql, Object... args) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int count = metaData.getColumnCount();
			List<T> list = new ArrayList<>();
			while (resultSet.next()) {
				T t = entityClass.getDeclaredConstructor().newInstance();
				for (int i = 0; i < count; i++) {
					Field field = entityClass.getDeclaredField(metaData.getColumnName(i + 1));
					field.setAccessible(true);
					field.set(t, resultSet.getObject(i + 1));
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(resultSet, preparedStatement);
		}
	}

	@Override
	public boolean execute(Connection connection, String sql, Object... args) throws Exception {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			return preparedStatement.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(preparedStatement);
		}
	}

	@Override
	public boolean update(Connection connection, String tableName, Map<String, Object> valueParams,
			Map<String, Object> conditionParams) throws Exception {
		String sql = "UPDATE `" + tableName + "` SET ";
		for (Map.Entry<String, Object> entry : valueParams.entrySet()) {
			sql += "`" + entry.getKey() + "`='" + entry.getValue() + "',";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " WHERE 1=1";
		for (Map.Entry<String, Object> entry : conditionParams.entrySet()) {
			sql += " AND `" + entry.getKey() + "`='" + entry.getValue() + "'";
		}
		return this.execute(connection, sql);
	}

	@Override
	public <E> E get(Connection connection, String sql, Object... args) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return (E) resultSet.getObject(1);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(resultSet, preparedStatement);
		}
	}

}
