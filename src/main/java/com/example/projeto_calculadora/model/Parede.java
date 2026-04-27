package com.example.projeto_calculadora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeComodo; // Seria algo como uma cozinha ou quarto etc
    private double largura;
    private double altura;
    private double comprimento;
    private double espessura;

    // Janelas e Portas
    private boolean temJanela;
    private boolean temPorta;

    public Parede() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeComodo() { return nomeComodo; }
    public void setNomeComodo(String nomeComodo) { this.nomeComodo = nomeComodo; }
    public double getLargura() { return largura; }
    public void setLargura(double largura) { this.largura = largura; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public double getComprimento() { return comprimento; }
    public void setComprimento(double comprimento) { this.comprimento = comprimento; }
    public double getEspessura() { return espessura; }
    public void setEspessura(double espessura) { this.espessura = espessura; }
    public boolean isTemJanela() { return temJanela; }
    public void setTemJanela(boolean temJanela) { this.temJanela = temJanela; }
    public boolean isTemPorta() { return temPorta; }
    public void setTemPorta(boolean temPorta) { this.temPorta = temPorta; }
}