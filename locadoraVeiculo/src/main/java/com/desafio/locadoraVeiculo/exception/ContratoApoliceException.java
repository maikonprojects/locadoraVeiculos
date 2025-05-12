package com.desafio.locadoraVeiculo.exception;

public class ContratoApoliceException extends Throwable {
    public ContratoApoliceException(String apoliceNãoExiste) {
        super(apoliceNãoExiste);
    }
}
