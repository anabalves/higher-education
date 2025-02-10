/* UTILIZANDO O MODELO DE CURSO: */
/* Conecta ao banco CURSO */
USE AULA_04_07_03_2022;

/* A-  Exercícios de SELECT básico */                    
/* 1). Queremos selecionar todos os alunos cadastrados. */
SELECT 
	NOME_ALUNO 
FROM 
	TB_ALUNO;

/* 2). Queremos selecionar todos os nomes de disciplina, cujo a nota mínima seja maior que 5 ( cinco ). */
SELECT 
	NOME_DISCIPLINA 
FROM 
	TB_DISCIPLINA 
WHERE 
	NOTA_MINIMA_DISCIPLINA > 5.00;

/* 3). Queremos selecionar todas disciplinas que tenham nota mínima entre 3 (três) e 5 (cinco). */
SELECT 
	NOME_DISCIPLINA
FROM 
	TB_DISCIPLINA
WHERE 
	NOTA_MINIMA_DISCIPLINA 
BETWEEN 
	3.00 
AND 
	5.00;

/* B-  Exercícios de SELECT (Ordenando e agrupando dados) */
/* 1). Queremos selecionar todos os alunos em ordem alfabética de nome de aluno, e também o número da classe que estuda. */
SELECT 
	NOME_ALUNO, ID_CLASSE 
FROM 
	TB_ALUNO 
ORDER BY 
	NOME_ALUNO;

/* 2). Selecionaremos o item anterior, porém ordenado alfabeticamente pelo identificador do aluno de forma descendente  (ascendente é “default”). */
SELECT 
	COD_ALUNO, NOME_ALUNO, ID_CLASSE 
FROM 
	TB_ALUNO 
ORDER BY 
	CONVERT (COD_ALUNO, CHAR) 
DESC;

/* 3). Selecionaremos  todos os alunos que cursam as disciplinas de matemática E de português agrupados por aluno e disciplina. */
SELECT 
	A.COD_ALUNO, NOME_ALUNO
FROM 
	TB_ALUNO A 
INNER JOIN 
	TB_ALUNO_DISCIPLINA AD ON (A.COD_ALUNO = AD.COD_ALUNO)
INNER JOIN 
	TB_DISCIPLINA D ON (AD.ID_DISCIPLINA = D.ID_DISCIPLINA)
WHERE 
	D.ID_DISCIPLINA = 'MAT'
	AND 
		A.COD_ALUNO IN (
		SELECT 
			A.COD_ALUNO
		FROM 
			TB_ALUNO A
		INNER JOIN 
			TB_ALUNO_DISCIPLINA AD ON (A.COD_ALUNO = AD.COD_ALUNO)
		INNER JOIN 
			TB_DISCIPLINA D ON (AD.ID_DISCIPLINA = D.ID_DISCIPLINA)
		WHERE 
			D.ID_DISCIPLINA = 'POR'
);

/* C-  Exercícios de SELECT (Junção de Tabelas) */
/* 1). Queremos selecionar todos os nomes de alunos que cursam Português ou Matemática. */
SELECT
	A.COD_ALUNO, NOME_ALUNO, NOME_DISCIPLINA
FROM 
	TB_ALUNO A
INNER JOIN 
	TB_ALUNO_DISCIPLINA AD ON (A.COD_ALUNO=AD.COD_ALUNO)
INNER JOIN
	TB_DISCIPLINA D ON (D.ID_DISCIPLINA=AD.ID_DISCIPLINA)
WHERE 
	AD.ID_DISCIPLINA = 'MAT' OR AD.ID_DISCIPLINA = 'POR';

/* 2). Queremos selecionar todos os nomes de alunos cadastrados que cursam  a disciplina FÍSICA e seus respectivos endereços. */
SELECT 
	NOME_ALUNO, END_ALUNO
FROM 
	TB_ALUNO A
