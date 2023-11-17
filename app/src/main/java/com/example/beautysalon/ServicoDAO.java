package com.example.beautysalon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;

public class ServicoDAO {
    private Conexao conexao1;
    private SQLiteDatabase banco;
    public ServicoDAO(Context context){
        conexao1 = new Conexao(context);
        banco = conexao1.getWritableDatabase();
    }

    public void inserir(Servico servico){
        Cursor cursor = banco.query("servico", new String[]{"id","cliente","nomeservico","valor","dataservico","devendo"},  null, null, null, null, null);
        ContentValues values = new ContentValues();
        values.put("cliente", servico.getCliente());
        values.put("nomeservico", servico.getNomeServico());
        values.put("valor", servico.getValor());
        values.put("dataservico", servico.getData());
        values.put("devendo", servico.getDevendo());
        banco.insert("servico", null, values);
    }
            /*
            ContentValues values = new ContentValues();
            values.put("numero", dados.getNumero());
            values.put("dose", dados.getDose());
            banco.insert("dados", null, values);
            confirmacao = true;
            x++;
        }
        if(!cursor.moveToNext() && (!confirmacao)){
            ContentValues values = new ContentValues();
            values.put("numero", dados.getNumero());
            values.put("dose", dados.getDose());
            banco.insert("dados", null, values);
            x++;
        }
    }
    */
}
