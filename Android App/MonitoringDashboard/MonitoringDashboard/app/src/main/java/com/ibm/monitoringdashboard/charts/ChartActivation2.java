package com.ibm.monitoringdashboard.charts;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.ibm.monitoringdashboard.R;
import com.ibm.monitoringdashboard.model.ReportVO;
import com.ibm.monitoringdashboard.retrofitapi.ApiClient;
import com.ibm.monitoringdashboard.retrofitapi.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartActivation2 extends Fragment {

    ApiInterface apiInterface;
    PieChart pieChart;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_chart_activation2, container, false);
        pieChart=(PieChart) view.findViewById(R.id.chart_activation);

        data();

        swipeRefreshLayout=view.findViewById(R.id.refresh_chartact2);
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
        Call<List<ReportVO>> call=apiInterface.getChartActivation();
        call.enqueue(new Callback<List<ReportVO>>() {
            public void onResponse(Call<List<ReportVO>> call, Response<List<ReportVO>> response) {
                List<ReportVO> reportVO=response.body();

                pieChart.setUsePercentValues(true);
                pieChart.getDescription().setEnabled(false);
                pieChart.setExtraOffsets(5,10,5,5);
                pieChart.setDragDecelerationFrictionCoef(0.25f);
                pieChart.setDrawHoleEnabled(true);
                pieChart.setHoleColor(Color.WHITE);
                pieChart.setTransparentCircleRadius(61f);

                ArrayList<PieEntry> yValues=new ArrayList<>();
                yValues.add(new PieEntry(reportVO.get(0).getQuantity(),"IDEA"));
                yValues.add(new PieEntry(reportVO.get(1).getQuantity(),"VODA"));

                pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

                PieDataSet dataSet=new PieDataSet(yValues,"Activation Data");
                dataSet.setSliceSpace(3f);
                dataSet.setSelectionShift(5f);

                final int[] MY_COLORS = {Color.rgb(255,192,0), Color.rgb(255,0,0)};
                ArrayList<Integer> colors = new ArrayList<Integer>();
                for(int c: MY_COLORS) colors.add(c);
                dataSet.setColors(colors);

                PieData data=new PieData(dataSet);
                data.setValueTextSize(10f);
                data.setValueTextColor(Color.YELLOW);

                pieChart.setData(data);

            }

            @Override
            public void onFailure(Call<List<ReportVO>> call, Throwable t) {
                Log.e("-----","onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}
