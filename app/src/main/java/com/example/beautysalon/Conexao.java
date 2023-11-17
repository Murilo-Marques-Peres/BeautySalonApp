package com.example.beautysalon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {
    private static final String name = "banco.db";
    private static final int version = 1;
    public Conexao(Context context) {super(context, name, null, version);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table saida(id integer primary key autoincrement, " +
                "marcaproduto varchar(45), valor decimal(8,2), data text)");
        db.execSQL("create table servico(id integer primary key autoincrement," +
                "cliente varchar(45), nomeservico varchar(40), valor decimal (7,2), dataservico varchar(20), devendo varchar(7))");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
