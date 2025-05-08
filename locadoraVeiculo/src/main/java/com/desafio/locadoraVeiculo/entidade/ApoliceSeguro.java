package com.desafio.locadoraVeiculo.entidade;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private BigDecimal valorFranquia;


    private Boolean protecaoTerceiro;


    private Boolean protecaoCausasNaturais;


    private Boolean protecaoRoubo;



    public ApoliceSeguro() {
    }

    public ApoliceSeguro(BigDecimal valorFranquia, Boolean protecaoTerceiro, Boolean protecaoCausasNaturais, Boolean protecaoRoubo) {
        this.valorFranquia = valorFranquia;
        this.protecaoTerceiro = protecaoTerceiro;
        this.protecaoCausasNaturais = protecaoCausasNaturais;
        this.protecaoRoubo = protecaoRoubo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(BigDecimal valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public Boolean getProtecaoTerceiro() {
        return protecaoTerceiro;
    }

    public void setProtecaoTerceiro(Boolean protecaoTerceiro) {
        this.protecaoTerceiro = protecaoTerceiro;
    }

    public Boolean getProtecaoCausasNaturais() {
        return protecaoCausasNaturais;
    }

    public void setProtecaoCausasNaturais(Boolean protecaoCausasNaturais) {
        this.protecaoCausasNaturais = protecaoCausasNaturais;
    }

    public Boolean getProtecaoRoubo() {
        return protecaoRoubo;
    }

    public void setProtecaoRoubo(Boolean protecaoRoubo) {
        this.protecaoRoubo = protecaoRoubo;
    }
}
