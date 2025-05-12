package com.desafio.locadoraVeiculo.mapper;

import com.desafio.locadoraVeiculo.dto.DadosAluguel;
import com.desafio.locadoraVeiculo.dto.DadosMotorista;
import com.desafio.locadoraVeiculo.entidade.Aluguel;
import com.desafio.locadoraVeiculo.entidade.Motorista;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AluguelMapperStruct {

    Aluguel toEntity(DadosAluguel dto);
    DadosAluguel toAluguelDto(Aluguel entity);
    DadosAluguel toDadosAluguelDto(Aluguel entity);
}
