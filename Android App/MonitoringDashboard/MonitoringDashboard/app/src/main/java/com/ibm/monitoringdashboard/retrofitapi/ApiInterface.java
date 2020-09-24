package com.ibm.monitoringdashboard.retrofitapi;

import com.ibm.monitoringdashboard.model.ReportVO;
import com.ibm.monitoringdashboard.model.TableReportVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("ActivationTrend")
    Call<List<ReportVO>> getChartActivationTrend();

    @GET("RechargeTrend")
    Call<List<ReportVO>> getChartRechargeTrend();

    @GET("ActivationData")
    Call<List<ReportVO>> getChartActivation();

    @GET("RechargeData")
    Call<List<ReportVO>> getChartRecharge();

    @GET("ActivationTrendTable")
    Call<List<TableReportVO>> getActTable();

    @GET("RechargeTrendTable")
    Call<List<TableReportVO>> getRechTable();

    @GET("SimexTrendTable")
    Call<List<TableReportVO>> getSimexTable();

    @GET("ActivationCircleTrendTable")
    Call<List<TableReportVO>> getActCircleTable();

    @GET("RechargeCircleTrendTable")
    Call<List<TableReportVO>> getRechCircleTable();

    @GET("SimexCircleTrendTable")
    Call<List<TableReportVO>> getSimexCircleTable();

    @GET("MFPIHSTrendTable")
    Call<List<TableReportVO>> getMFPTable();

}
