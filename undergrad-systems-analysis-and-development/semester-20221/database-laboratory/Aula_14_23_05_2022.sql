/* 
Atividade - Natural Join - Theta Join
*/
USE AULA_14_23_05_2022;

/* 
1- Obter os nomes dos departamentos que têm turmas que, em 2002/1, 
têm aulas na sala 101 do prédio denominado 'Informática - aulas'. 
Resolver usando theta-join e junção natural.
*/
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
/*
2.  Obter o nome de cada departamento seguido do nome de cada 
uma de suas disciplinas que possui mais que três créditos 
(caso o departamento não tenha disciplinas ou caso o departamento 
não tenha disciplinas com mais que três créditos, seu nome deve 
aparecer seguido de vazio). A seguinte solução não está correta (por quê?). Qual a forma correta?:
select distinct 
	NOME_DEPTO
from
  TB_DEPTO
natural join
  TB_DISCIPLINA
where
  CREDITO_DISC > 3
*/
SELECT 
	NOME_DEPTO, 
    IF (CREDITO_DISC > 3, NOME_DISC, " ") NOME_DISC
FROM
	TB_DEPTO
NATURAL LEFT JOIN
	TB_DISCIPLINA;
    
/* O enunciado pede o nome do deparmento seguido do nome da disciplina, alem de faltar a coluna nome_disc
faltou realizar a condicional com a coluna credito_disc, assim caso caso o departamento não tenha disciplinas ou caso o departamento 
não tenha disciplinas com mais que três créditos sera exibido o nome do departamento seguido de vazio, como solicitado   
/*

3-  Para cada disciplina que possui pré-requisito, 
obter o nome da disciplina seguido do nome da disciplina que é seu pré-requisito 
(usar junções explícitas - quando possível usar junção natural). 
Resolver também usando Theta Join.
*/
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