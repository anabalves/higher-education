      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 06/11/2021
      * Purpose: Nosso programa de inclusão está funcionando, porém pode
      * ser melhorado, quando quero inserir mais de um produto, preciso
      * executar novamente, gostaria de poder inserir mais de um produto
      * por vez e também gostaria de ter uma validação dos dados antes
      * de inserir no arquivo para evitar problemas futuros.
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. ATIVIDADE_01.
      **************************************
      * MELHORIAS NO CADASTRO DE PRODUTOS  *
      **************************************
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT PRODUTOS ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\produtos.txt'
           ORGANIZATION IS INDEXED
           ACCESS IS RANDOM
           RECORD KEY IS COD-PRODUTO
           FILE STATUS IS WS-FS.
       DATA DIVISION.
       FILE SECTION.
       FD PRODUTOS.
       01 REG-PRODUTO.
          03 COD-PRODUTO           PIC 9(03).
          03 NOME-PRODUTO          PIC X(20).
          03 ESTOQUE-PRODUTO       PIC 9(09).
       WORKING-STORAGE SECTION.
       77 WS-FS      PIC 99.
       77 W-OPCAO    PIC X(01) VALUE SPACES.
      *-------------------[ DIVISAO DE PROCEDIMENTOS ]------------------
       PROCEDURE DIVISION.
       INC-OP0.
            SET WS-FS TO 0.
            OPEN I-O PRODUTOS
            IF WS-FS EQUAL 35 THEN
               OPEN OUTPUT PRODUTOS
               DISPLAY "* ARQUIVO PRODUTOS SENDO CRIADO *"
            END-IF.

            DISPLAY "---------- CADASTRO DE PRODUTOS ----------".
       INC-001.
            DISPLAY 'INFORME O CODIGO DO PRODUTO:'
            ACCEPT COD-PRODUTO
            IF COD-PRODUTO = ZEROS
               DISPLAY "CODIGO NAO PODE SER EM BRANCO"
               GO TO INC-001.

       INC-002.
            DISPLAY 'INFORME O NOME DO PRODUTO'
            ACCEPT NOME-PRODUTO
            IF NOME-PRODUTO = SPACES
               DISPLAY "NOME DO PRODUTO NAO PODE SER EM BRANCO"
               GO TO INC-002.

       INC-003.
            DISPLAY 'INFORME A QUANTIDADE EM ESTOQUE DO PRODUTO'
            ACCEPT ESTOQUE-PRODUTO
            IF ESTOQUE-PRODUTO = ZEROS
               DISPLAY "QUANTIDADE NAO PODE SER EM BRANCO"
               GO TO INC-003.

       INC-OPC.
            MOVE "S" TO W-OPCAO
            DISPLAY "DADOS OK (S/N) : ".
            ACCEPT W-OPCAO
            IF W-OPCAO = "N" OR "n"
               DISPLAY "* DADOS RECUSADOS PELO USUARIO *"
               GO TO INC-001.
            IF W-OPCAO NOT = "S" AND "s"
               DISPLAY "*** DIGITE APENAS S=SIM e N=NAO ***"
               GO TO INC-OPC.

       INC-WR1.
            WRITE REG-PRODUTO
            IF WS-FS = "00" OR "02"
               DISPLAY "*** DADOS GRAVADOS *** "
               GO TO MENU-001.
               IF WS-FS = "22"
               DISPLAY "*** PRODUTO JA EXISTE *** "
               GO TO INC-001
               ELSE
                   DISPLAY 'ERRO AO CRIAR O ARQUIVO'
                   DISPLAY 'FILE STATUS: ' WS-FS
               GO TO ROT-FIM.


      *
      *****************************************
      * ROTINA DE MENU *
      *****************************************
      *
       MENU-001.
            DISPLAY "NOVO REGISTRO? (S/N) : ".
            ACCEPT W-OPCAO
            IF W-OPCAO = "S" OR "s"
               GO TO INC-001.
            IF W-OPCAO = "N" OR "n"
               GO TO ROT-FIM.
            IF W-OPCAO NOT = "S" AND "s"
               DISPLAY "*** DIGITE APENAS S=SIM e N=NAO ***"
               GO TO MENU-001.

      **********************
      * ROTINA DE FIM      *
      **********************
           ROT-FIM.
                   CLOSE PRODUTOS
                   EXIT PROGRAM.
           ROT-FIMP.
                   EXIT PROGRAM.
           ROT-FIMS.
                   STOP RUN.
