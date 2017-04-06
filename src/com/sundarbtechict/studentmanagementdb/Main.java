package com.sundarbtechict.studentmanagementdb;

import java.util.Scanner;


public class Main {
	
		Scanner s;
		void manageStudentHandle(){
			 s=new Scanner(System.in);
			 StudentManagement c= new StudentManagement();
			 int n=1;
			do{
				System.out.println("--------------------------");
				System.out.println("	choices:");
				System.out.println("1.	create");
				System.out.println("2.	Read");
				System.out.println("3.	Read all");
				System.out.println("4.	Update");
				System.out.println("5.	Delete");
				System.out.println("6.	Delete All");
				System.out.println("0.	Exit");
				System.out.println("--------------------------");
				System.out.println("Enter your choice:");
				n=s.nextInt();
				if(n==1)
				{
					c.create();
				}
				else if(n==2)
				{
					c.read();
				}
				else if(n==3)
				{
					c.readAll();
				}
				else if(n==4)
				{
					c.update();
				}
				else if(n==5)
				{
					c.delete();
				}
				else if(n==6)
				{
					c.deleteAll();
				}
				else
				{
					System.out.println("Ivalid chioce");
				}
			}while(n!=0);
		}
		public static void main(String[] args) {
			Main m=new Main();
			m.manageStudentHandle();
	}

}
