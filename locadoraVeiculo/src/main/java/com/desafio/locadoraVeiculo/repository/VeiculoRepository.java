package com.desafio.locadoraVeiculo.repository;

import com.desafio.locadoraVeiculo.dto.DadosVeiculo;
import com.desafio.locadoraVeiculo.entidade.Acessorio;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Carro, Long> {

    @Query("SELECT c FROM Carro c JOIN c.modeloCarro m WHERE m.categoria = :categoria")
    List<Carro> listarPorCategoria(Categoria categoria);

    @Query("SELECT c FROM Carro c JOIN c.acessorio m WHERE m.descricao = :acessorio")
    List<Carro> listarPorAcessorio(String acessorio);

    @Query("""
    SELECT c FROM Carro c
    WHERE NOT EXISTS (
        SELECT 1 FROM Aluguel a
        WHERE a.carro.id = c.id
          AND a.dataEntrega <= :dataFim
          AND a.dataDevolucao >= :dataInicio
    )
""")
    List<Carro> buscarCarrosDisponiveis(Date dataInicio, Date dataFim);


    @Query("""
    SELECT c FROM Carro c
    JOIN FETCH c.modeloCarro mc
    JOIN FETCH mc.fabricante f
    LEFT JOIN FETCH c.acessorio a
""")
    List<Carro> findAllComTudo();


}
