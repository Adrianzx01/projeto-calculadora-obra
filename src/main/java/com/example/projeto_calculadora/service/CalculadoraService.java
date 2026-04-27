package com.example.projeto_calculadora.service;

import com.example.projeto_calculadora.model.Parede;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalculadoraService {

    public double calcularVolumeConcreto(List<Parede> paredes, double alturaViga) {
        double volumeTotal = 0;
        for (Parede parede : paredes) {
            // Volume = Largura (da parede) * Altura (da viga) * Comprimento (da parede)
            volumeTotal += parede.getLargura() * alturaViga * parede.getComprimento();
        }
        return volumeTotal;
    }
}
