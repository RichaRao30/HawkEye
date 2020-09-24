package com.ibm.service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ibm.dbconfig.DBLayer;

public class VodaTopup{
	DBLayer d1= DBLayer.getInstance();
	Random rand=new Random();
	
	int amount() {
		List<Integer> list=new ArrayList<Integer>();
		list.add(20);
		list.add(50);
		list.add(100);
		list.add(200);
		list.add(500);
		return list.get(rand.nextInt(list.size())); 
	}
	
	String message() {
		List<String> list=new ArrayList<String>();
		list.add("Successful");
		list.add("Successful");
		list.add("Successful");
		list.add("Successful");
		list.add("FAILED");
		return list.get(rand.nextInt(list.size())); 
	}
	
	public void randomVTopup() {
		int n,Beg1,Num1,Beg2,Num2;
		String beg1,num1,beg2,num2;
		
		int circle,amt;
		String id,retailer,customer,msg;
		
		circle=rand.nextInt(23)+1;
		
		n=100000+rand.nextInt(900000);
		id=circle+"VTOP"+n;
		
		Beg1=rand.nextInt(3)+7;
		beg1=Integer.toString(Beg1);
		Num1=100000000+rand.nextInt(900000000);
		num1=Integer.toString(Num1);
		retailer=beg1+num1;
		
		Beg2=rand.nextInt(3)+7;
		beg2=Integer.toString(Beg2);
		Num2=100000000+rand.nextInt(900000000);
		num2=Integer.toString(Num2);
		customer=beg2+num2;
		
		amt=amount();
		msg=message();
		
		insertVTop(id,retailer,customer,amt,circle,msg);
	}
	
	public void insertVTop(String id,String retailer,String customer,int amt,int circle,String msg){
		String time;
		try {
			Connection con=d1.DbConnection();
			Statement stmt=con.createStatement();
			Date date=new Date();
			Timestamp sqlTime=new Timestamp(date.getTime());
			time=sqlTime.toString();
			//String sql="insert into VODA_TOPUP_TRANSACTIONS values('"+id+"','2020-06-04 15:23:38','"+retailer+"','"+customer+"',"+amt+","+circle+",'"+msg+"')";
			String sql="insert into VODA_TOPUP_TRANSACTIONS values('"+id+"','"+time+"','"+retailer+"','"+customer+"',"+amt+","+circle+",'"+msg+"')";
			stmt.executeUpdate(sql);
			con.close();
		}
		catch(Exception e){ 
			System.out.println(e);
			e.printStackTrace();
			}
	}
}
