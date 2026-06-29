package com.example.projeto_calculadora.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um orcamento calculado e salvo no banco.
 * Atende a Etapa 1 - Passo 2: permite buscar por numero do orcamento ou nome do usuario.
 */
@Entity
@Table(name = "orcamento")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // funciona como o "numero do orcamento"

    private String nomeUsuario;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    // Parametros usados no calculo
    private double alturaViga;
    private double largTijolo;
    private double altTijolo;

    // Resultados calculados
    private double volumeConcreto;
    private double quantidadeTijolos;

    // Paredes que compoem este orcamento (a "planta" informada)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orcamento_id")
    private List<Parede> paredes = new ArrayList<>();

    public Orcamento() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
    public double getAlturaViga() { return alturaViga; }
    public void setAlturaViga(double alturaViga) { this.alturaViga = alturaViga; }
    public double getLargTijolo() { return largTijolo; }
    public void setLargTijolo(double largTijolo) { this.largTijolo = largTijolo; }
    public double getAltTijolo() { return altTijolo; }
    public void setAltTijolo(double altTijolo) { this.altTijolo = altTijolo; }
    public double getVolumeConcreto() { return volumeConcreto; }
    public void setVolumeConcreto(double volumeConcreto) { this.volumeConcreto = volumeConcreto; }
    public double getQuantidadeTijolos() { return quantidadeTijolos; }
    public void setQuantidadeTijolos(double quantidadeTijolos) { this.quantidadeTijolos = quantidadeTijolos; }
    public List<Parede> getParedes() { return paredes; }
    public void setParedes(List<Parede> paredes) { this.paredes = paredes; }
}
