package com.desafio.locadoraVeiculo.exception;

public class AluguelNaoExisteException extends RuntimeException {
    public AluguelNaoExisteException(String aluguelNaoEncontrado) {
        super(aluguelNaoEncontrado);
    }
}
