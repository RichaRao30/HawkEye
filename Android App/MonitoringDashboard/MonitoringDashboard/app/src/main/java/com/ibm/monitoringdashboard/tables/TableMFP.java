package com.ibm.monitoringdashboard.tables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;

import com.ibm.monitoringdashboard.R;
import com.ibm.monitoringdashboard.adapter.MyAdapter;
import com.ibm.monitoringdashboard.model.TableReportVO;
import com.ibm.monitoringdashboard.retrofitapi.ApiClient;
import com.ibm.monitoringdashboard.retrofitapi.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableMFP extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView myRecyclerView;
    MyAdapter myAdapter;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_mfp);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        data();

        swipeRefreshLayout=findViewById(R.id.refresh_mfp);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
                data();
            }
        });
    }

    public void data(){
        myRecyclerView=findViewById(R.id.recyclerView_mfp);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<List<TableReportVO>> call=apiInterface.getMFPTable();
        call.enqueue(new Callback<List<TableReportVO>>() {
            @Override
            public void onResponse(Call<List<TableReportVO>> call, Response<List<TableReportVO>> response) {
                myAdapter=new MyAdapter(this,response.body(),"MFP");
                myRecyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<TableReportVO>> call, Throwable t) {
                Log.e("-----","onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}
