package com.c1ctech.androiddagger2example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.c1ctech.androiddagger2example.R;
import com.c1ctech.androiddagger2example.model.MatchCalender;


import java.util.List;


public class MatchCalenderAdapter extends RecyclerView.Adapter<MatchCalenderAdapter.MatchCalenderViewHolder> {

    List<MatchCalender> matchlist;
    Context context;


    public static class MatchCalenderViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView date;


        public MatchCalenderViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            date = (TextView) v.findViewById(R.id.date);
        }

    }

    public MatchCalenderAdapter(List<MatchCalender> matchlist, Context context) {
        this.matchlist = matchlist;
        this.context = context;

    }

    @Override
    public void onBindViewHolder(MatchCalenderViewHolder holder, int position) {
        holder.date.setText(matchlist.get(position).getDate());
        holder.name.setText(matchlist.get(position).getName());
    }

    @Override
    public MatchCalenderAdapter.MatchCalenderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_calender_item, parent, false);
        return new MatchCalenderViewHolder(view);

    }


    @Override
    public int getItemCount() {
        return matchlist.size();
    }
}

