package com.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	T query(Connection connection, String sql, Object... args) throws Exception;

	List<T> queryList(Connection connection, String sql, Object... args) throws Exception;

	boolean execute(Connection connection, String sql, Object... args) throws Exception;

	
	<E> E get(Connection connection, String sql, Object... args) throws Exception;

	boolean update(Connection connection,String tableName, Map<String, Object> valueParams, Map<String, Object> conditionParams)
			throws Exception;
}
