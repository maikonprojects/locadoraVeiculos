package com.desafio.locadoraVeiculo.controller;

import com.desafio.locadoraVeiculo.dto.DadosVeiculo;
import com.desafio.locadoraVeiculo.entidade.Acessorio;
import com.desafio.locadoraVeiculo.entidade.Categoria;
import com.desafio.locadoraVeiculo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService service;


//
//    @GetMapping("/{categoria}/{acessorio}")
//    public ResponseEntity<List<DadosVeiculo>> veiculoDisponivel(@PathVariable Categoria categoria, @PathVariable String acessorio){
//        service.
//    }

    @GetMapping
    public ResponseEntity<List<DadosVeiculo>> veiculoDisponivel() {
        return ResponseEntity.status(200).body(service.listar());
    }

    @GetMapping("/categoria/{valor}")
    public ResponseEntity<List<DadosVeiculo>> veiculoDisponivelFiltroCategoria(@PathVariable Categoria valor) {
        return ResponseEntity.status(200).body(service.listarFiltro(valor));

    }

    @GetMapping ("/acessorio/{valor}")
    public ResponseEntity<List<DadosVeiculo>> veiculoDisponivelFiltroAcessorio(@PathVariable String valor) {
        return ResponseEntity.status(200).body(service.listarFiltroAcessorio(valor));

    }


}

