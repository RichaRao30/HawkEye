package com.ibm.monitoringdashboard.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibm.monitoringdashboard.R;

public class MyHolder extends RecyclerView.ViewHolder {

    TextView mTime,mToday,mLastweek,mDiff,mDiffPrct;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mTime=itemView.findViewById(R.id.time);
        this.mToday=itemView.findViewById(R.id.today);
        this.mLastweek=itemView.findViewById(R.id.lastweek);
        this.mDiff=itemView.findViewById(R.id.diff);
        this.mDiffPrct=itemView.findViewById(R.id.diffprct);
    }
}
