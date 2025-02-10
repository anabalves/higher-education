/* Conecta ao banco DB_UNIVERSIDADE */
USE AULA_08_04_04_2022;

/* Primeira Lista de Queries */
/* Baseado no modelo final de dados criado em aula anterior. 
Resolver as seguintes questões usando SQL: */

/* 1. Obter os códigos dos diferentes departamentos que tem turmas no ano-semestre
2002/1 */
SELECT DISTINCT 
	COD_DEPTO 
FROM 
	TB_TURMA 
WHERE 
	ANO_SEM = 20021;

/* 2. Obter os códigos dos professores que são do departamento de código 'INF01' e
que ministraram ao menos uma turma em 2002/1. */
SELECT DISTINCT 
	A.COD_PROF 
FROM 
	TB_PROFESSOR A, 
    TB_PROF_TURMA B 
WHERE 
	A.COD_PROF = B.COD_PROF
AND 
	A.COD_DEPTO = 'INF01' 
AND 
	ANO_SEM = 20021;

/* 3. Obter os horários de aula (dia da semana,hora inicial e número de horas
ministradas) do professor "Antunes" em 20021. */
SELECT DISTINCT
	C.DIA_SEM,
	C.HORA_INICIO,
	C.NUM_HORAS
FROM 
	TB_PROFESSOR A,
	TB_PROF_TURMA B,
	TB_HORARIO C
WHERE 
	A.NOME_PROF = 'Antunes'
AND 
	C.ANO_SEM = 20021
AND 
	A.COD_PROF = B.COD_PROF
AND 
	B.ANO_SEM = C.ANO_SEM
AND 
	B.COD_DEPTO = C.COD_DEPTO
AND 
	B.NUM_DISC = C.NUM_DISC
AND 
	B.SIGLA_TUR = C.SIGLA_TUR;

/* 4. Obter os nomes dos departamentos que têm turmas que, em 2002/1, têm aulas na
sala 101 do prédio denominado 'Informática - aulas'. */
SELECT DISTINCT 
	NOME_DEPTO
FROM
	TB_DEPTO A,
	TB_HORARIO B,
	TB_PREDIO C
WHERE 
	A.COD_DEPTO = B.COD_DEPTO
AND 
	B.COD_PRED = C.COD_PRED
AND 
	NUM_SALA = 101
AND 
	NOME_PRED = 'Informática-Aulas'
AND 
	ANO_SEM = 20021;

/* 5. Obter os códigos dos professores com título denominado 'Doutor' que não
ministraram aulas em 2002/1. */
SELECT DISTINCT 
	COD_PROF 
FROM 
	TB_PROFESSOR 
WHERE 
	COD_TIT
IN (SELECT 
		COD_TIT 
	FROM 
		TB_TITULACAO 
	WHERE 
		NOME_TIT = 'Doutor')
	AND 
		COD_PROF 
	NOT IN (SELECT 
				COD_PROF 
			FROM 
				TB_PROF_TURMA 
			WHERE 
				ANO_SEM = 20021);

/* 6. Obter os identificadores das salas (código do prédio e número da sala) que, em
2002/1: nas segundas-feiras (dia da semana = 2), tiveram ao menos uma turma do
departamento 'Informática', *e* nas quartas-feiras (dia da semana = 4), tiveram ao menos uma turma
ministrada pelo professor denominado 'Antunes'. 
*/
SELECT DISTINCT
	COD_PRED, NUM_SALA
FROM 
	TB_HORARIO A,
    TB_DEPTO B
WHERE 
	A.COD_DEPTO = B.COD_DEPTO
AND 
	NOME_DEPTO = 'Informática'
AND 
	DIA_SEM = 2 
AND 
	ANO_SEM = 20021
AND EXISTS
	(SELECT DISTINCT 
		COD_PRED, NUM_SALA
	FROM 
		TB_HORARIO C,
		TB_PROF_TURMA D,
		TB_PROFESSOR E
	WHERE 
		E.COD_PROF = D.COD_PROF
	AND 
		D.ANO_SEM = C.ANO_SEM
	AND 
		D.COD_DEPTO = C.COD_DEPTO
	AND 
		D.NUM_DISC = C.NUM_DISC
	AND 
		D.SIGLA_TUR = C.SIGLA_TUR
	AND
		A.COD_PRED = C.COD_PRED
	AND
		A.NUM_SALA = C.NUM_SALA
	AND 
		NOME_PROF = 'Antunes' 
	AND 
		DIA_SEM = 4);