package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBAccess {

	static Connection con = null;

	public static Connection getConnection() {
		if (con != null)
			return con;
		String url = "jdbc:mysql://localhost:3306/termproject";
		String uname = "root";
		String pass = "root";
		return getConnection(url, uname, pass);
	}

	private static Connection getConnection(String dbname, String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(dbname, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
