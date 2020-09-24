package com.ibm.controller;

import java.util.Timer;   
import java.util.TimerTask;

import com.ibm.service.IdeaPrepaidActivation;
import com.ibm.service.IdeaTopup;
import com.ibm.service.MaxClient;
import com.ibm.service.SimActivation;
import com.ibm.service.SimExchange;
import com.ibm.service.SimRecharge;
import com.ibm.service.VodaPrepaidActivation;
import com.ibm.service.VodaTopup;


public class MyTimerTask {
	public static void main(String []args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int i=0;
			@Override
			public void run() {
				SimActivation sa=new SimActivation();
				SimRecharge sr=new SimRecharge();
				SimExchange se=new SimExchange();
				MaxClient mc=new MaxClient();
				VodaPrepaidActivation vpa=new VodaPrepaidActivation();
				IdeaPrepaidActivation ipa=new IdeaPrepaidActivation();
				VodaTopup vt=new VodaTopup();
				IdeaTopup it=new IdeaTopup();
				i++;
				
				sa.random_Act_Circle(); 
				sr.random_Rch_Circle();
				se.random_SimEx_Circle();
				mc.random_Mxclient();
				vpa.randomVodaAct();
				ipa.randomIdeaAct();
				vt.randomVTopup();
				it.randomITopup();
				
				System.out.println("1min completed");
				if(i>179) {
					timer.cancel();
					System.out.println("Timer expired!");
				}
			}
		};
		long delay = 0;
		long intevalPeriod = 2 * 1000; 
		timer.scheduleAtFixedRate(task, delay,intevalPeriod);
  } 
}