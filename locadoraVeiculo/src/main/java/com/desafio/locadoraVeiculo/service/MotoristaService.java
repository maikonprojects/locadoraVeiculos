package com.desafio.locadoraVeiculo.service;

import com.desafio.locadoraVeiculo.dto.DadosMotorista;
import com.desafio.locadoraVeiculo.entidade.Motorista;
import com.desafio.locadoraVeiculo.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoristaService {

    @Autowired
    MotoristaRepository repository;

    public DadosMotorista cadastrar(DadosMotorista dados){
        Motorista motorista = new Motorista(dados);
        Motorista motoristaSalvo = repository.save(motorista);
        DadosMotorista dadosRetorno = new DadosMotorista(motoristaSalvo.getNome(), motoristaSalvo.getDataNascimento(), motoristaSalvo.getCpf(), motoristaSalvo.getNumeroCNH());
        return dadosRetorno;
    }

}
