      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 06/09/2021
      * Purpose: TRABALHANDO COM ARQUIVOS DE DADOS INDEXADOS - LISTAR
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX17.
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

       01 WS-PRODUTO.
          03 WS-COD-PRODUTO           PIC 9(03).
          03 WS-NOME-PRODUTO          PIC X(20).
          03 WS-ESTOQUE-PRODUTO       PIC 9(09).

       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            OPEN INPUT PRODUTOS
            DISPLAY '---------- LISTAGEM DE PRODUTOS -------------'
            SET WS-EOF         TO 0
            SET WS-FS          TO 0
            SET WS-CONTADOR    TO 0
            PERFORM UNTIL WS-EOF EQUAL 1
               READ PRODUTOS INTO WS-PRODUTO
                   AT END
                       MOVE 1 TO WS-EOF
                   NOT AT END
                       DISPLAY ' COD. PRODUTO: ' WS-COD-PRODUTO
                               ' NOME PRODUTO: ' WS-NOME-PRODUTO
                               ' QTDE EM ESTOQUE: ' WS-ESTOQUE-PRODUTO
                       ADD 1 TO WS-CONTADOR
               END-READ
            END-PERFORM
            DISPLAY 'TOTAL DE REGISTRO LOCALIZADOS: ' WS-CONTADOR
            CLOSE PRODUTOS
            STOP RUN.
       END PROGRAM PROGRAMA_EX17.
