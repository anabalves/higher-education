      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 06/11/2021
      * Purpose: CRUD
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_009.
      **********************************
      * MELHORIAS NO CRUD DE PRODUTOS  *
      **********************************
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT PRODUTOS ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\produtos.txt'
           ORGANIZATION IS INDEXED
           ACCESS IS DYNAMIC
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
       77 WS-FS            PIC 99.
       77 WS-EOF           PIC 99.
       77 WS-CONTADOR      PIC 99.
       77 W-OPCAO          PIC 99.
       77 W-CONF           PIC X(01) VALUE SPACES.
       77 WS-ALTERAR       PIC X VALUES SPACE.
       77 WS-EXCLUIR       PIC X VALUES SPACE.

       01 WS-PRODUTO.
           03 WS-COD-PRODUTO           PIC 9(03).
           03 WS-NOME-PRODUTO          PIC X(20).
           03 WS-ESTOQUE-PRODUTO       PIC 9(09).

      *-------------------[ DIVISAO DE PROCEDIMENTOS ]------------------
       PROCEDURE DIVISION.
      *
      ******************
      * ROTINA DE MENU *
      ******************
      *
       MENU-001.
            DISPLAY '|---[ MENU ]---|'
            DISPLAY "| 1 - INCLUIR  |"
            DISPLAY "| 2 - ALTERAR  |"
            DISPLAY "| 3 - EXCLUIR  |"
            DISPLAY "| 4 - CONSULTA |"
            DISPLAY "| 5 - LISTAR   |"
            DISPLAY "| 99 - SAIR    |"
            DISPLAY '|--------------|'
            DISPLAY " "
            ACCEPT W-OPCAO
            IF W-OPCAO = 1
               GO TO INC-001.
            IF W-OPCAO = 2
               GO TO ALT-001.
            IF W-OPCAO = 3
               GO TO EXC-001.
            IF W-OPCAO = 4
               GO TO CON-001.
            IF W-OPCAO = 5
               GO TO LIS-001.
            IF W-OPCAO = 99
               GO TO ROT-FIM.
            IF W-OPCAO NOT = 1 AND 2 AND 3 AND 4 AND 5 AND 99
               DISPLAY "*** DIGITE APENAS 1, 2, 3, 4, 5 OU 99 ***"
               DISPLAY " "
               GO TO MENU-001.
      *
      **********************
      * ROTINA DE INCLUSAO *
      **********************
      *
       INC-001.
            SET WS-FS TO 0.
            OPEN I-O PRODUTOS
            IF WS-FS EQUAL 35 THEN
               OPEN OUTPUT PRODUTOS
               DISPLAY "* ARQUIVO PRODUTOS SENDO CRIADO *"
            END-IF.

            DISPLAY "---------- CADASTRO DE PRODUTOS ----------".
       INC-002.
            DISPLAY 'INFORME O CODIGO DO PRODUTO:'
            ACCEPT COD-PRODUTO
            IF COD-PRODUTO = ZEROS
               DISPLAY "CODIGO NAO PODE SER EM BRANCO"
               GO TO INC-002.

       INC-003.
            DISPLAY 'INFORME O NOME DO PRODUTO'
            ACCEPT NOME-PRODUTO
            IF NOME-PRODUTO = SPACES
               DISPLAY "NOME DO PRODUTO NAO PODE SER EM BRANCO"
               GO TO INC-003.

       INC-004.
            DISPLAY 'INFORME A QUANTIDADE EM ESTOQUE DO PRODUTO'
            ACCEPT ESTOQUE-PRODUTO
            IF ESTOQUE-PRODUTO = ZEROS
               DISPLAY "QUANTIDADE NAO PODE SER EM BRANCO"
               GO TO INC-004.

       INC-OPC.
            MOVE "S" TO W-CONF
            DISPLAY "DADOS OK (S/N) : ".
            ACCEPT W-CONF
            IF W-CONF = "N" OR "n"
               DISPLAY "* DADOS RECUSADOS PELO USUARIO *"
               GO TO INC-001.
            IF W-CONF NOT = "S" AND "s"
               DISPLAY "*** DIGITE APENAS S=SIM e N=NAO ***"
               GO TO INC-OPC.

       INC-WR1.
            WRITE REG-PRODUTO
            IF WS-FS = "00" OR "02"
               DISPLAY "*** DADOS GRAVADOS *** "
               CLOSE PRODUTOS
               GO TO MENU-001.
               IF WS-FS = "22"
               DISPLAY "*** PRODUTO JA EXISTE *** "
               GO TO INC-002
               ELSE
                   DISPLAY 'ERRO AO CRIAR O ARQUIVO'
                   DISPLAY 'FILE STATUS: ' WS-FS
               GO TO ROT-FIM.
      *
      ***********************
      * ROTINA DE ALTERAÇÃO *
      ***********************
      *
       ALT-001.
            OPEN I-O PRODUTOS.
            DISPLAY '---------- ALTERACAO DE PRODUTOS -------------'
            DISPLAY 'INFORME O CODIGO DO PRODUTO'
            ACCEPT COD-PRODUTO

            READ PRODUTOS RECORD INTO WS-PRODUTO
              KEY IS COD-PRODUTO
                   INVALID KEY
                       DISPLAY 'CODIGO DO PRODUTO INVALIDO'
                   NOT INVALID KEY
                       DISPLAY 'CODIGO DO PRODUTO: ' WS-COD-PRODUTO
                       DISPLAY 'NOME DO PRODUTO: ' WS-NOME-PRODUTO
                       DISPLAY 'QTDE EM ESTOQUE: ' WS-ESTOQUE-PRODUTO
                       MOVE 'S' TO WS-ALTERAR
            END-READ.

            IF WS-ALTERAR EQUAL 'S'
               DISPLAY 'INFORME O NOME DO PRODUTO'
               ACCEPT NOME-PRODUTO
               DISPLAY 'INFORME A QUANTIDADE EM ESTOQUE DO PRODUTO'
               ACCEPT ESTOQUE-PRODUTO

               REWRITE REG-PRODUTO
               END-REWRITE
            END-IF

            CLOSE PRODUTOS
            GO TO MENU-001.
      *
      **********************
      * ROTINA DE EXCLUSÃO *
      **********************
      *
       EXC-001.
            OPEN I-O PRODUTOS.
            DISPLAY '---------- EXCLUSAO DE PRODUTOS -------------'
            DISPLAY 'INFORME O CODIGO DO PRODUTO'
            ACCEPT COD-PRODUTO

            READ PRODUTOS RECORD INTO WS-PRODUTO
              KEY IS COD-PRODUTO
                   INVALID KEY
                       DISPLAY 'CODIGO DO PRODUTO INVALIDO'
                   NOT INVALID KEY
                       DISPLAY 'CODIGO DO PRODUTO: ' WS-COD-PRODUTO
                       DISPLAY 'NOME DO PRODUTO: ' WS-NOME-PRODUTO
                       DISPLAY 'QTDE EM ESTOQUE: ' WS-ESTOQUE-PRODUTO
                       MOVE 'S' TO WS-EXCLUIR
            END-READ.

            IF WS-EXCLUIR EQUAL 'S'
               DELETE PRODUTOS RECORD
                   INVALID KEY DISPLAY 'CODIGO DO PRODUTO INVALIDO'
                   NOT INVALID KEY DISPLAY 'REGISTRO DELETADO!'
               END-DELETE
            END-IF

            CLOSE PRODUTOS
            GO TO MENU-001.
      *
      **********************
      * ROTINA DE LISTAGEM *
      **********************
      *
       LIS-001.
            SET WS-EOF  TO 0
            SET WS-FS TO 0
            SET WS-CONTADOR TO 0
            OPEN INPUT PRODUTOS
            DISPLAY '---------- LISTAGEM DE PRODUTOS -------------'
            PERFORM UNTIL WS-EOF = 1
               READ PRODUTOS INTO WS-PRODUTO
                   AT END MOVE 1 TO WS-EOF NOT AT END
                       DISPLAY ' COD. PRODUTO: ' WS-COD-PRODUTO
                               ' NOME PRODUTO: ' WS-NOME-PRODUTO
                               ' QTDE EM ESTOQUE: ' WS-ESTOQUE-PRODUTO
                       ADD 1 TO WS-CONTADOR
               END-READ
            END-PERFORM
            DISPLAY 'TOTAL DE REGISTRO LOCALIZADOS: ' WS-CONTADOR
            DISPLAY " "
            CLOSE PRODUTOS
            GO TO MENU-001.
      *
      **********************
      * ROTINA DE CONSULTA *
      **********************
      *
       CON-001.
            OPEN I-O PRODUTOS.
            DISPLAY '---------- CONSULTA DE PRODUTOS -------------'
            DISPLAY 'INFORME O CODIGO DO PRODUTO'
            ACCEPT COD-PRODUTO

            READ PRODUTOS RECORD INTO WS-PRODUTO
              KEY IS COD-PRODUTO
                   INVALID KEY
                       DISPLAY 'CODIGO DO PRODUTO INVALIDO'
                       DISPLAY " "
                       GO TO CON-001
                   NOT INVALID KEY
                       DISPLAY 'CODIGO DO PRODUTO: ' WS-COD-PRODUTO
                       DISPLAY 'NOME DO PRODUTO: ' WS-NOME-PRODUTO
                       DISPLAY 'QTDE EM ESTOQUE: ' WS-ESTOQUE-PRODUTO
                       DISPLAY " "
            END-READ.
            CLOSE PRODUTOS
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
