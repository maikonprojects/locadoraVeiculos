package com.desafio.locadoraVeiculo.entidade;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("funcionario")
public class Funcionario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String matricula;

    public Funcionario() {
    }


    public Funcionario(String matricula) {
        this.matricula = matricula;
    }

    public Funcionario(String cpf, String nome, Date dataNascimento, Sexo sexo, String email, String matricula) {
        super(cpf, nome, dataNascimento, sexo, email);
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}
