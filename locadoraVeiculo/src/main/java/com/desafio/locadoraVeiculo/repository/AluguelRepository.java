package com.desafio.locadoraVeiculo.repository;

import com.desafio.locadoraVeiculo.entidade.Aluguel;
import com.desafio.locadoraVeiculo.entidade.ApoliceSeguro;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.entidade.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    @Query("""
    SELECT c FROM Carro c
    WHERE NOT EXISTS (
        SELECT 1 FROM Aluguel a
        WHERE a.carro.id = c.id
          AND a.dataEntrega <= :dataFim
          AND a.dataDevolucao >= :dataInicio
    )
    AND c.id = :idCarro
""")
    Carro buscarCarrosParaAlugar(Date dataInicio, Date dataFim, Long idCarro);


    @Query("SELECT b FROM ApoliceSeguro b WHERE b.id = :idApolice")
    ApoliceSeguro buscarApolice(Long idApolice);

    @Query("SELECT c FROM Motorista c WHERE c.id = :idMotorista")
    Motorista buscarMotorista(Long idMotorista);

}
