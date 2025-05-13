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


    private String cnh;

    public Motorista() {
        super();
    }

    public Motorista(String cnh) {
        this.cnh = cnh;
    }

    public Motorista(String cpf, String nome, Date dataNascimento, Sexo sexo, String email, String cnh) {
        super(cpf, nome, dataNascimento, sexo, email);
        this.cnh = cnh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

}
