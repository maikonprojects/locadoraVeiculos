-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS locadora;
USE locadora;

-- drop database locadora;

-- Enumeradores
CREATE TABLE sexo (
    id ENUM('MASCULINO', 'FEMININO') PRIMARY KEY
);

CREATE TABLE categoria (
    id ENUM(
        'HATCH_COMPACTO',
        'HATCH_LUXO',
        'SEDAN_COMPACTO',
        'SEDAN_LUXO',
        'SEDAN_GRANDE',
        'MINIVAN',
        'ESPORTIVO',
        'UTILITARIO_COMERCIAL'
    ) PRIMARY KEY
);

-- Tabela Pessoa
CREATE TABLE pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    sexo ENUM('MASCULINO', 'FEMININO') NOT NULL
);

-- Tabela Motorista
CREATE TABLE motorista (
    id BIGINT PRIMARY KEY,
    numero_cnh VARCHAR(20) NOT NULL,
    FOREIGN KEY (id) REFERENCES pessoa(id)
);

-- Tabela Funcionario
CREATE TABLE funcionario (
    id BIGINT PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL,
    FOREIGN KEY (id) REFERENCES pessoa(id)
);

-- Tabela Fabricante
CREATE TABLE fabricante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Tabela Modelo_Carro
CREATE TABLE modelo_carro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    categoria ENUM(
        'HATCH_COMPACTO',
        'HATCH_LUXO',
        'SEDAN_COMPACTO',
        'SEDAN_LUXO',
        'SEDAN_GRANDE',
        'MINIVAN',
        'ESPORTIVO',
        'UTILITARIO_COMERCIAL'
    ) NOT NULL,
    id_fabricante BIGINT,
    FOREIGN KEY (id_fabricante) REFERENCES fabricante(id)
);

-- Tabela Carro
CREATE TABLE carro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(10) NOT NULL UNIQUE,
    chassi VARCHAR(20) NOT NULL UNIQUE,
    cor VARCHAR(30),
    valor_diaria DECIMAL(10,2) NOT NULL,
    id_modelo BIGINT NOT NULL,
    FOREIGN KEY (id_modelo) REFERENCES modelo_carro(id)
);

-- Tabela Acessorio
CREATE TABLE acessorio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL
);

-- Tabela carro_acessorio (relacionamento N:N)
CREATE TABLE carro_acessorio (
    id_carro BIGINT,
    id_acessorio BIGINT,
    PRIMARY KEY (id_carro, id_acessorio),
    FOREIGN KEY (id_carro) REFERENCES carro(id),
    FOREIGN KEY (id_acessorio) REFERENCES acessorio(id)
);

-- Tabela Apolice_Seguro
CREATE TABLE apolice_seguro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor_franquia DECIMAL(10,2),
    protecao_terceiros BOOLEAN,
    protecao_contra_buracos BOOLEAN,
    protecao_roubo BOOLEAN
);

-- Tabela Aluguel
CREATE TABLE aluguel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_retirada DATE NOT NULL,
    data_prevista_devolucao DATE NOT NULL,
    data_devolucao DATE,
    valor_total DECIMAL(10,2),
    id_motorista BIGINT NOT NULL,
    id_carro BIGINT NOT NULL,
    id_apolice BIGINT,
    FOREIGN KEY (id_motorista) REFERENCES motorista(id),
    FOREIGN KEY (id_carro) REFERENCES carro(id),
    FOREIGN KEY (id_apolice) REFERENCES apolice_seguro(id)
);
