/* Baseado no modelo final de dados criado em aula anterior. Resolver as seguintes questões usando SQL: */
/* Conecta ao banco DB_UNIVERSIDADE */
USE AULA_09_11_04_2022;

/* 1. Obter o dia da semana, a hora de início e o número de horas de cada horário de cada turma ministrada 
por um professor de nome `Antunes', em 2002/1, na sala número 101 do prédio de código 43423. */
SELECT 
	A.NOME_PROF, C.NUM_SALA, C.DIA_SEM, C.HORA_INICIO, C.NUM_HORAS 
FROM 
	TB_PROFESSOR A,
	TB_PROF_TURMA B,
	TB_HORARIO C
WHERE 
	A.COD_PROF = B.COD_PROF
AND 
	B.ANO_SEM = C.ANO_SEM
AND 
	B.COD_DEPTO = C.COD_DEPTO
AND 
	B.NUM_DISC = C.NUM_DISC
AND 
	B.SIGLA_TUR = C.SIGLA_TUR
AND 
	NUM_SALA = 101
AND 
	B.ANO_SEM = 20021
AND 
	NOME_PROF = 'Antunes'
AND 
	COD_PRED = 43423;

/* 2. Um professor pode ministrar turmas de disciplinas pertencentes a outros departamentos. 
Para cada professor que já ministrou aulas em disciplinas de outros departamentos, 
obter o código do professor, seu nome, o nome de seu departamento e o nome do 
departamento no qual ministrou disciplina. */
SELECT 
	A.COD_PROF,
	A.NOME_PROF,
	C.NOME_DEPTO DEPTO_PROF,
	D.NOME_DEPTO DEPTO_DISC
FROM 
	TB_PROFESSOR A,
	TB_PROF_TURMA B,
	TB_DEPTO C,
	TB_DEPTO D
WHERE 
	A.COD_PROF = B.COD_PROF
AND 
	A.COD_DEPTO != B.COD_DEPTO
AND 
	A.COD_DEPTO = C.COD_DEPTO
AND 
	B.COD_DEPTO = D.COD_DEPTO;

/* 3. Obter o nome dos professores que possuem horários conflitantes (possuem turmas que 
tenham a mesma hora inicial, no mesmo dia da semana e no mesmo semestre). 
Além dos nomes, mostrar as chaves primárias das turmas em conflito. */
SELECT DISTINCT 
	E.NOME_PROF, 
    A.SIGLA_TUR, 
    A.ANO_SEM, 
    A.DIA_SEM, 
    A.HORA_INICIO 
FROM 
	TB_HORARIO A,
	TB_HORARIO B,
    TB_PROF_TURMA C,
	TB_PROF_TURMA D,
	TB_PROFESSOR E
WHERE 
	A.ANO_SEM = B.ANO_SEM 
AND 
	A.DIA_SEM = B.DIA_SEM 
AND 
	A.HORA_INICIO = B.HORA_INICIO
AND 
	(A.COD_DEPTO <> B.COD_DEPTO OR A.NUM_DISC <> B.NUM_DISC OR A.SIGLA_TUR <> B.SIGLA_TUR)
AND 
	A.COD_DEPTO = C.COD_DEPTO 
AND 
	A.NUM_DISC = C.NUM_DISC 
AND 
	A.ANO_SEM = C.ANO_SEM 
AND 
	A.SIGLA_TUR = C.SIGLA_TUR
AND 
	B.COD_DEPTO = D.COD_DEPTO 
AND 
	B.NUM_DISC = D.NUM_DISC 
AND 
	B.ANO_SEM = D.ANO_SEM 
AND 
	B.SIGLA_TUR = D.SIGLA_TUR
AND 
	C.COD_PROF = D.COD_PROF 
AND 
	E.COD_PROF = C.COD_PROF;

/* 4. Para cada disciplina que possui pré-requisito, obter o nome da 
disciplina seguido do nome da disciplina que é seu pré-requisito. */
SELECT 
	A.NOME_DISC, 
	B.NOME_DISC NOME_DISC_PRE_REQ
FROM 
	TB_DISCIPLINA A,
    TB_DISCIPLINA B,
	TB_PRE_REQ C
WHERE 
	A.COD_DEPTO = C.COD_DEPTO
AND 
	A.NUM_DISC = C.NUM_DISC
AND 
	C.COD_DEPTO_PRE_REQ = B.COD_DEPTO
AND 
	C.NUM_DISC_PRE_REQ = B.NUM_DISC;

/* 5. Obter os nomes das disciplinas que não têm pré-requisito. */
SELECT 
	NOME_DISC
FROM 
	TB_DISCIPLINA
WHERE 
	NOME_DISC 
NOT IN
	(SELECT 
		NOME_DISC
	FROM 
		TB_PRE_REQ,
		TB_DISCIPLINA
	WHERE 
		TB_DISCIPLINA.COD_DEPTO = TB_PRE_REQ.COD_DEPTO
	AND 
		TB_DISCIPLINA.NUM_DISC = TB_PRE_REQ.NUM_DISC);

/* 6. Obter o nome de cada disciplina que possui ao menos dois pré-requisitos. */
SELECT DISTINCT 
	NOME_DISC
FROM 
	TB_DISCIPLINA A,
	TB_PRE_REQ B,
	TB_PRE_REQ C
WHERE 
	A.COD_DEPTO = B.COD_DEPTO
AND 
	A.NUM_DISC = B.NUM_DISC
AND 
	A.COD_DEPTO = C.COD_DEPTO
AND 
	A.NUM_DISC = C.NUM_DISC
AND 
	(B.COD_DEPTO_PRE_REQ != C.COD_DEPTO_PRE_REQ
OR 
	B.NUM_DISC_PRE_REQ != C.NUM_DISC_PRE_REQ);
