package com.desafio.locadoraVeiculo.dto;

import com.desafio.locadoraVeiculo.entidade.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public record DadosAluguel(Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal, Motorista motorista, Carro carro, ApoliceSeguro apoliceSeguro, boolean carrinho, TipoPagamento tipoPagamento, StatusPagamento statusPagamento) {
}
