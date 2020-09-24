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

import com.ibm.monitoringdashboard.tables.TableActivation;
import com.ibm.monitoringdashboard.tables.TableExchange;
import com.ibm.monitoringdashboard.tables.TableMFP;
import com.ibm.monitoringdashboard.tables.TableRecharge;

public class TablesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_tables,container,false);

        Button bt_mfp=(Button) view.findViewById(R.id.bt_mxclient);
        Button bt_simact=(Button) view.findViewById(R.id.bt_simact);
        Button bt_simrech=(Button) view.findViewById(R.id.bt_simrech);
        Button bt_simex=(Button) view.findViewById(R.id.bt_simex);

        bt_mfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TableMFP.class);
                startActivity(intent);
            }
        });
        bt_simact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TableActivation.class);
                startActivity(intent);
            }
        });
        bt_simrech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TableRecharge.class);
                startActivity(intent);
            }
        });
        bt_simex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), TableExchange.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
