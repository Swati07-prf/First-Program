package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CrudOperation 
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
	    try
	    {
	    	//loading driver
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	//creating Connection
	    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","81180");
	    	//preparing statement
	    	Statement stmt =  con.createStatement();
	    	//stmt.executeUpdate("create table employee(eid number(5),ename varchar2(20),edept varchar2(20),esal number(9,2))");
	    	//connection closing
	    	//System.out.println("table created successfully");
	    	System.out.println("Choose your option..");
	    	System.out.println("1.Create table\n2.Insert record\n3.update record\n4.delete record");
	    	int option = Integer.parseInt(sc.nextLine());
	    	System.out.println("Choose your option");
	    	switch(option)
	    	{
	    	case 1:
	    		System.out.println("Create table");
	    		stmt.executeUpdate("create table employee(eid number(5)primary key,ename varchar2(20),edept varchar2(20),esal number(9,2))");
	    		System.out.println("Table created succesfully");
	    		break;
	    	case 2:
	    		System.out.println("insert record");
	    		System.out.println("Enter eid");
	    		int eId=Integer.parseInt(sc.nextLine());
	    		System.out.println("Enter ename");
	    		String eName=sc.nextLine();
	    		System.out.println("Enter department");
	    		String dept = sc.nextLine();
	    		System.out.println("Enter salary");
	    		Double sal = Double.parseDouble(sc.nextLine());
	    		
				int rowCount = stmt.executeUpdate("insert into employee values("+eId+",'"+eName+"','"+dept+"',"+sal+")");
				if(rowCount>0)
				System.out.println("success");
				break;
	    	case 3:System.out.println("Update record");
				System.out.println("Enter employee Id:");
				int Id =Integer.parseInt(sc.nextLine());
				System.out.println("Enter your salary:");
				double newSalary=Double.parseDouble(sc.nextLine());
				int k=stmt.executeUpdate("update employee set esal="+newSalary+" where eId="+Id+"");
				if(k>0)
				System.out.println("Record updated successfully");
				break;
	    	case 4:System.out.println("Delete record based on Id");
	    	System.out.println("Enter Id to delete:");
	    	int id = Integer.parseInt(sc.nextLine());
	    	int k1=stmt.executeUpdate("Delete from employee where eId="+id+"");
	    	if(k1>0)
	    	System.out.println("Record deleted succesfully");
	    	break;
	    	default:System.out.println("Invalid choice");
	    	}
	    	con.close();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
}
