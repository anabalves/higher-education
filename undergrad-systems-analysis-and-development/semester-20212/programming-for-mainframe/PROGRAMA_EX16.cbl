      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 06/09/2021
      * Purpose: TRABALHANDO COM ARQUIVOS DE DADOS INDEXADOS - EXCLUIR
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX16.
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
       77 WS-FS            PIC 99.
       77 WS-EXCLUI        PIC X VALUES SPACE.

       01 WS-PRODUTO.
          03 WS-COD-PRODUTO           PIC 9(03).
          03 WS-NOME-PRODUTO          PIC X(20).
          03 WS-ESTOQUE-PRODUTO       PIC 9(09).

       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
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
                       MOVE 'S' TO WS-EXCLUI
            END-READ.

            IF WS-EXCLUI EQUAL 'S'
               DELETE PRODUTOS RECORD
                   INVALID KEY DISPLAY 'CODIGO DO PRODUTO INVALIDO'
                   NOT INVALID KEY DISPLAY 'REGISTRO DELETADO!'
               END-DELETE
            END-IF

            CLOSE PRODUTOS

            STOP RUN.
       END PROGRAM PROGRAMA_EX16.
