      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 25/09/2021
      * Purpose: Calcular o preco total a pagar e o valor da prestacao
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_005.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
             SPECIAL-NAMES.
               DECIMAL-POINT IS COMMA.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 WS-VALORES.
           05 WS-PRECO-A-VISTA                  PIC 9(013)V9(002).
           05 WS-QUANTIDADE-PARCELAS            PIC 9(004).
           05 WS-VALOR-PARCELA                  PIC 9(013)V9(002).
           05 WS-VALOR-TOTAL                    PIC 9(013)V9(002).
           05 WS-PARCELA-MASCARA                PIC ZZZZZZZZZZZZ9,99.
           05 WS-TOTAL-MASCARA                  PIC ZZZZZZZZZZZZ9,99.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY 'INFORME O PRECO A VISTA'
           ACCEPT WS-PRECO-A-VISTA
           DISPLAY 'INFORME A QUANTIDADE PARCELAS: '
           ACCEPT WS-QUANTIDADE-PARCELAS

           IF WS-PRECO-A-VISTA GREATER 0 AND
               WS-QUANTIDADE-PARCELAS GREATER 0 THEN
               IF WS-QUANTIDADE-PARCELAS LESS 2
                  MOVE WS-PRECO-A-VISTA TO WS-TOTAL-MASCARA
                  DISPLAY 'PAGAMENTO A VISTA R$' WS-TOTAL-MASCARA
               ELSE
                   IF WS-QUANTIDADE-PARCELAS NOT GREATER 3
                       COMPUTE WS-VALOR-TOTAL = WS-PRECO-A-VISTA * 1,10
                       COMPUTE WS-VALOR-PARCELA = WS-VALOR-TOTAL
                           / WS-QUANTIDADE-PARCELAS
                   ELSE
                       COMPUTE WS-VALOR-TOTAL = WS-PRECO-A-VISTA * 1,20
                       COMPUTE WS-VALOR-PARCELA = WS-VALOR-TOTAL
                           / WS-QUANTIDADE-PARCELAS
                   END-IF
                  MOVE WS-VALOR-TOTAL TO WS-TOTAL-MASCARA
                  MOVE WS-VALOR-PARCELA TO WS-PARCELA-MASCARA
               DISPLAY 'PRECO TOTAL A PAGAR R$' WS-TOTAL-MASCARA
               DISPLAY 'VALOR DA PRESTACAO MENSAL R$' WS-PARCELA-MASCARA
               END-IF
           ELSE
               DISPLAY 'PRECO E QUANTIDADE DE PARCELAS INVALIDA'
           END-IF

           STOP RUN.
       END PROGRAM EXERCICIO_005.
