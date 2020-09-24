package com.ibm.dbconfig;

import java.sql.Connection; 
import java.sql.DriverManager;

public class DBLayer{
	
	private static DBLayer d1;
	
	private DBLayer() { }
	
	public static DBLayer getInstance() {
		if(d1==null)
			d1=new DBLayer();
		return d1;
	}
	
	public Connection DbConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmproject","root","root");  
			return con;
		}
		catch(Exception e){ 
			System.out.println(e);
			e.printStackTrace();
			}
		return null;
	}

}
