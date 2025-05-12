package com.desafio.locadoraVeiculo.exception;

public class DisponibilidadeMotoristaException extends Throwable {
    public DisponibilidadeMotoristaException(String motoristaNãoEstáDisponível) {
        super(motoristaNãoEstáDisponível);
    }
}