INNER JOIN 
	TB_ALUNO_DISCIPLINA B ON (A.COD_ALUNO = B.COD_ALUNO)
INNER JOIN 
	TB_DISCIPLINA C ON (B.ID_DISCIPLINA = C.ID_DISCIPLINA)
WHERE 
	C.NOME_DISCIPLINA = 'FISICA';

/* 3). Queremos selecionar todos os nomes de alunos cadastrados que cursam física e o andar que se encontra a classe dos mesmos. */
/* Preste atenção ao detalhe da concatenação de uma string 'andar' junto à coluna do número do andar (Apenas para estética do resultado). */
SELECT 
	A.NOME_ALUNO, A.ID_CLASSE, CONCAT(D.ID_ANDAR, 'º Andar') AS ANDAR
FROM 
	TB_ALUNO A
INNER JOIN 
	TB_ALUNO_DISCIPLINA B ON (A.COD_ALUNO = B.COD_ALUNO)
INNER JOIN 
	TB_DISCIPLINA C ON B.ID_DISCIPLINA = C.ID_DISCIPLINA
INNER JOIN 
	TB_CLASSE D ON (A.ID_CLASSE = D.ID_CLASSE)
WHERE 
	C.NOME_DISCIPLINA = 'FISICA';

/* D-  Exercícios de SELECT (OUTER JOIN) */
/* 1.  Selecionar todos os Professores com suas respectivas disciplinas e os demais Professores que não lecionam disciplina alguma. */
SELECT 
	A.NOME_PROFESSOR, B.NOME_DISCIPLINA 
FROM 
	TB_PROFESSOR A
LEFT JOIN 
	TB_DISCIPLINA B ON (A.ID_PROFESSOR = B.ID_PROFESSOR_DISCIPLINA);

/* E-  Exercícios de SELECT (USE Clausula IN e/ou SUBSelect). Não pode usar junção. */
/* 1.  Selecionar todos os nomes de professores que tenham ministrado disciplina para alunos que sejam do Estado do Piaui, cujo a classe tenha sido no terceiro andar.  */
INSERT INTO TB_ESTADO(SIGLA_ESTADO, NOME_ESTADO) VALUES ('PI', 'Piaui');
INSERT INTO TB_CLASSE(ID_CLASSE, ID_ANDAR) VALUES (4, 3); 
INSERT INTO TB_ALUNO(COD_ALUNO, NOME_ALUNO, END_ALUNO, SIGLA_ESTADO, ID_CLASSE) VALUES 
(10, 'CESAR PEREIRA', 'RUA CINCO', 'PI', '4'),
(11, 'FABIANA SILVA', 'RUA DEZ', 'PI', '1');
INSERT INTO TB_ALUNO_DISCIPLINA (COD_ALUNO, ID_DISCIPLINA, NOTA_ALUNO) VALUES
(10, 'MAT', 4),
(10, 'FIS', 3),
(11, 'POR', 2);

SELECT 
	A.NOME_PROFESSOR 
FROM 
	TB_PROFESSOR A
WHERE 
	A.ID_PROFESSOR IN (
	SELECT 
			D.ID_PROFESSOR_DISCIPLINA FROM TB_DISCIPLINA D
	WHERE 
		D.ID_DISCIPLINA IN (
		SELECT 
			AD.ID_DISCIPLINA 
		FROM 
			TB_ALUNO_DISCIPLINA AD
		WHERE 
			AD.COD_ALUNO IN (
			SELECT 
				B.COD_ALUNO 
			FROM 
				TB_ALUNO B
			WHERE 
				B.SIGLA_ESTADO IN (
				SELECT 
					E.SIGLA_ESTADO
				FROM 
					TB_ESTADO E
				WHERE 
					E.NOME_ESTADO = 'PIAUI'
				AND 
					B.ID_CLASSE IN (
					SELECT 
						C.ID_CLASSE 
					FROM 
						TB_CLASSE C
					WHERE 
						C.ID_ANDAR = 3)))));