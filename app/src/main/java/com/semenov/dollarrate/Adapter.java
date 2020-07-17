package com.semenov.dollarrate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.DataViewHolder>
{

    ArrayList<newElements> text;

    public Adapter (ArrayList<newElements> text){
        this.text = text;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item);
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
        holder.mTextView.setText(text.get(position).getNum()); // поменять
    }

    @Override
    public int getItemCount() {
        return text.size();
    }
}
