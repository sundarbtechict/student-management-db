package com.sundarbtechict.studentmanagementdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class createdb {
	public static void main(String args[])
    {
        Connection c;
        Statement s ;
        //ResultSet rs;
        try{
        	 String url1 = "jdbc:mysql://localhost:3306/student";
             String user = "root";
             String password = "";
  
             c= DriverManager.getConnection(url1, user, password);
            System.out.println("connected");
            s=c.createStatement();
            s.executeUpdate("CREATE TABLE STUDENT_MANAGEMENT("
            		+ "regno VARCHAR(20)"
            		+ ",name VARCHAR(20),dob VARCHAR(10),dept VARCHAR(20),email VARCHAR(20),mobile VARCHAR(10))");
            c.close();
        }catch(SQLException ex) {
        	ex.printStackTrace();}
    }
}
