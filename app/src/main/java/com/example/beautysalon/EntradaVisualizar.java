package com.example.beautysalon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class EntradaVisualizar extends AppCompatActivity {
    private ServicoDAO servicoDAO;
    RecyclerView rvListagemServico;
    int tamanhoLista = 0;
    ArrayList<Servico> listaRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_visualizar);

        servicoDAO = new ServicoDAO(this);
        listaRV = new ArrayList<>();
        ArrayList<ServicoDTO> listaPesquisada = servicoDAO.pesquisarServicos();
        tamanhoLista = listaPesquisada.size();
        for(int x = 0; x < tamanhoLista; x++){
            String cliente = listaPesquisada.get(x).getCliente();
            String nomeServico = listaPesquisada.get(x).getNomeServico();
            Float valor = listaPesquisada.get(x).getValor();
            String devendo = listaPesquisada.get(x).getDevendo();
            String dataPes = listaPesquisada.get(x).getData();
            listaRV.add(new Servico(cliente, nomeServico, valor, dataPes, devendo));
        }


        ////////////////////////////////////////////
        rvListagemServico = findViewById(R.id.rvListagemServico);
        rvListagemServico.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvListagemServico.setLayoutManager(layoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvListagemServico.addItemDecoration(itemDecoration);

        Adaptador adaptador = new Adaptador();
        rvListagemServico.setAdapter(adaptador);
        adaptador.atualizarListagemCompleta(listaRV);
    }
}