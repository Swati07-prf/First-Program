package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class RetrieveCustomerData {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    try
	    {
	    	//loading driver
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	//creating Connection
	    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","81180");
	    	CallableStatement cs = con.prepareCall("{call retrieveCustInfo(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	        System.out.println("Enter Customer Id:");
	        int cId=Integer.parseInt(sc.nextLine());
	        cs.setInt(1, cId);
	        cs.registerOutParameter(1, Types.NUMERIC);
	        cs.registerOutParameter(2, Types.VARCHAR);
	        cs.registerOutParameter(3, Types.VARCHAR);
	        cs.registerOutParameter(4, Types.NUMERIC);
	        cs.registerOutParameter(5, Types.VARCHAR);
	        cs.registerOutParameter(6, Types.VARCHAR);
	        cs.registerOutParameter(7, Types.VARCHAR);
	        cs.registerOutParameter(8, Types.NUMERIC);
	        cs.registerOutParameter(9, Types.VARCHAR);
	        cs.registerOutParameter(10, Types.BIGINT);
	        cs.registerOutParameter(11, Types.VARCHAR);
	        cs.registerOutParameter(12, Types.VARCHAR);
	        cs.registerOutParameter(13, Types.DOUBLE);
	        
	        cs.execute();
	        System.out.println("CID:"+cs.getInt(1));
	        System.out.println("CName:"+cs.getString(2));
	        System.out.println("Phno:"+cs.getLong(10));
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
}
