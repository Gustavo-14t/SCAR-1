-- 📌 Criando o banco de dados Condominio
-- Cria o banco de dados "Condominio" se ele não existir
CREATE DATABASE Condominio;
-- Seleciona o banco de dados "Condominio" para ser utilizado
USE Condominio;

drop database Condominio

-- 📌 Apagando tabelas se já existirem
-- Remove as tabelas caso elas já existam no banco de dados
DROP TABLE IF EXISTS ControleReserva;
DROP TABLE IF EXISTS Atividade;
DROP TABLE IF EXISTS Reserva;
DROP TABLE IF EXISTS Chave;
DROP TABLE IF EXISTS Morador;
DROP TABLE IF EXISTS Funcionario;
DROP TABLE IF EXISTS Unidade;

-- 📌 Apaga o banco de dados "Condominio" se necessário (não recomendado em produção)
-- DROP DATABASE Condominio;

-- 📌 Criando a tabela Unidade
-- Cria a tabela "Unidade", que armazenará informações sobre os imóveis do condomínio
CREATE TABLE Unidade (
    id_unidade INT PRIMARY KEY IDENTITY (1,3),  -- A coluna 'id_unidade' é a chave primária com incremento de 3 em 3
	id_chave INT FOREIGN KEY REFERENCES Chave(id_chave) NOT NULL, -- Referência à unidade à qual a chave pertence
	tipo VARCHAR(50) NOT NULL,                   -- Tipo do imóvel (ex: Apartamento, Casa)
    numero VARCHAR(10) NOT NULL,                 -- Número da unidade
    bloco VARCHAR(10) NOT NULL,                  -- Bloco da unidade
    capacidade VARCHAR(10) NOT NULL,             -- Capacidade de pessoas da unidade
    descricao VARCHAR(255),                      -- Descrição do imóvel
    nome VARCHAR(100) ,                  -- Nome do condomínio
    dimensoes VARCHAR(50)                       -- Dimensões da unidade                 -- Dimensões da unidade
);

-- 📌 Criando a tabela Funcionario
-- Cria a tabela "Funcionario", que armazenará dados dos funcionários do condomínio
CREATE TABLE Funcionario (
    id_funcionario INT PRIMARY KEY IDENTITY (1,3), -- A coluna 'id_funcionario' é a chave primária com incremento de 3 em 3
    nome VARCHAR(100) NOT NULL,                      -- Nome do funcionário
    cpf VARCHAR(14) UNIQUE NOT NULL,                 -- CPF do funcionário (único)
    telefone VARCHAR(20) NOT NULL,                   -- Telefone do funcionário
    endereco VARCHAR(200) NOT NULL,                  -- Endereço do funcionário
    departamento VARCHAR(100) NOT NULL,              -- Departamento do funcionário (ex: Segurança, Manutenção)
    senha VARCHAR(255)                               -- Senha de acesso do funcionário
);

-- 📌 Criando a tabela Morador
-- Cria a tabela "Morador", que armazenará dados dos moradores do condomínio
CREATE TABLE Morador (
    id_morador INT PRIMARY KEY IDENTITY (1,3), -- A coluna 'id_morador' é a chave primária com incremento de 3 em 3
    id_unidade INT FOREIGN KEY REFERENCES Unidade (id_unidade) NOT NULL, -- Referência à tabela Unidade, associando o morador à unidade
    nome VARCHAR(100) NOT NULL, -- Nome do morador
    cpf VARCHAR(14) UNIQUE NOT NULL, -- CPF do morador (único)
    email VARCHAR(100) NOT NULL, -- Email do morador
    data_nasc  VARCHAR(10) NOT NULL -- Data de nascimento do morador
);

-- 📌 Criando a tabela Chave
-- Cria a tabela "Chave", que armazenará informações sobre as chaves das unidades
CREATE TABLE Chave (
    id_chave INT PRIMARY KEY IDENTITY (1,3), -- A coluna 'id_chave' é a chave primária com incremento de 3 em 3
    nome VARCHAR(50) NOT NULL -- Nome da chave (ex: Chave da piscina)
);

-- 📌 Criando a tabela Reserva
-- Cria a tabela "Reserva", que gerenciará as reservas de chaves pelos moradores
CREATE TABLE Reserva (
    id_reserva INT PRIMARY KEY IDENTITY (1,3), -- A coluna 'id_reserva' é a chave primária com incremento de 3 em 3
    id_chave INT FOREIGN KEY (id_chave) REFERENCES Chave(id_chave) NOT NULL, -- Chave que está sendo reservada
    id_morador INT FOREIGN KEY (id_morador) REFERENCES Morador(id_morador) NOT NULL, -- Morador que fez a reserva
    id_unidade INT FOREIGN KEY (id_unidade) REFERENCES Unidade(id_unidade) NOT NULL, -- Unidade relacionada à reserva
    id_funcionario INT FOREIGN KEY (id_funcionario) REFERENCES Funcionario(id_funcionario) NOT NULL, -- Funcionário que gerencia a reserva
    data_reserva DATE NOT NULL, -- Data da reserva
    statu VARCHAR(20) NOT NULL DEFAULT 'pendente' -- Status da reserva (ex: pendente, aprovada, cancelada)
);

