      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 25/09/2021
      * Purpose: Calcular raizes de uma equacao de segundo grau
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_003.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 WS-RAIZES.
           05 WS-A             PIC 9(004).
           05 WS-B             PIC 9(004).
           05 WS-C             PIC 9(004).
           05 WS-DELTA         PIC S9(004)V9(002).
           05 WS-RAIZ1         PIC S9(004)V9(002).
           05 WS-RAIZ2         PIC S9(004)V9(002).
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY 'DIGITE O VALOR DE A'
           ACCEPT WS-A
           DISPLAY 'DIGITE O VALOR DE B'
           ACCEPT WS-B
           DISPLAY 'DIGITE O VALOR DE C'
           ACCEPT WS-C

           IF WS-A EQUAL 0 THEN
               DISPLAY 'NAO E UMA EQUACAO DE 2 GRAU, A DEVE SER != 0'
           ELSE
               COMPUTE WS-DELTA = (WS-B ** 2) - (4 * WS-A * WS-C)
               DISPLAY 'O VALOR DE DELTA E = ' WS-DELTA
               IF WS-DELTA GREATER 0 THEN
                     DISPLAY 'DUAS RAIZES REAIS: QUANDO DELTA
      -              ' FOR MAIOR QUE ZERO'

                     COMPUTE WS-RAIZ1 = (- WS-B +
                     FUNCTION SQRT (WS-DELTA)) / (2 * WS-A)

                     COMPUTE WS-RAIZ2 = (+ WS-B +
                     FUNCTION SQRT (WS-DELTA)) / (2 * WS-A)

                     DISPLAY 'RAIZ 1 = ' WS-RAIZ1
                     DISPLAY 'RAIZ 2 = ' WS-RAIZ2
               ELSE
                   IF WS-DELTA EQUAL 0 THEN
                       DISPLAY 'APENAS UM RAIZ REAL: QUANDO DELTA
      -                ' FOR IGUAL A ZERO'

                       COMPUTE WS-RAIZ1 = (- WS-B +
                       FUNCTION SQRT (WS-DELTA)) / (2 * WS-A)

                       DISPLAY 'RAIZ 1 = ' WS-RAIZ1
                   ELSE
                       DISPLAY 'NENHUMA RAIZ REAL: QUANDO DELTA
      -                ' FOR MENOR QUE ZERO'
                   END-IF
               END-IF
           END-IF
           STOP RUN.
       END PROGRAM EXERCICIO_003.
