/* Considerando a Lista de Exercícios da Aula de Funções Agregadas, criar a seguinte Stored Procedure: */
USE AULA_06_21_03_2022;

DROP PROCEDURE IF EXISTS INSERIR_REGISTRO_TB_PECA;
DROP PROCEDURE IF EXISTS INSERIR_X_REGISTROS_ALEATORIOS_TB_PECA;

/* 1- Procedure para Inserir um registro na Tabela Peça, usando parâmetros; */
DELIMITER //
CREATE PROCEDURE INSERIR_REGISTRO_TB_PECA (IN PROC_COD_PECA CHAR(10), IN PROC_NOME_PECA VARCHAR(50), IN PROC_COR_PECA VARCHAR(50), IN PROC_PESO_PECA INT, IN PROC_CIDADE_PECA VARCHAR(50))
BEGIN
	INSERT INTO TB_PECA(COD_PECA, NOME_PECA, COR_PECA, PESO_PECA, CIDADE_PECA) VALUES (PROC_COD_PECA, PROC_NOME_PECA, PROC_COR_PECA, PROC_PESO_PECA, PROC_CIDADE_PECA);
END //
DELIMITER ;

CALL INSERIR_REGISTRO_TB_PECA('P4', 'Amortecedor', 'Prata', 3, 'Porto Alegre');

SELECT COD_PECA, NOME_PECA, COR_PECA, PESO_PECA, CIDADE_PECA FROM TB_PECA;

/* 2- Procedure para Inserir 5000 registros distintos na Tabela Peça; */
DELIMITER //
CREATE PROCEDURE INSERIR_X_REGISTROS_ALEATORIOS_TB_PECA (IN QUANT_REGISTROS INT)
BEGIN
	
    DECLARE PROC_AUXILIAR INT;
    DECLARE PROC_COD_PECA_ALEATORIO CHAR(10);
    DECLARE PROC_NOME_PECA_ALEATORIO VARCHAR(50);
    DECLARE PROC_COR_PECA_ALEATORIO VARCHAR(50);
    DECLARE PROC_PESO_PECA_ALEATORIO INT;
    DECLARE PROC_CIDADE_PECA_ALEATORIO VARCHAR(50);

    SET PROC_AUXILIAR = 5;
    
    CREATE TEMPORARY TABLE IF NOT EXISTS TB_PECAS_ALEATORIAS(NOME_PECA VARCHAR(50));
    INSERT INTO TB_PECAS_ALEATORIAS(NOME_PECA) VALUES ('Amortecedor da direção'), ('Amortecedor dianteiro'), ('Braço axial'), ('Plato / Disco'), ('Rolamento embreagem'), ('Eixos Homocineticos'), ('Juntas deslizantes'), ('Eixo traseiro'), ('Bieleta estabilizador'), ('Bandeja');
    
    CREATE TEMPORARY TABLE IF NOT EXISTS TB_CORES_ALEATORIAS(NOME_COR VARCHAR(50));
    INSERT INTO TB_CORES_ALEATORIAS(NOME_COR) VALUES ('Abóbora'), ('Açafrão'), ('Amarelo'), ('Ameixa'), ('Amêndoa'), ('Ametista'), ('Anil'), ('Azul'), ('Bege'), ('Bordô'), ('Branco'), ('Bronze'), ('Cáqui'), ('Caramelo'), ('Carmesim'), ('Carmim'), ('Ocre'), ('Castanho'), ('Cereja'), ('Chocolate'), ('Ciano'), ('Cinza'), ('Cinzento'), ('Cobre'), ('Coral'), ('Creme'), ('Damasco'), ('Dourado'), ('Escarlate'), ('Esmeralda'), ('Ferrugem'), ('Fúcsia'), ('Gelo'), ('Grená'), ('Gris'), ('Índigo'), ('Jade'), ('Jambo'), ('Laranja'), ('Lavanda'), ('Lilás'), ('Limão'), ('Loiro'), ('Magenta'), ('Malva'), ('Marfim'), ('Marrom'), ('Mostarda'), ('Ocre'), ('Ouro'), ('Oliva'), ('Pêssego'), ('Prata'), ('Preto'), ('Púrpura'), ('Rosa'), ('Roxo'), ('Rubro'), ('Salmão'), ('Sépia'), ('Terracota'), ('Tijolo'), ('Turquesa'), ('Uva'), ('Verde'), ('Vermelho'), ('Vinho'), ('Violeta');
    
    CREATE TEMPORARY TABLE IF NOT EXISTS TB_CIDADES_ALEATORIAS(NOME_CIDADE VARCHAR(50));
    INSERT INTO TB_CIDADES_ALEATORIAS(NOME_CIDADE) VALUES ('Brasília'), ('São Paulo'), ('Rio de Janeiro'), ('Salvador'), ('Belo Horizonte'), ('Fortaleza'), ('Curitiba'), ('Manaus'), ('Recife'), ('Porto Alegre');
    
    LOOP_INSERIR_REGISTROS: LOOP
    
		IF PROC_AUXILIAR = QUANT_REGISTROS THEN 
			LEAVE LOOP_INSERIR_REGISTROS;
        END IF;
        
        SET PROC_COD_PECA_ALEATORIO = CONCAT('P', PROC_AUXILIAR + 1);
		SET PROC_NOME_PECA_ALEATORIO = (SELECT NOME_PECA FROM TB_PECAS_ALEATORIAS ORDER BY RAND() LIMIT 1);
        SET PROC_COR_PECA_ALEATORIO = (SELECT NOME_COR FROM TB_CORES_ALEATORIAS ORDER BY RAND() LIMIT 1);
        SET PROC_PESO_PECA_ALEATORIO = FLOOR(RAND() * (100 - 1 + 1) + 1);
        SET PROC_CIDADE_PECA_ALEATORIO = (SELECT NOME_CIDADE FROM TB_CIDADES_ALEATORIAS ORDER BY RAND() LIMIT 1);
        
        CALL INSERIR_REGISTRO_TB_PECA(PROC_COD_PECA_ALEATORIO, PROC_NOME_PECA_ALEATORIO, PROC_COR_PECA_ALEATORIO, PROC_PESO_PECA_ALEATORIO, PROC_CIDADE_PECA_ALEATORIO);
        
        SET PROC_AUXILIAR = PROC_AUXILIAR + 1;
        
	END LOOP;
END //
DELIMITER ;

CALL INSERIR_X_REGISTROS_ALEATORIOS_TB_PECA(5000);

SELECT COD_PECA, NOME_PECA, COR_PECA, PESO_PECA, CIDADE_PECA FROM TB_PECA;