/* Conecta ao banco LISTA_DE_EXERCICIOS_2 */
USE LISTA_DE_EXERCICIOS_2;

/* 1) Obter os nomes docentes cuja titulação tem código diferente de 3.  */
SELECT 
	NOME_PROF
FROM 
	TB_PROFESSOR 
WHERE 
	COD_TIT <> 3;

/* 2) Obter os nomes dos departamentos que têm turmas que, em 2002/1, têm aulas na
sala 101 do prédio denominado 'Informática - aulas'. Resolver usando theta-join
e junção natural. */
SELECT DISTINCT
	NOME_DEPTO 
FROM 
	TB_DEPTO
NATURAL JOIN 
	TB_HORARIO
NATURAL JOIN 
	TB_PREDIO
WHERE 
	NUM_SALA = 101 
AND 
	NOME_PRED = "Informática-Aulas" 
AND 
	ANO_SEM = 20021;
    
/* 3) Obter o nome de cada departamento seguido do nome de cada uma de suas
disciplinas que possui mais que três créditos (caso o departamento não tenha
disciplinas ou caso o departamento não tenha disciplinas com mais que três
créditos, seu nome deve aparecer seguido de vazio). A seguinte solução não está
correta (porquê?):  */
SELECT 
	NOME_DEPTO, 
    IF (CREDITO_DISC > 3, NOME_DISC, " ") NOME_DISC
FROM
	TB_DEPTO
NATURAL LEFT JOIN
	TB_DISCIPLINA;
    
/* 4) Obter o nome dos professores que possuem horários conflitantes (possuem
turmas que tenham a mesma hora inicial, no mesmo dia da semana e no mesmo
semestre).  */
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

/* 5) Para cada disciplina que possui pré-requisito, obter o nome da disciplina seguido
do nome da disciplina que é seu pré-requisito (usar junções explícitas - quando
possível usar junção natural).  */
SELECT 
	A.NOME_DISC, 
    B.NOME_DISC NOME_DISC_PRE_REQ
FROM 
	TB_DISCIPLINA A
NATURAL JOIN 
	TB_PRE_REQ C
LEFT JOIN
	TB_DISCIPLINA B
ON 
	(C.COD_DEPTO_PRE_REQ = B.COD_DEPTO
AND 
	C.NUM_DISC_PRE_REQ = B.NUM_DISC);
    
/* 6) Para cada disciplina, mesmo para aquelas que não possuem pré-requisito, obter o
nome da disciplina seguido do nome da disciplina que é seu pré-requisito (usar
junções explícitas - quando possível usar junção natural).  */
SELECT 
	A.NOME_DISC, 
    IFNULL(B.NOME_DISC, '') NOME_DISC_PRE_REQ
FROM 
	TB_DISCIPLINA A
NATURAL LEFT JOIN 
	TB_PRE_REQ C
LEFT JOIN
	TB_DISCIPLINA B
ON 
	(C.COD_DEPTO_PRE_REQ = B.COD_DEPTO
AND 
	C.NUM_DISC_PRE_REQ = B.NUM_DISC);
    
/* 7) Para cada disciplina que tem um pré-requisito que a sua vez também tem um
pré-requisito, obter o nome da disciplina seguido do nome do pré-requisito de
seu pré-requisito.  */


/* 8) Obter uma tabela que contém três colunas. Na primeira coluna aparece o nome
de cada disciplina que possui pré-requisito, na segunda coluna aparece o nome
de cada um de seus pré-requisitos e a terceira contém o nível de pré-requisito.
Nível 1 significa que trata-se de um pré-requisito imediato da disciplina, nível 2
significa que trata-se de um pré-requisito de um pré-requisito da disciplina, e 
assim por diante. Limitar a consulta para três níveis. (DICA USAR UNION ALL)  */

/* 9) Obter os códigos dos professores com código de título vazio que não
ministraram aulas em 2001/2 (resolver com junção natural). */
SELECT DISTINCT 
	COD_PROF 
FROM 
	TB_PROFESSOR 
NATURAL LEFT JOIN 
	TB_PRE_REQ C
WHERE 
	COD_TIT = ' '
    
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
				ANO_SEM = 20012);
                
/* 10) Obter o os nomes dos professores que são do departamento denominado
'Informática', sejam doutores, e que, em 20022, ministraram alguma turma de
disciplina do departamento 'Informática' que tenha mais que três créditos.
Resolver a questão da seguinte forma:
1. sem consultas aninhadas e sem sintaxe explícita para junções,
2. usando SQL, em estilo de cálculo relacional, com consultas aninhadas
(quando possível usar IN, caso contrário usar EXISTS). */
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
    
/* 11) Obter os nomes das disciplinas do departamento denominado 'Informática' que
não foram oferecidas no semestre 20021.
Resolver a questão da seguinte forma:
1. no estilo de álgebra relacional, isto é, sem consultas aninhadas
(subselects),
2. no estilo cálculo relacional, isto é, com consultas aninhadas (subselects). */
SELECT DISTINCT 
	A.NOME_DISC 
FROM 
	TB_DISCIPLINA A,
    TB_DEPTO B
WHERE 
	A.COD_DEPTO = B.COD_DEPTO
AND
	B.NOME_DEPTO = 'Informática'
AND 
	NUM_DISC 
NOT IN (SELECT 
			NUM_DISC 
		FROM 
			TB_TURMA 
		WHERE 
			ANO_SEM = 20021);


