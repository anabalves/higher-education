/* Conecta ao banco LISTA_DE_EXERCICIOS */
USE LISTA_DE_EXERCICIOS;

/* 1) Obter todos os dados dos professores.  */
SELECT 
	COD_PROF, 
	COD_DEPTO, 
    COD_TIT, 
    NOME_PROF
FROM
	TB_PROFESSOR;

/* 2) Obter o código e o nome dos professores. */
SELECT 
	COD_PROF, 
    NOME_PROF
FROM
	TB_PROFESSOR;
    
/* 3) Obter a capacidade das turmas. NAO SEI SE INTERPRETEI DIREITO */
SELECT
	SIGLA_TUR,
	CAPAC_TUR
FROM 
	TB_TURMA;
    
/* 4) Obter os diferentes valores de capacidades de turmas. NAO SEI SE INTERPRETEI DIREITO */
SELECT DISTINCT
	SIGLA_TUR,
	CAPAC_TUR
FROM 
	TB_TURMA;
    
/* SELECT distinct 
	A.SiglaTur, 
    B.SiglaTur, 
    A.NumDisc, 
    B.NumDisc, 
    (A.CapacTur - B.CapacTur) as Diferença 
FROM 
	TURMA as A, 
    turma as B 
where
	A.SiglaTur != B.SiglaTur; */

/* 5) Obter o nome das disciplinas do depto INF01, desde que tenham mais de 5 créditos. */
SELECT DISTINCT 
	NOME_DISC 
FROM 
	TB_DISCIPLINA 
WHERE 
	COD_DEPTO = 'INF01' 
AND 
	CREDITO_DISC > 5;

/* 6) Obter o código do prédio chamado Laboratórios. */
SELECT 
	COD_PRED 
FROM 
	TB_PREDIO 
WHERE 
	NOME_PRED = 'Laboratórios';

/* 7) Obter o número da sala e o código do prédio, desde que a sala tenha capacidade superior a 35 lugares. */
SELECT 
	NUM_SALA,
    COD_PRED
FROM 
	TB_SALA 
WHERE 
	CAPAC_SALA > 35;

/* 8) Obter o nome dos professores que têm titulação 1 e que trabalham no depto INF01. */
SELECT 
	NOME_PROF
FROM 
	TB_PROFESSOR 
WHERE 
	COD_TIT = 1
AND    
	COD_DEPTO = 'INF01';

/* 9) Obter o nome dos professores que têm titulação 2 ou que trabalham no depto INF01. */
SELECT 
	NOME_PROF
FROM 
	TB_PROFESSOR 
WHERE 
	COD_TIT = 2
AND    
	COD_DEPTO = 'INF01';

/* 10) Retorne o código e o nome dos professores que possuem Santos no final. */
SELECT
	COD_PROF,
    NOME_PROF
FROM 
	TB_PROFESSOR
WHERE 
	 NOME_PROF LIKE '% Santos%';

/* 11) Sabendo que cada crédito de disciplina corresponde às 15h aula, retorne o nome da disciplina e o seu número de horas-aula. */
SELECT
	NOME_DISC,
    (CREDITO_DISC * 15) NUM_HORAS_AULA
FROM 
	TB_DISCIPLINA;

/* 12) Obtenha os nomes das disciplinas seguidas do nome de seu departamento. */
SELECT
	A.NOME_DISC,
    B.NOME_DEPTO
FROM 
	TB_DISCIPLINA A,
    TB_DEPTO B
WHERE
	A.COD_DEPTO = B.COD_DEPTO;

/* 13) Obtenha os nomes dos professores que possuem titulação de ‘Doutor’. */
SELECT 
	NOME_PROF 
FROM 
	TB_PROFESSOR A,
    TB_TITULACAO B
WHERE 
	A.COD_TIT = B.COD_TIT 
AND
	NOME_TIT = 'Doutor';

/* 14) Obtenha os nomes dos professores que ministraram aulas em 2002/2. */
SELECT 
	NOME_PROF
FROM
	TB_PROFESSOR A,
    TB_PROF_TURMA B
WHERE
	A.COD_PROF = B.COD_PROF
