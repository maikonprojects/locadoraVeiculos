package com.desafio.locadoraVeiculo.dto;

import com.desafio.locadoraVeiculo.entidade.*;

import java.math.BigDecimal;
import java.util.List;

public record DadosVeiculo(String placa, String chassi, String cor, BigDecimal valorDiaria, ModeloCarro modeloCarro, boolean disponivel, List<Acessorio> acessorio) {


    public DadosVeiculo(Carro veiculo) {
        this(
                veiculo.getPlaca(),
                veiculo.getChassi(),
                veiculo.getCor(),
                veiculo.getValorDiaria(),
                veiculo.getModeloCarro(),
                veiculo.getDisponivel(),
                veiculo.getAcessorio()
        );
    }


}

