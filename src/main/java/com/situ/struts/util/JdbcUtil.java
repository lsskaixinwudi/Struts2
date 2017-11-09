package com.situ.struts.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletContext;

/**
 * 处理数据库工具类
 *
 */
public class JdbcUtil {
	private final static String driverClass = "com.mysql.jdbc.Driver";
	private final static String  url= "jdbc:mysql://localhost:3306/java1707";
	private final static String  userName = "root";
	private final static String  password = "root";
	
	
	static {
		// 1、加载驱动 Class.forNmae("");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		// 2、获取连接对象Connection。
		return DriverManager.getConnection(url, userName, password);
	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
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
	
	public static void close(Connection connection, Statement statement) {
		//6、关闭
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

}