package com.desafio.locadoraVeiculo.entidade;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPedido;



    private Date dataEntrega;


    private Date dataDevolucao;


    private BigDecimal valorTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMotorista",nullable = false)
    private Motorista motorista;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCarro",nullable = false)
    private Carro carro;

    @OneToOne
    @JoinColumn(name = "idApolice")
    private ApoliceSeguro apoliceSeguro;


    private boolean carrinho = true;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;


    public Aluguel() {
    }

    public Aluguel(Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal, Motorista motorista, Carro carro, ApoliceSeguro apoliceSeguro, boolean carrinho, TipoPagamento tipoPagamento, StatusPagamento statusPagamento) {
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.motorista = motorista;
        this.carro = carro;
        this.apoliceSeguro = apoliceSeguro;
        this.carrinho = carrinho;
        this.tipoPagamento = tipoPagamento;
        this.statusPagamento = statusPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public ApoliceSeguro getApoliceSeguro() {
        return apoliceSeguro;
    }

    public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
        this.apoliceSeguro = apoliceSeguro;
    }

    public boolean isCarrinho() {
        return carrinho;
    }

    public void setCarrinho(boolean carrinho) {
        this.carrinho = carrinho;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
