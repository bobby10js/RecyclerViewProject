package com.example.recyclerviewproject;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public  class ThumbnailAdapter extends  RecyclerView.Adapter<ThumbnailAdapter.NumberViewHolder>  {
    private static ClickListener clickListener;
    private int count, i;

    ThumbnailAdapter(int count){
        this.count = count;
        i=0;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.card_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        viewHolder.tv.setText(i+"");
        i++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {

    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getItemCount() {
        return count;
    }

    void setOnItemClickListener(ClickListener clickListener) {
        ThumbnailAdapter.clickListener = clickListener;
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView tv;
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv = itemView.findViewById(R.id.textView);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getLayoutPosition(), v);
        }
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
