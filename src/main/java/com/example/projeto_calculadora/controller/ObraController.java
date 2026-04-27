package com.example.projeto_calculadora.controller;

import com.example.projeto_calculadora.model.Parede;
import com.example.projeto_calculadora.model.ResultadoCalculo;
import com.example.projeto_calculadora.service.CalculadoraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obra")
public class ObraController {

    private final CalculadoraService service;

    public ObraController(CalculadoraService service) {
        this.service = service;
    }

    @PostMapping("/concreto")
    public ResultadoCalculo calcularConcreto(@RequestBody List<Parede> paredes, @RequestParam double alturaViga) {
        double volume = service.calcularVolumeConcreto(paredes, alturaViga);
        return new ResultadoCalculo("Volume total de concreto para a fundação", volume);
    }
}
