-- Inserts para fabricante
INSERT INTO fabricante (nome) VALUES
('Toyota'),
('Ford'),
('Chevrolet'),
('Volkswagen');

-- Inserts para modelo_carro
INSERT INTO modelo_carro (descricao, categoria, id_fabricante) VALUES
('Corolla', 'SEDAN_MEDIO', 1),
('Hilux', 'UTILITARIO_COMERCIAL', 1),
('Fiesta', 'HATCH_COMPACTO', 2),
('Cruze', 'SEDAN_COMPACTO', 3),
('Golf GTI', 'ESPORTIVO', 4);

-- Inserts para carro
INSERT INTO carro (placa, chassi, cor, valor_diaria, id_modelo) VALUES
('ABC1A23', 'CHASSI12345678901', 'Prata', 150.00, 1),
('DEF4B56', 'CHASSI23456789012', 'Preto', 250.00, 2),
('GHI7C89', 'CHASSI34567890123', 'Azul', 100.00, 3),
('JKL0D12', 'CHASSI45678901234', 'Branco', 180.00, 4),
('MNO3E45', 'CHASSI56789012345', 'Vermelho', 300.00, 5);

-- Inserts para pessoa
INSERT INTO pessoa (nome, data_nascimento, cpf, sexo, email) VALUES
('João Silva', '1990-05-15', '123.456.789-00', 'MASCULINO', 'joao.silva@email.com'),
('Maria Oliveira', '1985-11-23', '987.654.321-00', 'FEMININO', 'maria.oliveira@email.com'),
('Carlos Souza', '1992-07-09', '456.789.123-00', 'MASCULINO', 'carlos.souza@email.com'),
('Fernanda Lima', '1998-02-17', '789.123.456-00', 'FEMININO', 'fernanda.lima@email.com');

-- Inserts para motorista
INSERT INTO motorista (id, cnh) VALUES
(1, 'CNH123456'),
(3, 'CNH789012');

-- Inserts para funcionario
INSERT INTO funcionario (id, matricula) VALUES
(2, 'MAT001'),
(4, 'MAT002');

-- Inserts para acessorio
INSERT INTO acessorio (descricao) VALUES
('Ar-condicionado'),
('Direção hidráulica'),
('Airbag'),
('Freios ABS');

-- Inserts para carro_acessorio
INSERT INTO carro_acessorio (id_carro, id_acessorio) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 4),
(4, 1),
(4, 3),
(5, 1),
(5, 2),
(5, 3),
(5, 4);

-- Inserts para apolice_seguro
INSERT INTO apolice_seguro (valor_franquia, protecao_terceiro, protecao_causas_naturais, protecao_roubo) VALUES
(1000.00, true, false, true),
(1500.00, true, true, true),
(500.00, true, true, true);

-- Inserts para aluguel
INSERT INTO aluguel (data_pedido, data_entrega, data_devolucao, valor_total, id_motorista, id_carro, id_apolice, carrinho, status_pagamento, tipo_pagamento) VALUES
('2025-05-01', '2025-05-05', '2025-05-04', 600.00, 1, 1, 1, 0, "PENDENTE", "DEBITO"),
('2025-05-02', '2025-05-07', '2025-03-05', 500.00, 3, 2, 2, 0, "PENDENTE", "PIX");