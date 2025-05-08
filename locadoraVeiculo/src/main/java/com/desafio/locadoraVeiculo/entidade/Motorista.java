package com.desafio.locadoraVeiculo.entidade;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Motorista extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String numeroCNH;


    public Motorista() {
    }


    public Motorista(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public Motorista(Date dataNascimento, String nome, String cpf, String numeroCNH) {
        super(dataNascimento, nome, cpf);
        this.numeroCNH = numeroCNH;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }


}
