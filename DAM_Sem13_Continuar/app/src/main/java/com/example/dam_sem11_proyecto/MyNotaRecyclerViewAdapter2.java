package com.example.dam_sem11_proyecto;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.dam_sem11_proyecto.databinding.FragmentItem2Binding;

import java.util.List;


public class MyNotaRecyclerViewAdapter2 extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter2.ViewHolder> {

    /*private final List<PlaceholderItem> mValues;

    public MyNotaRecyclerViewAdapter2(List<PlaceholderItem> items) {
        mValues = items;
    }
*/
    public final List<Notas> mValues;

    public MyNotaRecyclerViewAdapter2(List<Notas> mValues) {
        this.mValues = mValues;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItem2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
       /* holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
       // public PlaceholderItem mItem;

        public ViewHolder(FragmentItem2Binding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}