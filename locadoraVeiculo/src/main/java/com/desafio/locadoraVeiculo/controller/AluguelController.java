package com.desafio.locadoraVeiculo.controller;

import com.desafio.locadoraVeiculo.dto.DadosAluguel;
import com.desafio.locadoraVeiculo.entidade.Aluguel;
import com.desafio.locadoraVeiculo.exception.AluguelForaDoCarrinhoException;
import com.desafio.locadoraVeiculo.exception.ContratoApoliceException;
import com.desafio.locadoraVeiculo.exception.DisponibilidadeMotoristaException;
import com.desafio.locadoraVeiculo.exception.DisponibilidadePorDataException;
import com.desafio.locadoraVeiculo.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    AluguelService service;

    @PostMapping("/carrinho")
    public ResponseEntity<DadosAluguel> alugar(@RequestBody DadosAluguel dados) throws DisponibilidadePorDataException, ContratoApoliceException, DisponibilidadeMotoristaException {
        return ResponseEntity.status(201).body(service.alugarPorData(dados));

    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<List<DadosAluguel>> listarCarrinhoPorCliente(@PathVariable Long id) {
        return ResponseEntity.status(200).body(service.listar(id));
    }

    @PatchMapping("/pagar/{id}")
    public ResponseEntity<DadosAluguel> confirmandoAluguel(@PathVariable Long id) throws AluguelForaDoCarrinhoException {
        return ResponseEntity.status(200).body(service.confirmar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosAluguel> atualizarAluguel(@PathVariable Long id, @RequestBody DadosAluguel aluguel) throws DisponibilidadePorDataException, ContratoApoliceException, DisponibilidadeMotoristaException {
        return ResponseEntity.status(200).body(service.atualizar(id,aluguel));
    }







}
