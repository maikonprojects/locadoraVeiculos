package com.desafio.locadoraVeiculo.dto;

import com.desafio.locadoraVeiculo.entidade.Acessorio;
import com.desafio.locadoraVeiculo.entidade.Categoria;

import java.math.BigDecimal;
import java.util.List;

public record DadosVeiculo(String placa, String chassi, String cor, BigDecimal valorDiaria, Categoria modeloCarro, List<Acessorio> acessorio) {
}
