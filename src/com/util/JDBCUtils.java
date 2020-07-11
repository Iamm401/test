package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private static String url = "jdbc:mysql://localhost:3306/fresh_network_db?serverTimezone=GMT";
	private static String user = "root";
	private static String password = "123456";
	private static String driver = "com.mysql.cj.jdbc.Driver";

	/**
	 * 获取连接
	 *
	 * @return 连接对象
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * 释放资源
	 */
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 释放资源
	 */
	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 释放资源
	 */
	public static void close(ResultSet resultSet, Statement statement) {
		if (resultSet != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 释放资源
	 */
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void rollback(Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
