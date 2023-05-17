package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.model.DailyBoxOfficeList;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<DailyBoxOfficeList> dataList;
    private Context context;

    public CustomAdapter(Context context, List<DailyBoxOfficeList> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        DailyBoxOfficeList item = dataList.get(position);
        holder.movieNm.setText(item.getMovieNm());
        holder.openDt.setText(item.getOpenDt());
        holder.rank.setText(String.valueOf(item.getRank()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setData(List<DailyBoxOfficeList> dataInfo) {
        dataList.clear();
        dataList.addAll(dataInfo);
        notifyDataSetChanged();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView movieNm;
        TextView openDt;
        TextView rank;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            movieNm = itemView.findViewById(R.id.movieNm);
            openDt = itemView.findViewById(R.id.openDt);
            rank = itemView.findViewById(R.id.rank);
        }
    }
}