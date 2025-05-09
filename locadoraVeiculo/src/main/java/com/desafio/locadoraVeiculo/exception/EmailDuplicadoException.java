package com.desafio.locadoraVeiculo.exception;

public class EmailDuplicadoException extends RuntimeException {
    public EmailDuplicadoException(String emailJáExistenteNoBanco) {
        super(emailJáExistenteNoBanco);

    }


}

