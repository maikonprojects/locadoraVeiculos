package com.desafio.locadoraVeiculo.service;

import com.desafio.locadoraVeiculo.dto.DadosMotorista;
import com.desafio.locadoraVeiculo.entidade.Motorista;
import com.desafio.locadoraVeiculo.exception.EmailDuplicadoException;
import com.desafio.locadoraVeiculo.mapper.MotoristaMapperStruct;
import com.desafio.locadoraVeiculo.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MotoristaService {

    @Autowired
    MotoristaRepository repository;

    @Autowired
    private MotoristaMapperStruct motoristaMapperStruct;

    public DadosMotorista cadastrar(DadosMotorista dados) throws EmailDuplicadoException {

        if (repository.existsByEmail(dados.email())){
            throw new EmailDuplicadoException("Email já existente");
        }else {
            Motorista motorista = motoristaMapperStruct.toEntity(dados);
            Motorista motoristaSalvo = repository.save(motorista);
            return motoristaMapperStruct.toDadosMotoristaDto(motoristaSalvo);


        }




    }





}
