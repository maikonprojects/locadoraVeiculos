package com.desafio.locadoraVeiculo.dto;

import com.desafio.locadoraVeiculo.entidade.ApoliceSeguro;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.entidade.Motorista;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public record DadosAluguel(Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal, Motorista motorista, Carro carro, ApoliceSeguro apoliceSeguro) {
}
