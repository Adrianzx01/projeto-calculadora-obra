package com.example.projeto_calculadora.repository;

import com.example.projeto_calculadora.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio JPA (ORM) para persistir e buscar orcamentos.
 * Spring Data gera a implementacao automaticamente.
 */
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    // Busca todos os orcamentos de um usuario (ignora maiusculas/minusculas)
    List<Orcamento> findByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}
