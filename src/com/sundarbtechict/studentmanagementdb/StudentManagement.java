package com.sundarbtechict.studentmanagementdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentManagement {
	Connection c;
	Statement st ;
	ResultSet rs;

	Scanner s =new Scanner(System.in);
	String url,user,pass;

	public StudentManagement() {
		try{
			url = "jdbc:mysql://localhost:3306/student";
			user = "root";
			pass = "";
			c= DriverManager.getConnection(url, user, pass);
			st=c.createStatement();
		}catch (Exception e){System.out.println(e);}
	}

	void create()
	{
		try{
			System.out.println("enter your details");
			Student ss=new Student();
			System.out.println("Name:");
			ss.setName(s.next());
			System.out.println("Register no:");
			ss.setRegNo(s.nextInt());
			System.out.println("Date of Birth:");
			ss.setDob(s.next());
			System.out.println("Department:");
			ss.setDept(s.next());
			System.out.println("Email:");
			ss.setEmail(s.next());
			System.out.println("Mobile:");
			ss.setMobile(s.next());
			String sql="INSERT INTO STUDENT_MANAGEMENT VALUES('"+ss.getRegNo()+"','"+ss.getName()+"','"+ss.getDob()+"','"+ss.getDept()+"','"+ss.getEmail()+"','"+ss.getMobile()+"')";
			int n=st.executeUpdate(sql);
			if(n==0)
				System.out.println("record is not inserted");
			else
				System.out.println("record is sucessfully inserted");

		}catch (Exception e){System.out.println(e);}
	};
	void read()
	{
		try{
			System.out.println("Enter your register no to display:");
			int r=s.nextInt();
			boolean f= false;
			String sql="SELECT * FROM STUDENT_MANAGEMENT WHERE regno='"+r+"'";
			System.out.println(sql);
			rs=st.executeQuery(sql);
			while(rs.next())
			{
					System.out.println("-----------------------------");
					System.out.print("Register no:");
					System.out.println(rs.getString("regno"));
					System.out.print("Name:");
					System.out.println(rs.getString("name"));
					System.out.print("Date of Birth:");
					System.out.println(rs.getString("dob"));
					System.out.print("Department:");
					System.out.println(rs.getString("dept"));
					System.out.print("Email:");
					System.out.println(rs.getString("email"));
					System.out.print("Mobile:");
					System.out.println(rs.getString("mobile"));
					System.out.println("-----------------------------");
					f=true;
			}
			if(!f)
			{
				System.out.println("Invalid register no");
			}
		}catch (Exception e){System.out.println(e);}
	}
	void readAll()
	{
		try{
			String sql="SELECT * FROM STUDENT_MANAGEMENT";
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				rs.previous();
				String a="%-15s%-15s%-20s%-12s%-20s%-12s";
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.format(a,"Register No","Name","Date of birth","Depatment","Email","Mobile");			
				System.out.println();
				System.out.println("-------------------------------------------------------------------------------------");

				while(rs.next())
				{
					System.out.format(a,rs.getString("regno"),rs.getString("name"),rs.getString("dob"),rs.getString("dept"),rs.getString("email"),rs.getString("mobile"));
					System.out.println();

				}
				System.out.println("-------------------------------------------------------------------------------------");
			}
			else
				System.out.println("empty records");
		}catch (Exception e){System.out.println(e);}
	}
	void update()
	{
		try{
			System.out.println("Enter your register no to update:");
			int r=s.nextInt();
			String sql="SELECT regno FROM STUDENT_MANAGEMENT WHERE regno="+r;
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				Student ss=new Student();
				System.out.println("Name:");
				ss.setName(s.next());
				System.out.println("Register no:");
				ss.setRegNo(s.nextInt());
				System.out.println("Date of Birth:");
				ss.setDob(s.next());
				System.out.println("Department:");
				ss.setDept(s.next());
				System.out.println("Email:");
				ss.setEmail(s.next());
				System.out.println("Mobile:");
				ss.setMobile(s.next());
				sql="UPDATE STUDENT_MANAGEMENT SET "
						+ "regno='"+ss.getRegNo()+"',name='"+ss.getName()+"',dob='"+ss.getDob()+"',dept='"+ss.getDept()+"',email='"+ss.getEmail()+"',mobile='"+ss.getMobile()+"'"
								+ " WHERE regno="+r;
				st.execute(sql);
				System.out.println("your record is sucessfully updated");
			}
			else
			{
				System.out.println("Invalid register no");
			}
		}catch (Exception e){System.out.println(e);}
	}
	void  delete()
	{
		try{
			System.out.println("Enter your register no to delete:");
			int r=s.nextInt();
			boolean f= false;
			String sql="DELETE FROM STUDENT_MANAGEMENT WHERE regno='"+r+"'";
			int n=st.executeUpdate(sql);
			if(n!=0)
			{
				f=true;
				System.out.println("deleted sucessfully");
			}
			if(!f)
			{
				System.out.println("Invalid register no");
			}
		}catch (Exception e){System.out.println(e);}
	}
	void deleteAll()
	{
		try{
			String sql="DELETE FROM STUDENT_MANAGEMENT";
			st.executeUpdate(sql);
			System.out.println("Deleted all records");
		}catch (Exception e){System.out.println(e);}
	}

}
