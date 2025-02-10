      ******************************************************************
      * Author: ANA BEATRIZ BARBOSA ALVES
      * Date: 18/09/2021
      * Purpose: ELABORAR UM SISTEMA PARA CALCULAR O IMC
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_001.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
           SPECIAL-NAMES.
               DECIMAL-POINT IS COMMA.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
           01 WS-VALORES.
               05 WS-PESO          PIC S9(03)V99.
               05 WS-ALTURA        PIC S9(01)V99.
               05 WS-IMC           PIC S9(09)V99.
               05 WS-IMC-MASCARA   PIC ZZ9,99.
           01  RESP    PIC X(01)   VALUE SPACE.
       PROCEDURE DIVISION.

       PRINCIPAL.
           DISPLAY "**************************************"
           DISPLAY "*********** CALCULO DO IMC ***********"
           DISPLAY "**************************************"
           PERFORM PROGRAMA UNTIL RESP = "N"
           STOP RUN.

       PROGRAMA.
           PERFORM ENTRADA-DE-DADOS.

       ENTRADA-DE-DADOS.
           INITIALISE WS-VALORES.

           DISPLAY "POR FAVOR, INFORME SEU PESO (EX: 54,5Kg): "
           ACCEPT WS-PESO

           DISPLAY "POR FAVOR, INFORME SUA ALTURA (EX: 1,79m): "
           ACCEPT WS-ALTURA

           PERFORM VALIDACOES.

       VALIDACOES.
           IF WS-PESO GREATER 0 AND WS-ALTURA GREATER 0 AND WS-PESO
               IS NUMERIC AND WS-ALTURA IS NUMERIC
               PERFORM CALCULOS
               PERFORM MOSTRA-RESULTADOS
           ELSE
               DISPLAY "VOCE DEVE DIGITAR APENAS VALORES NUMERICOS
      -    "E MAIORES QUE ZERO"

               PERFORM ENTRADA-DE-DADOS
           END-IF.

       CALCULOS.
           COMPUTE WS-IMC = WS-PESO / (WS-ALTURA ** 2)
           MOVE WS-IMC TO WS-IMC-MASCARA.

       MOSTRA-RESULTADOS.

           IF WS-IMC LESS 18,5
           DISPLAY "SEU IMC: " WS-IMC-MASCARA " - DESNUTRIDO"
           ELSE
           IF WS-IMC NOT LESS 18,5 AND NOT GREATER 24,9
           DISPLAY "SEU IMC: " WS-IMC-MASCARA " - ADEQUADO"
           ELSE
           IF WS-IMC NOT LESS 25 AND NOT GREATER 29,9
           DISPLAY "SEU IMC: " WS-IMC-MASCARA " - PRÉ-OBESO"
           ELSE
           IF WS-IMC NOT LESS 30 AND NOT GREATER 34,9
           DISPLAY "SEU IMC: " WS-IMC-MASCARA " - OBESIDADE GRAU I"
           ELSE
           IF WS-IMC NOT LESS 35 AND NOT GREATER 39,9
           DISPLAY "SEU IMC: " WS-IMC-MASCARA " - OBESIDADE GRAU II"
           ELSE
           DISPLAY "NAO E POSSIVEL CALCULAR O IMC"
           END-IF.

           MOVE SPACES TO RESP
           PERFORM UNTIL RESP = "S" OR "N"
               DISPLAY "OUTRO CALCULO? (S/N)"
               ACCEPT RESP
           END-PERFORM.

       END PROGRAM EXERCICIO_001.
