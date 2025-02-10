      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 25/09/2021
      * Purpose: Calcular valor de parcela a partir do total e quantidade
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_002.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
             SPECIAL-NAMES.
               DECIMAL-POINT IS COMMA.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 WS-VALORES.
           05 WS-TOTAL-COMPRA                      PIC 9(013)V9(002).
           05 WS-QUANTIDADE-PARCELAS               PIC 9(002).
               88 WS-COD-QUANTIDADE-PARCELAS       VALUE 1 THRU 12.
           05 WS-VALOR-PARCELA                     PIC 9(013)V9(002).
           05 WS-MASCARA                           PIC ZZZZZZZZZZZZ9,99.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY 'INFORME O TOTAL DA COMPRA'
           ACCEPT WS-TOTAL-COMPRA
           DISPLAY 'INFORME A QUANTIDADE PARCELAS: '
           DISPLAY '1'
           DISPLAY '2'
           DISPLAY '4'
           DISPLAY '6'
           DISPLAY '12'
           ACCEPT WS-QUANTIDADE-PARCELAS

      *>   ********* ESTRUTURA DE CONTROLE E DO TIPO COMPARACAO ********
           EVALUATE WS-QUANTIDADE-PARCELAS
               WHEN 1
                   COMPUTE WS-VALOR-PARCELA = WS-TOTAL-COMPRA
                   / WS-QUANTIDADE-PARCELAS
                   MOVE WS-VALOR-PARCELA TO WS-MASCARA
                   DISPLAY 'VALOR DA PARCELA = R$' WS-MASCARA
               WHEN 2
                   COMPUTE WS-VALOR-PARCELA = (WS-TOTAL-COMPRA * 1,02)
                   / WS-QUANTIDADE-PARCELAS
                   MOVE WS-VALOR-PARCELA TO WS-MASCARA
                   DISPLAY 'VALOR DA PARCELA = R$' WS-MASCARA
               WHEN 4
                   COMPUTE WS-VALOR-PARCELA = (WS-TOTAL-COMPRA * 1,05)
                   / WS-QUANTIDADE-PARCELAS
                   MOVE WS-VALOR-PARCELA TO WS-MASCARA
                   DISPLAY 'VALOR DA PARCELA = R$' WS-MASCARA
               WHEN 6
                   COMPUTE WS-VALOR-PARCELA = (WS-TOTAL-COMPRA * 1,10)
                   / WS-QUANTIDADE-PARCELAS
                   MOVE WS-VALOR-PARCELA TO WS-MASCARA
                   DISPLAY 'VALOR DA PARCELA = R$' WS-MASCARA
               WHEN 12
                   COMPUTE WS-VALOR-PARCELA = (WS-TOTAL-COMPRA * 1,18)
                   / WS-QUANTIDADE-PARCELAS
                   MOVE WS-VALOR-PARCELA TO WS-MASCARA
                   DISPLAY 'VALOR DA PARCELA = R$' WS-MASCARA
               WHEN OTHER
                   DISPLAY 'QUANTIDADE DE PARCELAS INVALIDA'
           END-EVALUATE

            STOP RUN.
       END PROGRAM EXERCICIO_002.
