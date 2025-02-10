      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 25/09/2021
      * Purpose: Exemplo de Estrutura de Controle
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX03.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 WS-CLIENTE.
           05 WS-NOME                  PIC X(30).
           05 WS-TIPO                  PIC X.
               88 WS-TIPO-OK           VALUE 'F' FALSE 'J'.
           05 WS-VENDEDOR              PIC 9.
               88 WS-COD-VENDEDOR      VALUE 1 THRU 5.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY 'INFORME O NOME DO CLIENTE'
           ACCEPT WS-CLIENTE
           DISPLAY 'TIPO DE CLIENTE <F> OU <J>'
           ACCEPT WS-TIPO
           DISPLAY 'INFORME O CODIGO DO VENDEDOR: '
           DISPLAY '1 - JOSE'
           DISPLAY '2 - PAULO'
           DISPLAY '3 - PEDRO'
           DISPLAY '4 - RAFAEL'
           DISPLAY '5 - SILVIO'
           ACCEPT WS-VENDEDOR

      *>   ***************** EXIBINDO AS INFORMACOES *******************
           DISPLAY 'CLIENTE: ' WS-CLIENTE

           DISPLAY 'TIPO DE CLIENTE:'

      *>   ************** ESTRUTURA DE CONTROLE SIMPLES ****************
           IF WS-TIPO-OK THEN
               DISPLAY 'PESSOA FISICA'
           ELSE
               DISPLAY 'PESSOA JURIDICA'
           END-IF

      *>   ********* ESTRUTURA DE CONTROLE E DO TIPO COMPARACAO ********
           EVALUATE WS-VENDEDOR
               WHEN 1
                   DISPLAY 'VENDEDOR = JOSE'
               WHEN 2
                   DISPLAY 'VENDEDOR = PAULO'
               WHEN 3
                   DISPLAY 'VENDEDOR = PEDRO'
               WHEN 4
                   DISPLAY 'VENDEDOR = RAFAEL'
               WHEN 5
                   DISPLAY 'VENDEDOR = SILVIO'
               WHEN OTHER
                   DISPLAY 'CODIGO DO VENDEDOR INVALIDO'
           END-EVALUATE

           STOP RUN.
       END PROGRAM PROGRAMA_EX03.
