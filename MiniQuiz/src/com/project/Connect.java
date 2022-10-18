package com.project;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	static Connection con;
	public static Connection serverconnect() {
		
		try {
			String a ="com.mysql.cj.jdbc.Driver";
			Class.forName(a);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","root123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con; 
	} 
	

}
