package com.desafio.locadoraVeiculo.service;

import com.desafio.locadoraVeiculo.dto.DadosVeiculo;
import com.desafio.locadoraVeiculo.entidade.Acessorio;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.entidade.Categoria;
import com.desafio.locadoraVeiculo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository repository;

    public List<DadosVeiculo> listar(){

        List<Carro> lista =  repository.findAll();

        return lista.stream()
                .map(carro -> new DadosVeiculo(
                        carro.getPlaca(),
                        carro.getChassi(),
                        carro.getCor(),
                        carro.getValorDiaria(),
                        carro.getModeloCarro().getCategoria(),
                        carro.getAcessorio()
                )).collect(Collectors.toList());

    }

    public List<DadosVeiculo> listarFiltro(Categoria valor){

        List<Carro> categoria = repository.listarPorCategoria(valor);

        return categoria.stream()
                .map(carro -> new DadosVeiculo(
                        carro.getPlaca(),
                        carro.getChassi(),
                        carro.getCor(),
                        carro.getValorDiaria(),
                        carro.getModeloCarro().getCategoria(),
                        carro.getAcessorio()
                )).collect(Collectors.toList());

    }

    public List<DadosVeiculo> listarFiltroAcessorio(String valor){
        List<Carro> acessorio = repository.listarPorAcessorio(valor);

        return acessorio.stream()
                .map(carro -> new DadosVeiculo(
                        carro.getPlaca(),
                        carro.getChassi(),
                        carro.getCor(),
                        carro.getValorDiaria(),
                        carro.getModeloCarro().getCategoria(),
                        carro.getAcessorio()
                )).collect(Collectors.toList());

    }



}
