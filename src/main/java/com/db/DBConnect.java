package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection conn=null;
	
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp1", "root", "shravani");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return conn;
	}

}