-- 📌 Criando a tabela Atividade
-- Cria a tabela "Atividade", que armazenará atividades realizadas pelos funcionários
CREATE TABLE Atividade (
    id_atividade INT PRIMARY KEY IDENTITY (1,3), -- A coluna 'id_atividade' é a chave primária com incremento de 3 em 3
    id_funcionario INT FOREIGN KEY (id_funcionario) REFERENCES Funcionario(id_funcionario) NOT NULL, -- Funcionário responsável pela atividade
    nome VARCHAR(100) NOT NULL, -- Nome da atividade
    descricao VARCHAR(255), -- Descrição da atividade
    datas DATE NOT NULL, -- Data da atividade
    statu VARCHAR(20) DEFAULT 'pendente' -- Status da atividade (ex: pendente, concluída)
);

-- 📌 Criando a tabela ControleReserva
-- Cria a tabela "ControleReserva", que gerencia a entrega e devolução das chaves
CREATE TABLE ControleReserva (
    id_controleReserva INT PRIMARY KEY IDENTITY (1,3), -- A coluna 'id_controleReserva' é a chave primária com incremento de 3 em 3
    id_reserva INT FOREIGN KEY (id_reserva) REFERENCES Reserva(id_reserva) NOT NULL, -- Referência à reserva associada
    data_entrega DATE NOT NULL, -- Data de entrega da chave
    data_devolucao DATE, -- Data de devolução da chave
    funcionario_entrega VARCHAR(100) NOT NULL, -- Funcionário responsável pela entrega
    funcionario_devolucao VARCHAR(100) -- Funcionário responsável pela devolução
);

-- Inserindo dados na tabela Unidade
-- Insere dados de exemplo na tabela "Unidade", representando os imóveis do condomínio
INSERT INTO Unidade (id_chave,tipo, numero, bloco, capacidade, descricao, nome, dimensoes)
VALUES
(1,'Apartamento', '101', 'A', '4', 'Apartamento térreo', 'Residencial Alpha', '80m²'),
(4,'Casa', 'B12', 'B', '6', 'Casa com quintal', 'Condomínio Verde', '120m²'),
(7,'Apartamento', '305', 'C', '3', 'Apartamento com vista', 'Residencial Beta', '90m²');
SELECT* FROM Unidade;
-- Inserindo dados na tabela Funcionario
-- Insere dados de exemplo na tabela "Funcionario", representando os funcionários do condomínio
INSERT INTO Funcionario (nome, cpf, telefone, endereco, departamento, senha)
VALUES
('Robertin', '400.289.231-04', '(11) 92156-7890', 'Rua Perola, 789', 'Porteiro', 'port123'),
('Bolt Wirtz', '145.654.801-03', '(11) 9678-7901', 'Rua dos Couves, 194', 'Sindico', 'adm123'),
('Carlos Souza', '123.456.789-01', '(11) 98765-4321', 'Rua das Flores, 123', 'Segurança', 'senha123'),
('Mariana Lima', '987.654.321-02', '(11) 91234-5678', 'Av. Central, 456', 'Administração', 'admin456'),
('Roberto Alves', '111.222.333-44', '(11) 93456-7890', 'Rua Verde, 789', 'Manutenção', 'manut789');

-- Inserindo dados na tabela Morador
-- Insere dados de exemplo na tabela "Morador", associando os moradores às unidades
INSERT INTO Morador (id_unidade, nome, cpf, email, data_nasc)
VALUES
(7, 'Ana Pereira', '555.666.777-88', 'ana@email.com', '1985-07-15'),
(1, 'João Mendes', '999.888.777-66', 'joao@email.com', '1990-02-25'),
(4, 'Fernanda Costa', '444.333.222-11', 'fernanda@email.com', '1982-11-10');

SELECT*FROM Morador;

-- Inserindo dados na tabela Chave
-- Insere dados de exemplo na tabela "Chave", associando as chaves às unidades
INSERT INTO Chave
VALUES
('Chave do salão de festas'),
('Chave da piscina'),
('Chave da garagem');

-- Inserindo dados na tabela Reserva
-- Insere dados de exemplo na tabela "Reserva", criando algumas reservas
INSERT INTO Reserva (data_reserva, statu)
VALUES
('2025-02-10', 'pendente'),
('2025-02-12', 'aprovada'),
('2025-02-15', 'cancelada');

-- Inserindo dados na tabela Atividade
-- Insere dados de exemplo na tabela "Atividade", representando algumas atividades no condomínio
INSERT INTO Atividade (nome, descricao, datas, statu)
VALUES
('Troca de lâmpadas', 'Substituição das lâmpadas queimadas nas áreas comuns', '2025-02-05', 'concluída'),
('Ronda noturna', 'Monitoramento da segurança do condomínio', '2025-02-06', 'pendente'),
('Reunião com moradores', 'Discussão sobre novas regras do condomínio', '2025-02-07', 'concluída');

-- Inserindo dados na tabela ControleReserva
-- Insere dados de exemplo na tabela "ControleReserva", controlando a entrega e devolução das chaves
INSERT INTO ControleReserva (data_entrega, data_devolucao, funcionario_entrega, funcionario_devolucao)
VALUES
('2025-02-10', NULL, 'Carlos Souza', NULL),
('2025-02-12', '2025-02-13', 'Mariana Lima', 'Roberto Alves'),

-- 📌 Consultando a tabela Unidade
SELECT * FROM Unidade;

-- 📌 Consultando a tabela Funcionario
SELECT * FROM Funcionario;

-- 📌 Consultando a tabela Morador
SELECT * FROM Morador;

-- 📌 Consultando a tabela Chave
SELECT * FROM Chave;

-- 📌 Consultando a tabela Reserva
SELECT * FROM Reserva;

-- 📌 Consultando a tabela Atividade
SELECT * FROM Atividade;

-- 📌 Consultando a tabela ControleReserva
SELECT * FROM ControleReserva;