/* 12) Obter uma tabela com as seguintes colunas: código de departamento, nome do
departamento, número de disciplina, créditos da disciplina, sigla da turma e
capacidade da turma. A tabela deve conter cada departamento associado com
cada uma de suas disciplinas e, para cada disciplina as respectivas turmas no ano
semestre 20022. Caso um departamento não tenha disciplinas, as demais colunas
devem aparecer vazias. Caso uma disciplina não tenha turmas, as demais
colunas deve aparecer vazias.  */


/* 13) Obter uma tabela com duas colunas, contendo o nome de cada disciplina
seguido do nome de cada um de seus pré-requisitos. Disciplinas sem prérequisito
têm a segunda coluna vazia. */
SELECT 
	A.NOME_DISC, 
    IFNULL(B.NOME_DISC, '') NOME_DISC_PRE_REQ
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

/* 14) Obter os identificadores de todas turmas de disciplinas do departamento
denominado `Informática' que não têm aula na sala de número 102 do prédio de
código 43421. */
SELECT DISTINCT
	NUM_DISC, SIGLA_TUR
FROM 
	TB_HORARIO A,
    TB_DEPTO B
WHERE 
	A.COD_DEPTO = B.COD_DEPTO
AND
	B.NOME_DEPTO = 'Informática'
AND
	NUM_DISC
NOT IN (SELECT 
		NUM_DISC 
	FROM 
		TB_HORARIO 
	WHERE 
		NUM_SALA = 102
   AND 
		COD_PRED = 43421);

/* 15) Obter o número de disciplinas do departamento denominado `Informática'. */
SELECT
    COUNT(NUM_DISC) AS NUMERO_DISCIPLINAS_INFORMATICA
FROM
    TB_DISCIPLINA A,
    TB_DEPTO B
WHERE
	A.COD_DEPTO = B.COD_DEPTO
AND 
	NOME_DEPTO = 'Informática';

/* 16) Obter o número de salas que foram usadas no ano-semestre 20021 por turmas do
departamento denominado `Informática'. */
SELECT DISTINCT
	NUM_SALA
FROM 
	TB_HORARIO A,
    TB_DEPTO B
WHERE 
	A.COD_DEPTO = B.COD_DEPTO
AND 
	NOME_DEPTO = 'Informática'
AND 
	ANO_SEM = 20021;

/* 17) Obter os nomes das disciplinas do departamento denominado `Informática' que
têm o maior número de créditos dentre as disciplinas deste departamento. */
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

/* 18) Para cada departamento, obter seu nome e o número de disciplinas do
departamento. Obter o resultado em ordem descendente de número de
disciplinas. */
SELECT 
	A.NOME_DEPTO, 
    (SELECT COUNT(B.NUM_DISC) FROM TB_DISCIPLINA B WHERE B.COD_DEPTO = A.COD_DEPTO) AS NUMERO_DE_DISCIPLINAS 
FROM 
	TB_DEPTO A 
ORDER BY 
	NUMERO_DE_DISCIPLINAS DESC;

/* 19) Para cada departamento, obter seu nome e os créditos totais oferecidos no anosemestre
20022. O número de créditos oferecidos é calculado através do produto
de número de créditos da disciplina pelo número de turmas oferecidas no
semestre. */


/* 20) Resolver a consulta da questão anterior, mas incluindo somente os
departamentos que têm mais que 5 disciplinas. */


/* 21) Obter os nomes dos departamentos que possuem a maior soma de créditos. */
SELECT
	A.NOME_DEPTO,
    SUM(B.CREDITO_DISC) SOMA_CREDITOS
FROM
	TB_DEPTO A,
	TB_DISCIPLINA B
WHERE 
	A.COD_DEPTO = B.COD_DEPTO
GROUP BY
    A.NOME_DEPTO
ORDER BY 
	 SOMA_CREDITOS DESC LIMIT 1;

/* 22) Obter os nomes das disciplinas que em 20022, têm pelo menos uma turma cuja
total de horas seja diferente do número de créditos da disciplina.
Resolver a questão da seguinte forma:
1. sem usar GROUP BY, com consultas aninhadas (subselects),
2. usando GROUP BY, sem consultas aninhadas. */
SELECT DISTINCT
    NOME_DISC
FROM
	TB_DISCIPLINA A,
    TB_HORARIO B
WHERE 
	A.NUM_DISC = B.NUM_DISC
AND 
	B.ANO_SEM = 20022 
AND 
	A.CREDITO_DISC <> B.NUM_HORAS
HAVING
    COUNT(B.SIGLA_TUR) >= 1;
    
/* 23) Obter os nomes dos professores que, em 20022, deram aula em mais de uma
turma.
Resolver a questão da seguinte forma:
1. sem funções de agregação (tipo COUNT, MIN,MAX,AVG,SUM),
2. ou ainda, com funções de agregação. */
INSERT INTO TB_PROF_TURMA(ANO_SEM, COD_DEPTO, NUM_DISC, SIGLA_TUR, COD_PROF) VALUES (20022, 'INF01', 3, 'T2', 1);
SELECT DISTINCT
	A.NOME_PROF
FROM
    TB_PROFESSOR A,
    TB_PROF_TURMA T1
JOIN 
	TB_PROF_TURMA T2 ON T1.COD_PROF = T2.COD_PROF AND T1.NUM_DISC <> T2.NUM_DISC
JOIN 
	TB_PROF_TURMA T3 ON T1.COD_PROF = T3.COD_PROF AND T1.NUM_DISC <> T3.NUM_DISC AND T2.NUM_DISC <> T3.NUM_DISC
WHERE
    T1.ANO_SEM = 20022 
AND
    A.COD_PROF = T1.COD_PROF;
