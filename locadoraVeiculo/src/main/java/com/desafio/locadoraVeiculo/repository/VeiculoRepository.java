package com.desafio.locadoraVeiculo.repository;

import com.desafio.locadoraVeiculo.dto.DadosVeiculo;
import com.desafio.locadoraVeiculo.entidade.Acessorio;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Carro, Long> {

    @Query("SELECT c FROM Carro c JOIN c.modeloCarro m WHERE m.categoria = :categoria")
    List<Carro> listarPorCategoria(Categoria categoria);

    @Query("SELECT c FROM Carro c JOIN c.acessorio m WHERE m.descricao = :acessorio")
    List<Carro> listarPorAcessorio(String acessorio);


}
