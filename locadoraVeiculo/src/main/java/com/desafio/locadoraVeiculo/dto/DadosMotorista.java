package com.desafio.locadoraVeiculo.dto;

import java.util.Date;

public record DadosMotorista(
   String nome,
   Date dataNascimento,
   String cpf,
   String cnh
) {}
