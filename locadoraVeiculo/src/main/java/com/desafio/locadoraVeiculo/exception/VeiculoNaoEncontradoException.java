package com.desafio.locadoraVeiculo.exception;

public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException(String nãoExisteEsseIdCadastrado) {
        super(nãoExisteEsseIdCadastrado);

    }
}
