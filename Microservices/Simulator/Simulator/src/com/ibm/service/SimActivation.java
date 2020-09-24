package com.ibm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import com.ibm.dbconfig.DBLayer;

public class SimActivation {
	DBLayer d1= DBLayer.getInstance();
	
	public void random_Act_Circle() {
		Random rand=new Random();
		
		int total_today=0,total_lweek=0,total_diff=0;
		int today,lweek,diff,pdiff,circle;
		int f=0;
		Timestamp sqlTime = null;
		
		try{   
			Connection con= d1.DbConnection();
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from ACT_CIRCLE_WISE_TREND");  
			if(rs.next()==true)  
				f=1;
			con.close();  
			}
			catch(Exception e){ 
				System.out.println(e);
				e.printStackTrace();
				}  
		
		for(int i=1;i<=23;i++) {
			circle=i;
			
			today=rand.nextInt(5)+7;
			total_today+=today;
			
			lweek=rand.nextInt(5)+7;
			total_lweek+=lweek;
			
			diff=today-lweek;
			total_diff+=diff;
			
			pdiff=(diff*100)/today;	
			
			if(f==0) {
			try {
				Connection con=d1.DbConnection();
				Statement stmt=con.createStatement();
				Date date=new Date();
				sqlTime=new Timestamp(date.getTime());
				String sql="insert into ACT_CIRCLE_WISE_TREND values("+circle+","+today+","+lweek+","+diff+","+pdiff+")";
				stmt.executeUpdate(sql);
				con.close();
			}
			catch(Exception e){ 
				System.out.println(e);
				e.printStackTrace();
				}
			}
			
			else if(f==1){
				try {
					Connection con=d1.DbConnection();
					Statement stmt=con.createStatement();
					Date date=new Date();
					sqlTime=new Timestamp(date.getTime());
					String sql="update ACT_CIRCLE_WISE_TREND set today="+today+",lastweek="+lweek+",diff="+diff+",diff_prct="+pdiff+" where circle="+circle;
					stmt.executeUpdate(sql);
					con.close();
				}
				catch(Exception e){ 
					System.out.println(e);
					e.printStackTrace();
					}
			}
		}
		act_OneMin(sqlTime,total_today,total_lweek,total_diff);
		
	}
	
	public void act_OneMin(Timestamp sqlTime,int total_today,int total_lweek,int total_diff) {
		int total_pdiff=(total_diff*100)/total_today;
		
		try {
			Connection con=d1.DbConnection();
			Statement stmt=con.createStatement();
			String sql="insert into ACT_ONE_MIN_TREND values('"+sqlTime+"',"+total_today+","+total_lweek+","+total_diff+","+total_pdiff+")";
			stmt.executeUpdate(sql);
			con.close();
		}
		catch(Exception e){ 
			System.out.println(e);
			e.printStackTrace();
			}
	}
}
