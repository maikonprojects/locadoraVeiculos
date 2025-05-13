package com.desafio.locadoraVeiculo.mapper;

import com.desafio.locadoraVeiculo.dto.DadosVeiculo;
import com.desafio.locadoraVeiculo.entidade.Acessorio;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.entidade.ModeloCarro;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T11:56:44-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class VeiculoMapperStructImpl implements VeiculoMapperStruct {

    @Override
    public Carro toEntity(DadosVeiculo dto) {
        if ( dto == null ) {
            return null;
        }

        Carro carro = new Carro();

        carro.setPlaca( dto.placa() );
        carro.setChassi( dto.chassi() );
        carro.setCor( dto.cor() );
        carro.setValorDiaria( dto.valorDiaria() );
        List<Acessorio> list = dto.acessorio();
        if ( list != null ) {
            carro.setAcessorio( new ArrayList<Acessorio>( list ) );
        }
        carro.setModeloCarro( dto.modeloCarro() );

        return carro;
    }

    @Override
    public DadosVeiculo toVeiculoDto(Carro entity) {
        if ( entity == null ) {
            return null;
        }

        String placa = null;
        String chassi = null;
        String cor = null;
        BigDecimal valorDiaria = null;
        ModeloCarro modeloCarro = null;
        List<Acessorio> acessorio = null;

        placa = entity.getPlaca();
        chassi = entity.getChassi();
        cor = entity.getCor();
        valorDiaria = entity.getValorDiaria();
        modeloCarro = entity.getModeloCarro();
        List<Acessorio> list = entity.getAcessorio();
        if ( list != null ) {
            acessorio = new ArrayList<Acessorio>( list );
        }

        DadosVeiculo dadosVeiculo = new DadosVeiculo( placa, chassi, cor, valorDiaria, modeloCarro, acessorio );

        return dadosVeiculo;
    }

    @Override
    public DadosVeiculo toDadosVeiculoDto(Carro entity) {
        if ( entity == null ) {
            return null;
        }

        String placa = null;
        String chassi = null;
        String cor = null;
        BigDecimal valorDiaria = null;
        ModeloCarro modeloCarro = null;
        List<Acessorio> acessorio = null;

        placa = entity.getPlaca();
        chassi = entity.getChassi();
        cor = entity.getCor();
        valorDiaria = entity.getValorDiaria();
        modeloCarro = entity.getModeloCarro();
        List<Acessorio> list = entity.getAcessorio();
        if ( list != null ) {
            acessorio = new ArrayList<Acessorio>( list );
        }

        DadosVeiculo dadosVeiculo = new DadosVeiculo( placa, chassi, cor, valorDiaria, modeloCarro, acessorio );

        return dadosVeiculo;
    }
}
