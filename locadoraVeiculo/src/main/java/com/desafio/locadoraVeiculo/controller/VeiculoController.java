package com.desafio.locadoraVeiculo.controller;

import com.desafio.locadoraVeiculo.dto.DadosAluguel;
import com.desafio.locadoraVeiculo.dto.DadosDisponivelData;
import com.desafio.locadoraVeiculo.dto.DadosVeiculo;
import com.desafio.locadoraVeiculo.entidade.Acessorio;
import com.desafio.locadoraVeiculo.entidade.Categoria;
import com.desafio.locadoraVeiculo.exception.VeiculoNaoEncontradoException;
import com.desafio.locadoraVeiculo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService service;


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


    @GetMapping("/{id}")
    public ResponseEntity<DadosVeiculo> listarVeiculoPorId(@PathVariable Long id) throws VeiculoNaoEncontradoException {
        return ResponseEntity.status(200).body(service.listarVeiculoPorId(id));
    }

    @GetMapping("/disponivel")
    public ResponseEntity<List<DadosVeiculo>> listarVeiculoDisponivel(@RequestBody DadosDisponivelData dados){
        return ResponseEntity.status(200).body(service.listarDisponivel(dados.dataInicio(), dados.dataFim()));

    }

//    @PostMapping("/aluguel")
//    public ResponseEntity<DadosAluguel> criarAluguel(@RequestBody DadosAluguel dadosAluguel ){
//        return ResponseEntity.status(200).body()
//
//    }





}

