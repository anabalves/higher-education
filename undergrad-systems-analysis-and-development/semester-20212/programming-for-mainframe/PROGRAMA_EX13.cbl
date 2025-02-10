      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 06/09/2021
      * Purpose: TRABALHANDO COM ARQUIVOS DE DADOS INDEXADOS - INCLUIR
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX13.
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
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            DISPLAY "---------- CADASTRO DE PRODUTOS ----------"
            SET WS-FS      TO 0.
            OPEN I-O PRODUTOS
            IF WS-FS EQUAL 35 THEN
                OPEN OUTPUT PRODUTOS
            END-IF
            IF WS-FS EQUAL ZEROS
                DISPLAY 'INFORME O CODIGO DO PRODUTO:'
                ACCEPT COD-PRODUTO
                DISPLAY 'INFORME O NOME DO PRODUTO'
                ACCEPT NOME-PRODUTO
                DISPLAY 'INFORME A QUANTIDADE EM ESTOQUE DO PRODUTO'
                ACCEPT ESTOQUE-PRODUTO
      ********  COMANDO PARA INSERIR DADOS NO ARQUIVO ******************
                WRITE REG-PRODUTO
      ********* VERIFICANDO SE O REGISTRO FOI REALIZADO ****************
                IF WS-FS NOT EQUAL ZEROS
                    DISPLAY 'ERRO - NÃO FOI POSSIVEL GRAVAR O REGISTRO'
                    DISPLAY 'FILE STATUS: ' WS-FS
                ELSE
                    DISPLAY 'REGISTRO GRAVADO COM SUCESSO!'
                END-IF
             ELSE
                DISPLAY 'ERRO AO CRIAR O ARQUIVO'
                DISPLAY 'FILE STATUS: ' WS-FS
             END-IF
             CLOSE PRODUTOS
            STOP RUN.
       END PROGRAM PROGRAMA_EX13.
