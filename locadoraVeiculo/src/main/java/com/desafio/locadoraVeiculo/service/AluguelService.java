package com.desafio.locadoraVeiculo.service;

import com.desafio.locadoraVeiculo.dto.DadosAluguel;
import com.desafio.locadoraVeiculo.entidade.Aluguel;
import com.desafio.locadoraVeiculo.entidade.ApoliceSeguro;
import com.desafio.locadoraVeiculo.entidade.Carro;
import com.desafio.locadoraVeiculo.entidade.StatusPagamento;
import com.desafio.locadoraVeiculo.exception.*;
import com.desafio.locadoraVeiculo.mapper.AluguelMapperStruct;
import com.desafio.locadoraVeiculo.repository.AluguelRepository;
import com.desafio.locadoraVeiculo.repository.MotoristaRepository;
import com.desafio.locadoraVeiculo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AluguelService {

    @Autowired
    AluguelRepository repository;

    @Autowired
    private AluguelMapperStruct aluguelMapperStruct;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;


    public DadosAluguel alugarPorData(DadosAluguel dados) throws DisponibilidadePorDataException, ContratoApoliceException, DisponibilidadeMotoristaException, DataErradaException {
        Carro carro = repository.buscarCarrosParaAlugar(dados.dataDevolucao(), dados.dataEntrega(), dados.carro().getId());
        ApoliceSeguro apoliceSeguro = repository.buscarApolice(dados.apoliceSeguro().getId());

        if ((dados.dataEntrega().after(dados.dataDevolucao()) )) {
            throw new DataErradaException("Data inválida");
        }

        if ( carro == null){
            throw new DisponibilidadePorDataException("Veículo não disponível");
        }

        if ( apoliceSeguro == null){
            throw new ContratoApoliceException("Apolice não existe");
        }

        if (repository.buscarMotorista(dados.motorista().getId()) == null){
            throw new DisponibilidadeMotoristaException("Motorista não está disponível");
        }




        long ax = dados.dataDevolucao().getTime() - dados.dataEntrega().getTime();
        long dias = ax / (1000 * 60 * 60 * 24);
        BigDecimal valor =  carro.getValorDiaria();
        BigDecimal valorTotal = valor.multiply(BigDecimal.valueOf(dias));

        Aluguel aluguel = aluguelMapperStruct.toEntity(dados);
        aluguel.setValorTotal(valorTotal);
        Aluguel aluguelNovo = repository.save(aluguel);
        return aluguelMapperStruct.toAluguelDto(aluguelNovo);
    }



    public List<DadosAluguel> listar(Long id){
       List<Aluguel> aluguel = repository.listandoPorCliente(id);
        return aluguel.stream()
                .map(aluguelMapperStruct::toAluguelDto)
                .collect(Collectors.toList());
    }


    public DadosAluguel confirmar(Long id) throws AluguelForaDoCarrinhoException {
        Aluguel aluguel = repository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException("Não existe esse ID cadastrado"));

        if (aluguel.getCarrinho() == false){
            throw new AluguelForaDoCarrinhoException("Aluguel já está fora do carrinho");
        }

        aluguel.setCarrinho(false);
        aluguel.setStatusPagamento(StatusPagamento.RESERVADO);
        Aluguel aluguelSalvo = repository.save(aluguel);
        return aluguelMapperStruct.toAluguelDto(aluguelSalvo);


    }

    public DadosAluguel atualizar(Long id, DadosAluguel dadosAluguel) throws DisponibilidadePorDataException, ContratoApoliceException, DisponibilidadeMotoristaException {
        Aluguel aluguel = repository.findById(id).orElseThrow(() -> new AluguelNaoExisteException("Aluguel não encontrado"));
        Carro carro = veiculoRepository.findById(dadosAluguel.carro().getId()).orElseThrow(() -> new DisponibilidadePorDataException("Veículo não disponível"));
        Carro carroVerificacao = repository.buscarCarrosParaAlugar(dadosAluguel.dataDevolucao(), dadosAluguel.dataEntrega(), dadosAluguel.carro().getId());
        ApoliceSeguro apoliceSeguro = repository.buscarApolice(dadosAluguel.apoliceSeguro().getId());

        if ( carroVerificacao == null){
            throw new DisponibilidadePorDataException("Veículo não disponível");

        }

        if ( apoliceSeguro == null){
            throw new ContratoApoliceException("Apolice não existe");

        }
        if (repository.buscarMotorista(dadosAluguel.motorista().getId()) == null){
            throw new DisponibilidadeMotoristaException("Motorista não está disponível");
        }

        aluguel.setDataEntrega(dadosAluguel.dataEntrega());
        aluguel.setDataDevolucao(dadosAluguel.dataDevolucao());
        aluguel.setMotorista(dadosAluguel.motorista());
        aluguel.setCarro(dadosAluguel.carro());
        aluguel.setApoliceSeguro(dadosAluguel.apoliceSeguro());
        aluguel.setTipoPagamento(dadosAluguel.tipoPagamento());
        aluguel.setStatusPagamento(dadosAluguel.statusPagamento());


        long ax = dadosAluguel.dataDevolucao().getTime() - dadosAluguel.dataEntrega().getTime();
        long dias = ax / (1000 * 60 * 60 * 24);
        BigDecimal valor =  carro.getValorDiaria();
        BigDecimal valorTotal = valor.multiply(BigDecimal.valueOf(dias));

        aluguel.setValorTotal(valorTotal);
        aluguel.setId(id);

        Aluguel aluguelSalvo = repository.save(aluguel);
        return aluguelMapperStruct.toAluguelDto(aluguelSalvo);


    }

    public List<DadosAluguel> listarCliente(Long id) throws MotoristaNaoEncontradoException {
        List<Aluguel> listandoPorCliente = repository.listandoAluguelPorCliente(id);

        Boolean existePorId = motoristaRepository.existsById(id);

        if (existePorId == false){
            throw new MotoristaNaoEncontradoException("Motorista não foi encontrado");
        }

        return listandoPorCliente.stream()
                .map(aluguelMapperStruct::toAluguelDto)
                .collect(Collectors.toList());
    }




}