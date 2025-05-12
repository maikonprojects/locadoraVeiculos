package com.desafio.locadoraVeiculo.exception;

public class DisponibilidadePorDataException extends Throwable {
    public DisponibilidadePorDataException(String veículoNãoDisponível) {
        super(veículoNãoDisponível);
    }
}
