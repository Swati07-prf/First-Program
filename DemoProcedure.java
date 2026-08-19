package com.jdbc;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class DemoProcedure {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    try
	    {
	    	//loading driver
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	//creating Connection
	    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","81180");
	    	CallableStatement cs = con.prepareCall("{call saveCustomerInfo(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	        System.out.println("Enter Customer Id:");
	        int cId=Integer.parseInt(sc.nextLine());
	    	cs.setInt(1, cId);
	    	String name = sc.nextLine();
	    	cs.setString(2, "Rajat");
	    	cs.setString(3, "Regular");
	    	cs.setInt(4, 100);
	    	cs.setString(5, "Ameerpet");
	    	cs.setString(6, "Hyd");
	    	cs.setString(7, "Tel");
	    	cs.setInt(8, 500016);
	    	cs.setString(9, "r@gmail.com");
	    	cs.setLong(10, 9898989899l);
	    	cs.setString(11, "7647674746746");
	    	cs.setString(12, "Saving");
	    	cs.setDouble(13, 70000);
	        cs.execute();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
}
