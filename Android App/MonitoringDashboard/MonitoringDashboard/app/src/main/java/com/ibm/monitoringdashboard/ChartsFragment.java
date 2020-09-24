package com.ibm.monitoringdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ibm.monitoringdashboard.charts.ChartActivation;
import com.ibm.monitoringdashboard.charts.ChartRecharge;

public class ChartsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_charts,container,false);

        Button bt_act=(Button) view.findViewById(R.id.bt_act);
        Button bt_rech=(Button) view.findViewById(R.id.bt_rech);

        bt_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ChartActivation.class);
                startActivity(intent);
            }
        });
        bt_rech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ChartRecharge.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
