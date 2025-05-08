package com.desafio.locadoraVeiculo.entidade;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModelo")
    private ModeloCarro modeloCarro;


    @ManyToMany
    @JoinTable(
            name = "carro_acessorio",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<Acessorio> acessorio;


    public Carro() {
    }


    public Carro(String placa, String chassi, String cor, BigDecimal valorDiaria, List<Acessorio> acessorio) {
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.acessorio = acessorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public List<Acessorio> getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(List<Acessorio> acessorio) {
        this.acessorio = acessorio;
    }
}
