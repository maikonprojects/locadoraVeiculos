package com.desafio.locadoraVeiculo.mapper;

import com.desafio.locadoraVeiculo.dto.DadosMotorista;
import com.desafio.locadoraVeiculo.entidade.Motorista;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-12T13:25:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class MotoristaMapperStructImpl implements MotoristaMapperStruct {

    @Override
    public Motorista toEntity(DadosMotorista dto) {
        if ( dto == null ) {
            return null;
        }

        Motorista motorista = new Motorista();

        motorista.setNome( dto.nome() );
        motorista.setDataNascimento( dto.dataNascimento() );
        motorista.setCpf( dto.cpf() );
        motorista.setEmail( dto.email() );
        motorista.setCnh( dto.cnh() );

        return motorista;
    }

    @Override
    public DadosMotorista toMotoristaDto(Motorista entity) {
        if ( entity == null ) {
            return null;
        }

        String nome = null;
        Date dataNascimento = null;
        String cpf = null;
        String cnh = null;
        String email = null;

        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        cpf = entity.getCpf();
        cnh = entity.getCnh();
        email = entity.getEmail();

        DadosMotorista dadosMotorista = new DadosMotorista( nome, dataNascimento, cpf, cnh, email );

        return dadosMotorista;
    }

    @Override
    public DadosMotorista toDadosMotoristaDto(Motorista entity) {
        if ( entity == null ) {
            return null;
        }

        String nome = null;
        Date dataNascimento = null;
        String cpf = null;
        String cnh = null;
        String email = null;

        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        cpf = entity.getCpf();
        cnh = entity.getCnh();
        email = entity.getEmail();

        DadosMotorista dadosMotorista = new DadosMotorista( nome, dataNascimento, cpf, cnh, email );

        return dadosMotorista;
    }
}
