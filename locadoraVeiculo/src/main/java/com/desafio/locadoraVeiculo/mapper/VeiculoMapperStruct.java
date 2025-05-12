package com.desafio.locadoraVeiculo.mapper;

import com.desafio.locadoraVeiculo.dto.DadosVeiculo;
import com.desafio.locadoraVeiculo.entidade.Carro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeiculoMapperStruct {
    Carro toEntity(DadosVeiculo dto);
    DadosVeiculo toVeiculoDto(Carro entity);
    DadosVeiculo toDadosVeiculoDto(Carro entity);

}
