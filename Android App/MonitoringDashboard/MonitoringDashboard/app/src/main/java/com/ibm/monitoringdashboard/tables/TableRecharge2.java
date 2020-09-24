package com.ibm.monitoringdashboard.tables;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibm.monitoringdashboard.R;
import com.ibm.monitoringdashboard.adapter.MyAdapter;
import com.ibm.monitoringdashboard.model.TableReportVO;
import com.ibm.monitoringdashboard.retrofitapi.ApiClient;
import com.ibm.monitoringdashboard.retrofitapi.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TableRecharge2 extends Fragment {

    ApiInterface apiInterface;
    RecyclerView myRecyclerView;
    MyAdapter myAdapter;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_table_recharge2, container, false);

        myRecyclerView=view.findViewById(R.id.recyclerView_rechtb2);

        data();

        swipeRefreshLayout=view.findViewById(R.id.refresh_tablerech2);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
                data();
            }
        });

        return view;
    }

    public void data(){
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<List<TableReportVO>> call=apiInterface.getRechTable();
        call.enqueue(new Callback<List<TableReportVO>>() {
            @Override
            public void onResponse(Call<List<TableReportVO>> call, Response<List<TableReportVO>> response) {
                myAdapter=new MyAdapter(this,response.body(),"RechTable");
                myRecyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<TableReportVO>> call, Throwable t) {
                Log.e("-----","onFailure: " + t.getLocalizedMessage());
            }
        });

    }
}
