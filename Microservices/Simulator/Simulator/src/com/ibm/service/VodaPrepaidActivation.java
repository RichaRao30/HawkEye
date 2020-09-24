package com.ibm.service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ibm.dbconfig.DBLayer;

public class VodaPrepaidActivation {
	DBLayer d1= DBLayer.getInstance();
	Random rand=new Random();
	
	String vdoc() {
		List<String> list=new ArrayList<String>();
		list.add("Aadhar Card");
		list.add("Passport");
		list.add("Voter ID");
		list.add("Telephone Bill");
		return list.get(rand.nextInt(list.size())); 
	}
	
	String host() {
		List<String> list=new ArrayList<String>();
		list.add("retailer1.vodafoneidea.com");
		list.add("retailer2.vodafoneidea.com");
		list.add("retailer3.vodafoneidea.com");
		list.add("retailer4.vodafoneidea.com");
		return list.get(rand.nextInt(list.size())); 
	}
	
	public void randomVodaAct() {
		String beg1,beg2,num1,num2;
		int n,Beg1,Beg2,Num1,Num2;
		
		String caf,retailer,sim,doc,hname;
		int circle,customer;
		
		
		circle=rand.nextInt(23)+1;
		customer=10000+rand.nextInt(90000);
		
		n=100000+rand.nextInt(900000);
		caf=circle+"VACT"+n;
		
		Beg1=rand.nextInt(3)+7;
		beg1=Integer.toString(Beg1);
		Num1=100000000+rand.nextInt(900000000);
		num1=Integer.toString(Num1);
		retailer=beg1+num1;
		
		
		Beg2=rand.nextInt(3)+7;
		beg2=Integer.toString(Beg2);
		Num2=100000000+rand.nextInt(900000000);
		num2=Integer.toString(Num2);
		sim=beg2+num2;
		
		doc=vdoc();
		hname=host();
		
		insertVA(caf,retailer,customer,doc,hname,circle,sim);
	}
	
	public void insertVA(String caf,String retailer,int customer,String doc,String hname,int circle,String sim) {
		String time;
		try {
			Connection con=d1.DbConnection();
			Statement stmt=con.createStatement();
			Date date=new Date();
			Timestamp sqlTime=new Timestamp(date.getTime());
			time=sqlTime.toString();
			//String sql="insert into VODA_PREPAID_ACTIVATION values('"+caf+"','2020-06-13 19:00:38','"+retailer+"',"+customer+",'"+doc+"','"+hname+"',"+circle+",'"+sim+"')";
			String sql="insert into VODA_PREPAID_ACTIVATION values('"+caf+"','"+time+"','"+retailer+"',"+customer+",'"+doc+"','"+hname+"',"+circle+",'"+sim+"')";
			stmt.executeUpdate(sql);
			con.close();
		}
		catch(Exception e){ 
			System.out.println(e);
			e.printStackTrace();
			}
	}

}
