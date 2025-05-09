package com.desafio.locadoraVeiculo.entidade;

import com.desafio.locadoraVeiculo.dto.DadosMotorista;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("motorista")
public class Motorista extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCnh;

    public Motorista() {
    }

    public Motorista(String numeroCNH) {
        this.numeroCnh = numeroCNH;
    }

    public Motorista(DadosMotorista dadosMotorista) {
        super(dadosMotorista.nome(), dadosMotorista.dataNascimento(), dadosMotorista.cpf(), dadosMotorista.email());
        this.numeroCnh = dadosMotorista.cnh();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCNH() {
        return numeroCnh;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCnh = numeroCNH;
    }


}
