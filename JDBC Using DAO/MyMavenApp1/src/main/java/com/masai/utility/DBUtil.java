package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection  provoidConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/JDBC_DB";
		try {
			connection = DriverManager.getConnection(url,"root","Bhanu@123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
