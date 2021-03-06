package com.semenov.dollarrate;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DataViewHolder>
{

    ArrayList<ClassListItem> text/* = new ArrayList<>()*/;

    public MyAdapter (ArrayList<ClassListItem> text){
        this.text = text;
        Log.d("Log", "text " + text.size());
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        TextView mTextView2;
        TextView mTextView3;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item);
            mTextView2 = (TextView) itemView.findViewById(R.id.item2);
            mTextView3 = (TextView) itemView.findViewById(R.id.item3);
        }
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.mTextView.setText(text.get(position).getText_1());
        holder.mTextView2.setText(text.get(position).getText_2());
        holder.mTextView3.setText(text.get(position).getText_3());
    }

    @Override
    public int getItemCount() {
        return text.size();
    }
}
