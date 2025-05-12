package com.desafio.locadoraVeiculo.mapper;

import com.desafio.locadoraVeiculo.dto.DadosMotorista;
import com.desafio.locadoraVeiculo.dto.DadosVeiculo;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.entidade.Motorista;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MotoristaMapperStruct {
    Motorista toEntity(DadosMotorista dto);
    DadosMotorista toMotoristaDto(Motorista entity);
    DadosMotorista toDadosMotoristaDto(Motorista entity);
}
