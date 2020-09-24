package com.ibm.vil.monitoringdashboard;

import java.util.ArrayList;
import java.util.List;

public class ReportModel {
	
		public List<ReportVO> findAllRecharge() {
			List<ReportVO> reports = new ArrayList<ReportVO>();
			reports.add(new ReportVO("IDEA", 0));
			reports.add(new ReportVO("VODA", 0));
			return reports;
		}
		
		public List<ReportVO> findAllActivation() {
			List<ReportVO> reports = new ArrayList<ReportVO>();
			reports.add(new ReportVO("IDEA", 0));
			reports.add(new ReportVO("VODA", 0));
			return reports;
		}
		

		public List<ReportVO> findRechargeTrend() {
			List<ReportVO> reports = new ArrayList<ReportVO>();
			reports.add(new ReportVO("IDEA", 0));
			reports.add(new ReportVO("VODA", 0));
			return reports;
		}

		public List<ReportVO> findActivationTrend() {
			List<ReportVO> reports = new ArrayList<ReportVO>();
			reports.add(new ReportVO("IDEA", 0));
			reports.add(new ReportVO("VODA", 0));
			return reports;
		}

	}

