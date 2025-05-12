package com.desafio.locadoraVeiculo.service;

import com.desafio.locadoraVeiculo.dto.DadosAluguel;
import com.desafio.locadoraVeiculo.exception.VeiculoNaoEncontradoException;
import com.desafio.locadoraVeiculo.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AluguelService {

    @Autowired
    AluguelRepository repository;


    public DadosAluguel alugarPorData(DadosAluguel dados){
        if (repository.)

    }
}