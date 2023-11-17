package com.example.beautysalon;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.NossoViewHolder>{
    ServicoDAO servicoDAO;
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
        Button btnRemover1;


        public NossoViewHolder(@NonNull View itemView) {
            super(itemView);
            mTVCliente = itemView.findViewById(R.id.textView9);
            mTVServico = itemView.findViewById(R.id.textView13);
            mTVValor = itemView.findViewById(R.id.textView15);
            mTVDevendo = itemView.findViewById(R.id.textView16);
            mTVData = itemView.findViewById(R.id.textView18);
            btnRemover1 = itemView.findViewById(R.id.button8);

            servicoDAO = new ServicoDAO(itemView.getContext());

            String clienteNomeRemocao = mTVCliente.getText().toString();
            String servicoRemocao = mTVServico.getText().toString();



            btnRemover1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(itemView.getContext(), "botão Apertado", Toast.LENGTH_SHORT).show();
                    Dialog dialog = new Dialog(itemView.getContext());
                    dialog.setContentView(R.layout.mydialog);
                    dialog.show();

                    Button btnConfirmar = dialog.findViewById(R.id.button9);
                    Button btnNegar = dialog.findViewById(R.id.button10);



                    btnConfirmar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String clienteNomeRemocao = mTVCliente.getText().toString();
                            String servicoRemocao = mTVServico.getText().toString();
                            Toast.makeText(itemView.getContext(), "Dados Apagados!", Toast.LENGTH_SHORT).show();
                            servicoDAO.remover(clienteNomeRemocao, servicoRemocao);
                            dialog.dismiss();
                        }
                    });
                    btnNegar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                }
            });
        }
    }
    public void atualizarListagemCompleta(ArrayList<Servico> lista1) {
        this.lista1 = lista1;
        notifyDataSetChanged();
    }

}