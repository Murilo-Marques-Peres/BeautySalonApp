package com.example.beautysalon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.util.ArrayList;

public class ServicoDAO {
    private Conexao conexao1;
    private SQLiteDatabase banco;
    public ServicoDAO(Context context){
        conexao1 = new Conexao(context);
        banco = conexao1.getWritableDatabase();
    }
    ArrayList<ServicoDTO> listaPesquisar = new ArrayList<>();

    public void inserir(ServicoDTO servicoDTO){
        Cursor cursor = banco.query("servico", new String[]{"id","cliente","nomeservico","valor","dataservico","devendo"},  null, null, null, null, null);
        ContentValues values = new ContentValues();
        values.put("cliente", servicoDTO.getCliente());
        values.put("nomeservico", servicoDTO.getNomeServico());
        values.put("valor", servicoDTO.getValor());
        values.put("dataservico", servicoDTO.getData());
        values.put("devendo", servicoDTO.getDevendo());
        banco.insert("servico", null, values);
    }
    public void remover(String cliente){
        banco.delete("servico", "cliente=yyy", null);
    }
    public ArrayList<ServicoDTO> pesquisarServicos(){
        Cursor cursor = banco.query("servico", new String[]{"id", "cliente", "nomeservico", "valor", "dataservico", "devendo"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            ServicoDTO servicoDTO = new ServicoDTO();
            servicoDTO.setId(cursor.getInt(0));
            servicoDTO.setCliente(cursor.getString(1));
            servicoDTO.setNomeServico(cursor.getString(2));
            servicoDTO.setValor(cursor.getFloat(3));
            servicoDTO.setData(cursor.getString(4));
            servicoDTO.setDevendo(cursor.getString(5));

            listaPesquisar.add(servicoDTO);
        }
        return listaPesquisar;
    }
}
