package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class constructProcedure 
{
    public static void main(String[] args) throws ClassNotFoundException 
    {
	    Scanner sc = new Scanner(System.in);
	    try
	    {
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "81180");
	       
	    }
	    catch(Exception e)
	    {
	    	   e.printStackTrace();
	    }
	}
}
