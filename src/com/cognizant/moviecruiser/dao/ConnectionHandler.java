package com.cognizant.moviecruiser.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	public static Connection getConnection() {
		Connection cn = null;
		InputStream inputstream = ConnectionHandler.class.getClassLoader().getResourceAsStream("connection.properties");
		Properties prop = new Properties();
		try {
			prop.load(inputstream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = prop.getProperty("connection-url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		try {
			cn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;

	}
}
