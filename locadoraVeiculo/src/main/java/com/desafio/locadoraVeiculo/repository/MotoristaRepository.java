package com.desafio.locadoraVeiculo.repository;

import com.desafio.locadoraVeiculo.entidade.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Boolean existsByEmail(String email);
}
