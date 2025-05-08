package com.desafio.locadoraVeiculo.controller;

import com.desafio.locadoraVeiculo.dto.DadosMotorista;
import com.desafio.locadoraVeiculo.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    MotoristaService service;

    @PostMapping
    public ResponseEntity<DadosMotorista> post(@RequestBody DadosMotorista dados){
        return ResponseEntity.status(201).body(service.cadastrar(dados));
    }


}
