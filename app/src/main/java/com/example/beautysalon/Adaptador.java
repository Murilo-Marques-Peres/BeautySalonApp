package com.example.beautysalon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.NossoViewHolder>{
    @NonNull
    @Override
    public Adaptador.NossoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itens, parent, false);
        NossoViewHolder viewHolder = new NossoViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.NossoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class NossoViewHolder extends RecyclerView.ViewHolder {
        NumberPicker mPrimeiraHora, mPrimeiroMinuto, mSegundaHora, mSegundoMinuto;
        Button mButtonCalcular;
        TextView mTextViewTempo;

        public NossoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public void atualizarListagemCompleta(ArrayList<Servico> mlistTempos) {
        //this.mlistTempos = mlistTempos;
        notifyDataSetChanged();
    }
}
