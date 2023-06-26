package com.example.dam_sem11_proyecto;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.dam_sem11_proyecto.databinding.FragmentItemBinding;

import java.util.List;


public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    public final List<Notas> mValues;
    private final NotasInteractionListener mListener;

    public MyNotaRecyclerViewAdapter(List<Notas> notasList, NotasInteractionListener listener) {
        mValues = notasList;
        mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitulo.setText(holder.mItem.getTitulo());
        holder.tvContenido.setText(holder.mItem.getContenido());
        if(holder.mItem.isFavorita()) {
            holder.ivFavorita.setImageResource(R.drawable.baseline_star_border_24);
        }
        holder.ivFavorita.setOnClickListener((v)->{
            if(null != mListener){
                mListener.favoritaNotaClick(holder.mItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvTitulo;

        public final TextView tvContenido;
        public final ImageView ivFavorita;
        public Notas mItem;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvTitulo = view.findViewById(R.id.textViewTitulo);
            tvContenido = view.findViewById(R.id.textViewContenido);
            ivFavorita = view.findViewById(R.id.imageViewFavorita);
        }

        public ViewHolder(FragmentItemBinding binding) {
            super(binding);

        }


        @Override
        public String toString() {
            return super.toString() + " '" + tvTitulo.getText() + "'";
        }
    }
}