AND
	ANO_SEM = 20022;

/* 15) Obtenha os números das salas do prédio de nome ‘Laboratórios’ cuja capacidade seja maior que 30. */
SELECT 
	NUM_SALA
FROM 
	TB_SALA A,
	TB_PREDIO B 
WHERE
	A.COD_PRED = B.COD_PRED
AND
	NOME_PRED = 'Laboratórios'
AND
	CAPAC_SALA > 30;

/* 16) Obtenha os nomes das disciplinas que foram oferecidas em 2002/1. */
SELECT DISTINCT 
	NOME_DISC 
FROM 
	TB_DISCIPLINA A,
    TB_TURMA B
WHERE 
	A.NUM_DISC = B.NUM_DISC
AND 
	ANO_SEM = 20021;

/* 17) Obtenha os números das salas do prédio "Laboratórios". */
SELECT 
	NUM_SALA
FROM 
	TB_SALA A,
	TB_PREDIO B 
WHERE
	A.COD_PRED = B.COD_PRED
AND
	NOME_PRED = 'Laboratórios';

/* 18) Obtenha os nomes dos professores seguidos do nome de seu departamento. */
SELECT
	A.NOME_PROF,
    B.NOME_DEPTO
FROM
	TB_PROFESSOR A,
    TB_DEPTO B
WHERE
	A.COD_DEPTO = B.COD_DEPTO;

/* 19) Obtenha os códigos dos professores que não possuem turma em 1999/2. */
SELECT DISTINCT
	COD_PROF
FROM
	TB_PROF_TURMA
WHERE
	ANO_SEM NOT IN (19992);

/* 20) Nomes dos departamentos que possuem disciplinas que não apresentam pré-requisito. */
SELECT 
	NOME_DEPTO
FROM 
	TB_DEPTO
WHERE 
	COD_DEPTO 
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

/* 21) Obtenha os códigos dos professores que ministraram aulas em 1999/2 e 2002/2. */
SELECT DISTINCT
	COD_PROF
FROM
	TB_PROF_TURMA
WHERE
	ANO_SEM = 19992
AND 
	ANO_SEM = 20022;

/* 22) Obtenha os nomes dos departamentos em que há pelo menos uma disciplina com mais de cinco créditos. */
SELECT
	NOME_DEPTO
FROM 
	TB_DEPTO A,
    TB_DISCIPLINA B
WHERE
	A.COD_DEPTO = B.COD_DEPTO
AND 
	CREDITO_DISC > 5;

/* 23) Obter os códigos dos diferentes departamentos que tem turmas no ano-semestre 2002/1 */
SELECT DISTINCT 
	COD_DEPTO 
FROM 
	TB_TURMA 
WHERE 
	ANO_SEM = 20021;

/* 24) Obter os códigos dos professores que são do departamento de código 'INF01' e que ministraram ao menos uma turma em 20021. */
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

/* 25) Obter os horários de aula (dia da semana, horainicial e número de horas ministradas) do professor "Antunes" em 2002/1. */
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

/* 26) Obter os nomes dos departamentos que têm turmas que, em 2002/1, têm aulas na sala 101 do prédio denominado 'Informática-Aulas'. */
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

/* 27) Obter os códigos dos professores com título denominado 'Doutor' que não ministraram aulas em 2001/1. */
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
				ANO_SEM = 20191);

/* 28) Obter os identificadores das salas (código do prédio e número da sala) que, em 2002/1: nas segundas-feiras (dia da semana = 2), tiveram ao menos uma turma do departamento 'Informática' */
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
	ANO_SEM = 20021;
    
/* 29) Obter os identificadores das salas (código do prédio e número da sala) que, nas quartas-feiras (dia da semana = 4), tiveram ao menos uma turma ministrada pelo professor denominado 'Antunes' . */
SELECT DISTINCT 
	COD_PRED, NUM_SALA
FROM 
	TB_HORARIO A,
	TB_PROF_TURMA B,
	TB_PROFESSOR C
WHERE 
	B.COD_PROF = C.COD_PROF
AND 
	B.ANO_SEM = A.ANO_SEM
