package com.example.beautysalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Entrada1 extends AppCompatActivity {
    Button btnEditar;
    Button btnVisualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada1);

        btnVisualizar = findViewById(R.id.button7);
        btnEditar = findViewById(R.id.button6);

        btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entrada1.this, EntradaVisualizar.class);
                startActivity(intent);
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entrada1.this, EntradaEditar.class);
                startActivity(intent);
            }
        });
    }
}