package com.example.projeto_calculadora.model;

public class ResultadoCalculo {
    private String mensagem;
    private double valor;

    public ResultadoCalculo(String mensagem, double valor) {
        this.mensagem = mensagem;
        this.valor = valor;
    }

    // Getters
    public String getMensagem() { return mensagem; }
    public double getValor() { return valor; }
}
