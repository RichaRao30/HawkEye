package com.ibm.vil.monitoringdashboard;

import java.util.List;

public interface ReportDao {

	List<ReportVO> actReportList();

	List<ReportVO> rchReportList();

	List<ReportVO> findRechargeTrend();

	List<ReportVO> findActivationTrend();

	List<TableReportVO> findActivationTrendTable();

	List<TableReportVO> findRechargeTrendTable();

	List<TableReportVO> findSimexTrendTable();

	List<TableReportVO> findActivationCircleTrendTable();

	List<TableReportVO> findRechargeCircleTrendTable();

	List<TableReportVO> findSimexCircleTrendTable();

	List<TableReportVO> mfpIHSTrendTable();


}
