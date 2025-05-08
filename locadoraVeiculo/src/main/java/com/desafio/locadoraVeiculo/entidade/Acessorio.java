package com.desafio.locadoraVeiculo.entidade;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "acessorio")
    private List<Carro> carros;

    private String descricao;

    public Acessorio() {
    }

    public Acessorio(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
