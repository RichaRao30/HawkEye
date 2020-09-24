package com.ibm.monitoringdashboard.charts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.ibm.monitoringdashboard.R;
import com.ibm.monitoringdashboard.model.ReportVO;
import com.ibm.monitoringdashboard.retrofitapi.ApiClient;
import com.ibm.monitoringdashboard.retrofitapi.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartActivation1 extends Fragment {

    ApiInterface apiInterface;
    BarChart barChart;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_chart_activation1, container, false);
        barChart=(BarChart) view.findViewById(R.id.chart_activationtrend);

        data();

        swipeRefreshLayout=view.findViewById(R.id.refresh_chartact1);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                data();
            }
        });

        return view;
    }

    public void data(){
        apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<List<ReportVO>> call=apiInterface.getChartActivationTrend();
        call.enqueue(new Callback<List<ReportVO>>() {

            public void onResponse(Call<List<ReportVO>> call, Response<List<ReportVO>> response) {
                List<ReportVO> reportVO=response.body();

                ArrayList<BarEntry> barEntries1=new ArrayList<>();
                for (int i=0;i<reportVO.size();i++) {
                    int quant = reportVO.get(i).getQuantity();
                    barEntries1.add(new BarEntry(i+1, quant));
                }
                ArrayList<BarEntry> barEntries2=new ArrayList<>();
                for (int i=0;i<reportVO.size();i++) {
                    String quant= reportVO.get(i).getTrxType();
                    barEntries2.add(new BarEntry(i + 1, Integer.parseInt(quant)));
                }

                BarDataSet barDataSet1= new BarDataSet(barEntries1,"IDEA DataSet");
                barDataSet1.setColor(Color.YELLOW);
                barDataSet1.setValueTextColor(Color.WHITE);
                BarDataSet barDataSet2= new BarDataSet(barEntries2,"VODA DataSet");
                barDataSet2.setColor(Color.RED);
                barDataSet2.setValueTextColor(Color.WHITE);

                BarData data=new BarData(barDataSet1,barDataSet2);
                barChart.setData(data);

                String[] time= new String[]{"08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00"};
                XAxis xAxis=barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(time));
                xAxis.setCenterAxisLabels(true);
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setGranularity(1);
                xAxis.setGranularityEnabled(true);

                barChart.setBackgroundColor(Color.DKGRAY);
                xAxis.setTextColor(Color.WHITE);
                barChart.getAxisLeft().setTextColor(Color.WHITE);
                barChart.getAxisRight().setTextColor(Color.WHITE);
                barChart.getLegend().setTextColor(Color.WHITE);

                barChart.setDragEnabled(true);
                barChart.setVisibleXRangeMaximum(3);
                barChart.setDrawValueAboveBar(true);

                float barSpace=0.06f;
                float groupSpace=0.54f;
                data.setBarWidth(0.17f);

                barChart.getXAxis().setAxisMinimum(0);
                barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace,barSpace)*12);
                barChart.getAxisLeft().setAxisMinimum(0);

                barChart.groupBars(0,groupSpace,barSpace);

                Description description = new Description();
                description.setText("");
                barChart.setDescription(description);

                barChart.invalidate();

            }

            @Override
            public void onFailure(Call<List<ReportVO>> call, Throwable t) {
                Log.e("-----","onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}
