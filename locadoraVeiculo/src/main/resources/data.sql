-- Inserindo pessoas com IDs fixos
INSERT INTO pessoa (id, dtype, cpf, data_nascimento, email, nome, sexo)
VALUES
(1, 'FUNCIONARIO', '12345678901', '1990-01-01', 'funcionario@exemplo.com', 'João Silva', 'MASCULINO'),
(2, 'MOTORISTA', '98765432100', '1985-05-15', 'motorista@exemplo.com', 'Maria Souza', 'FEMININO');

-- Inserindo funcionario (id da pessoa: 1)
INSERT INTO funcionario (matricula, id)
VALUES ('F123', 1);

-- Inserindo motorista (id da pessoa: 2)
INSERT INTO motorista (cnh, id)
VALUES ('CNH456789', 2);

-- Inserindo fabricante
INSERT INTO fabricante (id, nome)
VALUES (1, 'Fiat');

-- Inserindo modelo_carro (id_fabricante: 1)
INSERT INTO modelo_carro (id, categoria, descricao, id_fabricante)
VALUES (1, 'HATCH_COMPACTO', 'Fiat Uno 1.0', 1);

-- Inserindo carro (id_modelo: 1)
INSERT INTO carro (id, chassi, cor, placa, valor_diaria, id_modelo)
VALUES (1, '9BWZZZ377VT004251', 'Prata', 'ABC1D23', 99.90, 1);

-- Inserindo acessórios
INSERT INTO acessorio (id, descricao)
VALUES (1, 'Ar-condicionado'), (2, 'Airbag'), (3, 'ABS');

-- Associando acessórios ao carro (id_carro: 1, id_acessorio: 1, 2, 3)
INSERT INTO carro_acessorio (id_carro, id_acessorio)
VALUES (1, 1), (1, 2), (1, 3);

-- Inserindo apólice de seguro
INSERT INTO apolice_seguro (id, protecao_causas_naturais, protecao_roubo, protecao_terceiro, valor_franquia)
VALUES (1, true, true, false, 500.00);

-- Inserindo aluguel (id_apolice: 1, id_carro: 1, id_motorista: 2)
INSERT INTO aluguel (
    id, carrinho, data_devolucao, data_entrega, data_pedido,
    status_pagamento, tipo_pagamento, valor_total,
    id_apolice, id_carro, id_motorista
)
VALUES (
    1, true, '2025-05-20 10:00:00', '2025-05-18 09:00:00', '2025-05-16 08:00:00',
    'RESERVADO', 'CREDITO', 299.70,
    1, 1, 2
);
