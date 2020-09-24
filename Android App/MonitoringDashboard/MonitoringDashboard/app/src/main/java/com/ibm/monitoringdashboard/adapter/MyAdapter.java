package com.ibm.monitoringdashboard.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ibm.monitoringdashboard.R;
import com.ibm.monitoringdashboard.model.TableReportVO;

import java.util.List;

import retrofit2.Callback;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Callback<List<TableReportVO>> c;
    List<TableReportVO> models;
    String tag,list[];

    public MyAdapter(Callback<List<TableReportVO>> c, List<TableReportVO> models, String tag) {
        this.c = c;
        this.models = models;
        this.tag=tag;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        if (tag=="ActTable" || tag=="RechTable" || tag=="SimexTable") {
            list = new String[]{"TIME: ", "TODAY: ", "LAST WEEK: ", "DIFFERENCE: ", "DIFFERENCE%: "};
            if(Float.parseFloat(models.get(position).getDiff_prct())>=0 && Float.parseFloat(models.get(position).getDiff_prct())<=5000)
                ((CardView)holder.itemView).setCardBackgroundColor(Color.GREEN);
            if(Float.parseFloat(models.get(position).getDiff_prct())>=(-30) && Float.parseFloat(models.get(position).getDiff_prct())<=(-10))
                ((CardView)holder.itemView).setCardBackgroundColor(Color.YELLOW);
            if(Float.parseFloat(models.get(position).getDiff_prct())>=(-5000) && Float.parseFloat(models.get(position).getDiff_prct())<(-30))
                ((CardView)holder.itemView).setCardBackgroundColor(Color.RED);
        }

        if (tag=="ActCircleTable" || tag=="RechCircleTable" || tag=="SimexCircleTable") {
            list = new String[]{"CIRCLE: ", "TODAY: ", "LAST WEEK: ", "DIFFERENCE: ", "DIFFERENCE%: "};
            if(Float.parseFloat(models.get(position).getDiff_prct())>=0 && Float.parseFloat(models.get(position).getDiff_prct())<=5000)
                ((CardView)holder.itemView).setCardBackgroundColor(Color.GREEN);
            if(Float.parseFloat(models.get(position).getDiff_prct())>=(-30) && Float.parseFloat(models.get(position).getDiff_prct())<=(-10))
                ((CardView)holder.itemView).setCardBackgroundColor(Color.YELLOW);
            if(Float.parseFloat(models.get(position).getDiff_prct())>=(-5000) && Float.parseFloat(models.get(position).getDiff_prct())<(-30))
                ((CardView)holder.itemView).setCardBackgroundColor(Color.RED);
        }

        if (tag=="MFP") {
            list = new String[]{"TIME: ", "IP: ", "HOSTNAME: ", "MAX CLIENTS: ", "REMARKS: "};
                if(Float.parseFloat(models.get(position).getDiff())>=1000 && Float.parseFloat(models.get(position).getDiff())<=3000)
                     ((CardView)holder.itemView).setCardBackgroundColor(Color.RED);
                else if(Float.parseFloat(models.get(position).getDiff())>=500 && Float.parseFloat(models.get(position).getDiff())<1000)
                    ((CardView)holder.itemView).setCardBackgroundColor(Color.YELLOW);
                else if(Float.parseFloat(models.get(position).getDiff())<500)
                    ((CardView)holder.itemView).setCardBackgroundColor(Color.GREEN);
        }

        holder.mTime.setText(list[0]+models.get(position).getTime());
        holder.mToday.setText(list[1]+models.get(position).getToday());
        holder.mLastweek.setText(list[2]+models.get(position).getLastweek());
        holder.mDiff.setText(list[3]+models.get(position).getDiff());
        holder.mDiffPrct.setText(list[4]+models.get(position).getDiff_prct());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

}
