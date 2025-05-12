package com.desafio.locadoraVeiculo.mapper;

import com.desafio.locadoraVeiculo.dto.DadosAluguel;
import com.desafio.locadoraVeiculo.entidade.Aluguel;
import com.desafio.locadoraVeiculo.entidade.ApoliceSeguro;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.entidade.Motorista;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-12T15:08:32-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class AluguelMapperStructImpl implements AluguelMapperStruct {

    @Override
    public Aluguel toEntity(DadosAluguel dto) {
        if ( dto == null ) {
            return null;
        }

        Aluguel aluguel = new Aluguel();

        aluguel.setDataPedido( dto.dataPedido() );
        aluguel.setDataEntrega( dto.dataEntrega() );
        aluguel.setDataDevolucao( dto.dataDevolucao() );
        aluguel.setValorTotal( dto.valorTotal() );
        aluguel.setMotorista( dto.motorista() );
        aluguel.setCarro( dto.carro() );
        aluguel.setApoliceSeguro( dto.apoliceSeguro() );

        return aluguel;
    }

    @Override
    public DadosAluguel toAluguelDto(Aluguel entity) {
        if ( entity == null ) {
            return null;
        }

        Calendar dataPedido = null;
        Date dataEntrega = null;
        Date dataDevolucao = null;
        BigDecimal valorTotal = null;
        Motorista motorista = null;
        Carro carro = null;
        ApoliceSeguro apoliceSeguro = null;

        dataPedido = entity.getDataPedido();
        dataEntrega = entity.getDataEntrega();
        dataDevolucao = entity.getDataDevolucao();
        valorTotal = entity.getValorTotal();
        motorista = entity.getMotorista();
        carro = entity.getCarro();
        apoliceSeguro = entity.getApoliceSeguro();

        DadosAluguel dadosAluguel = new DadosAluguel( dataPedido, dataEntrega, dataDevolucao, valorTotal, motorista, carro, apoliceSeguro );

        return dadosAluguel;
    }

    @Override
    public DadosAluguel toDadosAluguelDto(Aluguel entity) {
        if ( entity == null ) {
            return null;
        }

        Calendar dataPedido = null;
        Date dataEntrega = null;
        Date dataDevolucao = null;
        BigDecimal valorTotal = null;
        Motorista motorista = null;
        Carro carro = null;
        ApoliceSeguro apoliceSeguro = null;

        dataPedido = entity.getDataPedido();
        dataEntrega = entity.getDataEntrega();
        dataDevolucao = entity.getDataDevolucao();
        valorTotal = entity.getValorTotal();
        motorista = entity.getMotorista();
        carro = entity.getCarro();
        apoliceSeguro = entity.getApoliceSeguro();

        DadosAluguel dadosAluguel = new DadosAluguel( dataPedido, dataEntrega, dataDevolucao, valorTotal, motorista, carro, apoliceSeguro );

        return dadosAluguel;
    }
}
