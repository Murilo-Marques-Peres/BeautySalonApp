package com.example.beautysalon;

import java.io.Serializable;
import java.util.Date;

public class Servico{
    private String cliente;
    private String nomeServico;
    private float valor;
    private String data;
    private String devendo;

    public Servico(String cliente, String nomeServico, float valor, String data, String devendo){
        this.cliente = cliente;
        this.nomeServico = nomeServico;
        this.valor = valor;
        this.data = data;
        this.devendo = devendo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDevendo() {
        return devendo;
    }

    public void setDevendo(String devendo) {
        this.devendo = devendo;
    }
}
