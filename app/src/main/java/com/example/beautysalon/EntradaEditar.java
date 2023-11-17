package com.example.beautysalon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntradaEditar extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] opcoes = {"Sim", "Não"};
    Button btnAdd;

    ServicoDAO servicoDAO;

    EditText campoNomeCliente;
    EditText campoServico;
    EditText campoValor;
    EditText campoDia;
    EditText campoMes;
    EditText campoAno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_editar);

        final Date[] dataFormatada = new Date[1];
        Date dataFormatada2;
        servicoDAO = new ServicoDAO(this);

        final CalendarView[] calendar = new CalendarView[1];
        btnAdd = findViewById(R.id.button5);
        campoNomeCliente = findViewById(R.id.editTextTextPersonName);
        campoServico = findViewById(R.id.editTextTextPersonName3);
        campoValor = findViewById(R.id.editTextTextPersonName4);
        campoDia = findViewById(R.id.editTextNumber3);
        campoMes = findViewById(R.id.editTextNumber2);
        campoAno = findViewById(R.id.editTextNumber);

        Spinner spino = findViewById(R.id.spinner);
        spino.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                opcoes);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spino.setAdapter(ad);
        String respostaSN = spino.getSelectedItem().toString();



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServicoDTO servicoDTO = new ServicoDTO();

                String strNomeCliente = campoNomeCliente.getText().toString();
                String strServico = campoServico.getText().toString();
                float valor = Float.parseFloat(campoValor.getText().toString());
                String respostaSN = spino.getSelectedItem().toString();

                //////////////////////////////////////////////////////////
                String ano = campoAno.getText().toString();
                String mes = campoMes.getText().toString();
                String dia = campoDia.getText().toString();

                String strData = ano.concat("-").concat(mes).concat("-").concat(dia);


                servicoDTO.setCliente(strNomeCliente);
                servicoDTO.setNomeServico(strServico);
                servicoDTO.setValor(valor);
                servicoDTO.setData(strData);
                servicoDTO.setDevendo(respostaSN);


                servicoDAO.inserir(servicoDTO);
                //Date dataFormatada = formato.parse();

                campoNomeCliente.setText("");
                campoServico.setText("");
                campoValor.setText("");
                campoDia.setText("");
                campoMes.setText("");
                campoAno.setText("");

                Toast.makeText(EntradaEditar.this, "Dados Adicionados!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){

            //Toast.makeText(EntradaEditar.this, "Sim Escolhido!", Toast.LENGTH_LONG).show();
        }
        if(position == 1){

            //Toast.makeText(EntradaEditar.this, "Não Escolhido!", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}