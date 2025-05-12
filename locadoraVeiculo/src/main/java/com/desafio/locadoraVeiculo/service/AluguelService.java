package com.desafio.locadoraVeiculo.service;

import com.desafio.locadoraVeiculo.dto.DadosAluguel;
import com.desafio.locadoraVeiculo.entidade.Aluguel;
import com.desafio.locadoraVeiculo.entidade.ApoliceSeguro;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.exception.ContratoApoliceException;
import com.desafio.locadoraVeiculo.exception.DisponibilidadeMotoristaException;
import com.desafio.locadoraVeiculo.exception.DisponibilidadePorDataException;
import com.desafio.locadoraVeiculo.exception.VeiculoNaoEncontradoException;
import com.desafio.locadoraVeiculo.mapper.AluguelMapperStruct;
import com.desafio.locadoraVeiculo.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class AluguelService {

    @Autowired
    AluguelRepository repository;

    @Autowired
    private AluguelMapperStruct aluguelMapperStruct;


    public DadosAluguel alugarPorData(DadosAluguel dados) throws DisponibilidadePorDataException, ContratoApoliceException, DisponibilidadeMotoristaException {
        Carro carro = repository.buscarCarrosParaAlugar(dados.dataDevolucao(), dados.dataEntrega(), dados.carro().getId());
        ApoliceSeguro apoliceSeguro = repository.buscarApolice(dados.apoliceSeguro().getId());

        if ( carro == null){
            throw new DisponibilidadePorDataException("Veículo não disponível");

        }

        if ( apoliceSeguro == null){
            throw new ContratoApoliceException("Apolice não existe");

        }
        if (repository.buscarMotorista(dados.motorista().getId()) == null){
            throw new DisponibilidadeMotoristaException("Motorista não está disponível");
        }

        long ax = dados.dataDevolucao().getTime() - dados.dataEntrega().getTime();
        long dias = ax / (1000 * 60 * 60 * 24);
        BigDecimal valor =  carro.getValorDiaria();
        BigDecimal valorTotal = valor.multiply(BigDecimal.valueOf(dias));

        Aluguel aluguel = aluguelMapperStruct.toEntity(dados);
        aluguel.setValorTotal(valorTotal);
        Aluguel aluguelNovo = repository.save(aluguel);
        return aluguelMapperStruct.toAluguelDto(aluguelNovo);
    }


}