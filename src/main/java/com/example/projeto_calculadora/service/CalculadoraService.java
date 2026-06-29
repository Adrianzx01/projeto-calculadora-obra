package com.example.projeto_calculadora.service;

import com.example.projeto_calculadora.model.Orcamento;
import com.example.projeto_calculadora.model.Parede;
import com.example.projeto_calculadora.repository.OrcamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculadoraService {

    private final OrcamentoRepository orcamentoRepository;

    public CalculadoraService(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    // ===== Calculos originais (inalterados) =====

    public double calcularVolumeConcreto(List<Parede> paredes, double alturaViga) {
        double volumeTotal = 0;
        for (Parede parede : paredes) {
            // Volume = Largura (da parede) * Altura (da viga) * Comprimento (da parede)
            volumeTotal += parede.getLargura() * alturaViga * parede.getComprimento();
        }
        return volumeTotal;
    }

    public double calcularQuantidadeTijolos(List<Parede> paredes, double largTijolo, double altTijolo) {
        double areaTotalParedes = 0;
        for (Parede parede : paredes) {
            double areaParede = parede.getComprimento() * parede.getAltura();
            areaTotalParedes += areaParede;
        }
        double areaTijolo = largTijolo * altTijolo;
        return areaTotalParedes / areaTijolo;
    }

    // ===== Novo: calcula e persiste um orcamento completo =====

    public Orcamento gerarESalvarOrcamento(String nomeUsuario, List<Parede> paredes,
                                           double alturaViga, double largTijolo, double altTijolo) {
        Orcamento orcamento = new Orcamento();
        orcamento.setNomeUsuario(nomeUsuario);
        orcamento.setParedes(paredes);
        orcamento.setAlturaViga(alturaViga);
        orcamento.setLargTijolo(largTijolo);
        orcamento.setAltTijolo(altTijolo);
        orcamento.setVolumeConcreto(calcularVolumeConcreto(paredes, alturaViga));
        orcamento.setQuantidadeTijolos(calcularQuantidadeTijolos(paredes, largTijolo, altTijolo));
        return orcamentoRepository.save(orcamento);
    }

    public List<Orcamento> listarTodos() {
        return orcamentoRepository.findAll();
    }

    public List<Orcamento> buscarPorUsuario(String nome) {
        return orcamentoRepository.findByNomeUsuarioContainingIgnoreCase(nome);
    }

    public Orcamento buscarPorNumero(Long id) {
        return orcamentoRepository.findById(id).orElse(null);
    }
}
