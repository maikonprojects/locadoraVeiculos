package com.desafio.locadoraVeiculo.exception;

public class DataErradaException extends Throwable {
    public DataErradaException(String dataInválida) {
        super(dataInválida);
    }
}
