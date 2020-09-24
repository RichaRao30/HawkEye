package com.ibm.service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.ibm.dbconfig.DBLayer;

public class MaxClient {
	DBLayer d1= DBLayer.getInstance();
	Random rand=new Random();
	
	String[] hashing() {
		HashMap<String, String> hash_map = new HashMap<String, String>();
		hash_map.put("10.0.45.23", "retailer1.vodafoneidea.com");
		hash_map.put("10.0.45.24", "retailer2.vodafoneidea.com");
		hash_map.put("10.0.45.25", "retailer3.vodafoneidea.com");
		hash_map.put("10.0.45.26", "retailer4.vodafoneidea.com");
		
		List<String> keys = new ArrayList<String>(hash_map.keySet());
		List<String> values = new ArrayList<String>(hash_map.values());
		
		int randomIndex = rand.nextInt(keys.size());
		String randomKey= keys.get(randomIndex);
		String randomValue= values.get(randomIndex);
		
		String[] arr= {randomKey,randomValue};
		return arr;
	}
	public void random_Mxclient() {
		
		String time;
		String[] hash=hashing();
		int maxclient=rand.nextInt(2251)+250;
		
		try {
			Connection con=d1.DbConnection();
			Statement stmt=con.createStatement();
			Date date=new Date();
			Timestamp sqlTime=new Timestamp(date.getTime());
			time=sqlTime.toString();
			String sql="insert into MFP_IHS_MXCLIENT_UNIFIED(DT,IP,HOST_NAME,MAXCLIENT) values('"+time+"','"+hash[0]+"','"+hash[1]+"',"+maxclient+")";
			stmt.executeUpdate(sql);
			con.close();
		}
		catch(Exception e){ 
			System.out.println(e);
			e.printStackTrace();
			}
		}
}
