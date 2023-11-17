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
    ArrayList<Servico> lista1 = new ArrayList<>();
    @NonNull
    @Override
    public Adaptador.NossoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itens, parent, false);
        NossoViewHolder viewHolder = new NossoViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.NossoViewHolder holder, int position) {
        Servico servico = lista1.get(position);
        holder.mTVCliente.setText(servico.getCliente());
        holder.mTVServico.setText(servico.getNomeServico());
        holder.mTVValor.setText(String.format("R$%.2f", servico.getValor()));
        holder.mTVDevendo.setText(servico.getDevendo());
        holder.mTVData.setText(servico.getData());
        //holder.mTextViewNome.setText(infoRemedios.getNome());
    }

    @Override
    public int getItemCount() {
        if(lista1 == null){
            return 0;
        }
        return lista1.size();
    }
    public class NossoViewHolder extends RecyclerView.ViewHolder {
        TextView mTVID, mTVCliente, mTVServico, mTVValor, mTVDevendo, mTVData;

        public NossoViewHolder(@NonNull View itemView) {
            super(itemView);
            mTVCliente = itemView.findViewById(R.id.textView9);
            mTVServico = itemView.findViewById(R.id.textView13);
            mTVValor = itemView.findViewById(R.id.textView15);
            mTVDevendo = itemView.findViewById(R.id.textView16);
            mTVData = itemView.findViewById(R.id.textView18);
        }
    }
    public void atualizarListagemCompleta(ArrayList<Servico> lista1) {
        this.lista1 = lista1;
        notifyDataSetChanged();
    }
}
