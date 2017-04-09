package com.sundarbtechict.studentmanagementdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public static final String url = "jdbc:mysql://localhost:3306/student";
	public static final String user = "root";
	public static final String pass = "";
	public static Connection getConnection()throws Exception 
	{
		Connection c;
		c= DriverManager.getConnection(url, user, pass);
		return c;
	}
	
}