AND 
	B.COD_DEPTO = A.COD_DEPTO
AND 
	B.NUM_DISC = A.NUM_DISC
AND 
	B.SIGLA_TUR = A.SIGLA_TUR
AND 
	NOME_PROF = 'Antunes' 
AND 
	DIA_SEM = 4;

/* 30) Obter o dia da semana, a hora de início e o número de horas de cada horário de cada turma ministrada por um professor de nome 'Antunes', em 2002/1, na sala número 101 do prédio de código 43423. */
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

/* 31) Para cada disciplina que possui pré-requisito, obter o nome da disciplina seguido do nome da disciplina que é seu pré-requisito. */
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

/* 32) Obter os nomes das disciplinas que não são pré-requisito. */
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

/* 33) Obter os nomes docentes cuja titulação tem código diferente de 3. */
SELECT 
	NOME_PROF
FROM 
	TB_PROFESSOR 
WHERE 
	COD_TIT != 3;

/* 34) Obter os nomes dos departamentos que têm turmas que, em 2002/1, têm aulas na sala 101 do prédio denominado ' Informática-Aulas'. */
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

/* 35) Obter o nome de cada departamento seguido do nome de cada uma de suas disciplinas que possui mais que três créditos 
(caso o departamento não tenha disciplinas ou caso o departamento não tenha disciplinas com mais que três créditos,
 seu nome deve aparecer seguido de vazio). */
SELECT 
	A.NOME_DEPTO, 
    IFNULL(B.NOME_DISC, '') NOME_DISC
FROM
	TB_DEPTO A
LEFT JOIN
	TB_DISCIPLINA B ON (A.COD_DEPTO = B.COD_DEPTO AND B.CREDITO_DISC > 3);
            
 /* 36) Obter os nomes dos professores que são do departamento denominado 'Informática', sejam doutores, e que, em 2002/2, 
 ministraram alguma turma de disciplina do departamento 'Informática' que tenha mais que três créditos. */
SELECT
	B.NOME_PROF
FROM
	TB_PROF_TURMA A,
    TB_PROFESSOR B,
    TB_TITULACAO C,
    TB_DISCIPLINA D, 
    TB_DEPTO E
WHERE
	E.NOME_DEPTO = 'Informática'
AND
	B.COD_DEPTO = E.COD_DEPTO 
AND
    C.NOME_TIT = 'Doutor'
AND
    C.COD_TIT = B.COD_TIT 
AND	
    A.ANO_SEM = 20022 
AND
    A.COD_PROF = B.COD_PROF
HAVING
    COUNT(D.CREDITO_DISC) > 3;
 
 /* 37) Obter o número de disciplinas do departamento denominado Informática. */
SELECT
    COUNT(NUM_DISC) AS NUMERO_DISCIPLINAS_INFORMATICA
FROM
    TB_DISCIPLINA A,
    TB_DEPTO B
WHERE
	A.COD_DEPTO = B.COD_DEPTO
AND 
	NOME_DEPTO = 'Informática';
 
 /* 38) Obter os nomes das disciplinas do departamento denominado ‘Informática’ 
 que têm o maior número de créditos dentre as disciplinas deste departamento. */
SELECT
    NOME_DISC,
    CREDITO_DISC
FROM
	TB_DISCIPLINA A,
    TB_DEPTO B
WHERE 
	A.COD_DEPTO = B.COD_DEPTO
AND 
	NOME_DEPTO = 'Informática'
AND 
	CREDITO_DISC = (SELECT
						MAX(CREDITO_DISC)
					FROM
						TB_DISCIPLINA);
 
 /* 39) Para cada departamento, obter seu nome e o seu número de disciplinas. 
 Obter o resultado em ordem descendente de número de disciplinas */
SELECT 
	A.NOME_DEPTO, 
    (SELECT COUNT(B.NUM_DISC) FROM TB_DISCIPLINA B WHERE B.COD_DEPTO = A.COD_DEPTO) AS NUMERO_DE_DISCIPLINAS 
FROM 
	TB_DEPTO A 
ORDER BY 
	NUMERO_DE_DISCIPLINAS DESC;