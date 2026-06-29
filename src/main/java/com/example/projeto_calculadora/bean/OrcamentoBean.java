package com.example.projeto_calculadora.bean;

import com.example.projeto_calculadora.model.Orcamento;
import com.example.projeto_calculadora.model.Parede;
import com.example.projeto_calculadora.service.CalculadoraService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Managed Bean (controlador da tela JSF).
 * Usa @Component do Spring + @SessionScope mapeado pelo JoinFaces.
 * O nome "orcamentoBean" e usado nas paginas .xhtml como #{orcamentoBean.xxx}
 */
@Component("orcamentoBean")
@SessionScope
public class OrcamentoBean implements Serializable {

    @Autowired
    private transient CalculadoraService service;

    // Dados do formulario
    private String nomeUsuario;
    private double alturaViga = 0.3;   // valores padrao razoaveis
    private double largTijolo = 0.19;
    private double altTijolo = 0.19;

    // A "planta": lista de paredes que o usuario adiciona
    private List<Parede> paredes = new ArrayList<>();
    private Parede paredeAtual = new Parede();

    // Resultado e historico
    private Orcamento ultimoOrcamento;
    private List<Orcamento> historico = new ArrayList<>();
    private String filtroUsuario;

    @PostConstruct
    public void init() {
        atualizarHistorico();
    }

    // Adiciona a parede preenchida no formulario a planta
    public void adicionarParede() {
        paredes.add(paredeAtual);
        paredeAtual = new Parede(); // limpa para a proxima
        addMsg(FacesMessage.SEVERITY_INFO, "Parede adicionada a planta.");
    }

    public void removerParede(Parede p) {
        paredes.remove(p);
    }

    // Calcula e salva o orcamento
    public void calcular() {
        if (paredes.isEmpty()) {
            addMsg(FacesMessage.SEVERITY_WARN, "Adicione ao menos uma parede antes de calcular.");
            return;
        }
        ultimoOrcamento = service.gerarESalvarOrcamento(
                nomeUsuario, new ArrayList<>(paredes), alturaViga, largTijolo, altTijolo);
        addMsg(FacesMessage.SEVERITY_INFO,
                "Orcamento #" + ultimoOrcamento.getId() + " calculado e salvo!");
        // limpa a planta para um novo orcamento
        paredes = new ArrayList<>();
        atualizarHistorico();
    }

    public void atualizarHistorico() {
        if (filtroUsuario != null && !filtroUsuario.isBlank()) {
            historico = service.buscarPorUsuario(filtroUsuario);
        } else {
            historico = service.listarTodos();
        }
    }

    private void addMsg(FacesMessage.Severity sev, String texto) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(sev, texto, null));
    }

    // Getters e Setters
    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
    public double getAlturaViga() { return alturaViga; }
    public void setAlturaViga(double alturaViga) { this.alturaViga = alturaViga; }
    public double getLargTijolo() { return largTijolo; }
    public void setLargTijolo(double largTijolo) { this.largTijolo = largTijolo; }
    public double getAltTijolo() { return altTijolo; }
    public void setAltTijolo(double altTijolo) { this.altTijolo = altTijolo; }
    public List<Parede> getParedes() { return paredes; }
    public void setParedes(List<Parede> paredes) { this.paredes = paredes; }
    public Parede getParedeAtual() { return paredeAtual; }
    public void setParedeAtual(Parede paredeAtual) { this.paredeAtual = paredeAtual; }
    public Orcamento getUltimoOrcamento() { return ultimoOrcamento; }
    public List<Orcamento> getHistorico() { return historico; }
    public String getFiltroUsuario() { return filtroUsuario; }
    public void setFiltroUsuario(String filtroUsuario) { this.filtroUsuario = filtroUsuario; }
}
