/* Projeto Modelo de Dados Auto_Pecas */
/* 1) Criacao do banco Auto_Pecas */
CREATE DATABASE IF NOT EXISTS AULA_05_14_03_2022;

/* 2) Conecta ao banco Auto_Pecas */
USE AULA_05_14_03_2022;

/* 3) Criacao da tabela TB_PECA */
CREATE TABLE IF NOT EXISTS TB_PECA (
    COD_PECA CHAR(10),
    NOME_PECA VARCHAR(50) NOT NULL,
    COR_PECA VARCHAR(50) NOT NULL,
    PESO_PECA INT NOT NULL,
    CIDADE_PECA VARCHAR(50) NOT NULL
);

/* 4) Criacao da tabela TB_EMBARQ */
CREATE TABLE IF NOT EXISTS TB_EMBARQ  (
    COD_PECA CHAR(10),
    COD_FORNEC CHAR(10),
    QTDE_EMBARC INT NOT NULL
);

/* 5) Criacao da tabela TB_FORNEC */
CREATE TABLE IF NOT EXISTS TB_FORNEC (
    COD_FORNEC CHAR(10) NOT NULL,
    NOME_FORNEC VARCHAR(50) NOT NULL,
    STATUS_FORNEC INT NOT NULL,
    CIDADE_FORNEC VARCHAR(50) NOT NULL
);

/* 6) Adicionar PK e FK nas tabelas */
ALTER TABLE TB_PECA
ADD CONSTRAINT PK_TB_PECA PRIMARY KEY (COD_PECA);

ALTER TABLE TB_FORNEC
ADD CONSTRAINT PK_TB_FORNEC PRIMARY KEY (COD_FORNEC);

ALTER TABLE TB_EMBARQ
ADD CONSTRAINT FK_TB_EMBARQ_TB_PECA
FOREIGN KEY (COD_PECA) REFERENCES TB_PECA(COD_PECA)
ON DELETE RESTRICT;

ALTER TABLE TB_EMBARQ
ADD CONSTRAINT FK_TB_EMBARQ_TB_FORNEC
FOREIGN KEY (COD_FORNEC) REFERENCES TB_FORNEC(COD_FORNEC)
ON DELETE RESTRICT;

/* 7) Inserir Dados Tabela TB_PECA */
INSERT INTO TB_PECA(COD_PECA, NOME_PECA, COR_PECA, PESO_PECA, CIDADE_PECA) VALUES 
    ('P1', 'Eixo', 'Cinza', 10, 'Poa'),
    ('P2', 'Rolamento', 'Preto', 16, 'Rio'),
    ('P3', 'Mancal', 'Verde', 30, 'São Paulo');

/* 8) Inserir Dados Tabela TB_FORNEC */
INSERT INTO TB_FORNEC(COD_FORNEC, NOME_FORNEC, STATUS_FORNEC, CIDADE_FORNEC) VALUES 
    ('F1', 'Silva', 5, 'São Paulo'),
    ('F2', 'Souza', 10, 'Rio'),
    ('F3', 'Alvares', 5, 'São Paulo'),
    ('F4', 'Tavares', 8, 'Rio');

/* 9) Inserir Dados Tabela TB_EMBARQ */
INSERT INTO TB_EMBARQ(COD_PECA, COD_FORNEC, QTDE_EMBARC) VALUES
    ('P1', 'F1', 300),
    ('P1', 'F2', 400),
    ('P1', 'F3', 200),
    ('P2', 'F1', 300),
    ('P2', 'F4', 350);

/* Exercicios sobre Funcoes Agregadas e Clausulas Group By e Having */
/* 1) Obter o número de fornecedores na base de dados */
SELECT 
	COUNT(COD_FORNEC) AS NUM_FORNEC
FROM 
	TB_FORNEC;

/* 2) Obter o número de cidades em que há fornecedores */
SELECT 
	COUNT(DISTINCT CIDADE_FORNEC) AS NUM_CIDADE
FROM 
	TB_FORNEC;

/* 3) Obter o número de fornecedores com cidade informada */
SELECT 
	COUNT(COD_FORNEC) AS NUM_FORNEC
FROM 
	TB_FORNEC 
WHERE 
	CIDADE_FORNEC IS NOT NULL;

/* 4) Obter a quantidade máxima embarcada */
SELECT 
	MAX(QTDE_EMBARC) AS QTDE_MAX_EMBARC
FROM
	TB_EMBARQ;

/* 5) Obter o número de embarques de cada fornecedor */
SELECT
	COD_FORNEC, COUNT(QTDE_EMBARC) AS NUM_EMBARC
FROM 
	TB_EMBARQ 
GROUP BY
	COD_FORNEC;

/* 6) Obter o número de embarques de quantidade maior que 300 de cada fornecedor */
SELECT
	NOME_FORNEC, COUNT(QTDE_EMBARC) AS NUM_EMBARC_MAIOR_300
FROM
	TB_FORNEC A
INNER JOIN 
	TB_EMBARQ B ON (A.COD_FORNEC = B.COD_FORNEC) 
WHERE 
	B.QTDE_EMBARC > 300 
GROUP BY 
	A.COD_FORNEC;

/* 7) Obter a quantidade total embarcada de peças de cor cinza para cada fornecedor */
SELECT 
	NOME_FORNEC, SUM(QTDE_EMBARC) AS QTDE_TOTAL_EMBARQ_CINZA
FROM
	TB_FORNEC A
INNER JOIN
	TB_EMBARQ B ON (A.COD_FORNEC = B.COD_FORNEC)
INNER JOIN
	TB_PECA C ON (B.COD_PECA = C.COD_PECA) 
WHERE 
	COR_PECA = 'Cinza' 
GROUP BY 
	A.COD_FORNEC;

/* 8) Obter o quantidade total embarcada de peças para cada fornecedor. Exibir o resultado por ordem descendente de quantidade total embarcada. */
SELECT
	NOME_FORNEC, SUM(QTDE_EMBARC) AS QTDE_TOTAL_EMBARQ_PECAS
FROM 
	TB_FORNEC A 
INNER JOIN 
	TB_EMBARQ B ON (A.COD_FORNEC = B.COD_FORNEC)
INNER JOIN
	TB_PECA C ON (B.COD_PECA = C.COD_PECA) 
GROUP BY 
	A.COD_FORNEC
ORDER BY 
	SUM(QTDE_EMBARC) 
DESC;

/* 9) Obter os códigos de fornecedores que tenham embarques de mais de 500 unidades de peças cinzas, junto com a quantidade de embarques de peças cinzas */
SELECT
	A.COD_FORNEC, SUM(QTDE_EMBARC) AS QTDE_EMBARC_MAIOR_500_CINZA
FROM 
	TB_FORNEC A 
INNER JOIN 
	TB_EMBARQ B ON (A.COD_FORNEC = B.COD_FORNEC)
INNER JOIN
	TB_PECA C ON (B.COD_PECA = C.COD_PECA)
WHERE 
	COR_PECA = 'Cinza'
GROUP BY 
	A.COD_FORNEC
HAVING 
	SUM(QTDE_EMBARC) > 500;