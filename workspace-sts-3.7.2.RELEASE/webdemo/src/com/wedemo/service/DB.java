package com.wedemo.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	public static Connection getDbcon(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "") ;
			return con ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null ;
	}

}
