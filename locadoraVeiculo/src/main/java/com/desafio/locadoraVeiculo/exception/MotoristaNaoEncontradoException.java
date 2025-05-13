package com.desafio.locadoraVeiculo.exception;

public class MotoristaNaoEncontradoException extends Throwable {
    public MotoristaNaoEncontradoException(String motoristaNãoFoiEncontrado) {
        super(motoristaNãoFoiEncontrado);
    }
}
