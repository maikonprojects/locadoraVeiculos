package com.desafio.locadoraVeiculo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<String> handleEmailDuplicado(EmailDuplicadoException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(VeiculoNaoEncontradoException.class)
    public ResponseEntity<String> handleVeiculo(VeiculoNaoEncontradoException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(DisponibilidadePorDataException.class)
    public ResponseEntity<String> handleDispinivel(DisponibilidadePorDataException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(ContratoApoliceException.class)
    public ResponseEntity<String> handleApolice(ContratoApoliceException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(DisponibilidadeMotoristaException.class)
    public ResponseEntity<String> handleMotorista(DisponibilidadeMotoristaException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(AluguelForaDoCarrinhoException.class)
    public ResponseEntity<String> handleCarrinho(AluguelForaDoCarrinhoException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(AluguelNaoExisteException.class)
    public ResponseEntity<String> handleAluguel(AluguelNaoExisteException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }






}
