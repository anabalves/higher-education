      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 25/09/2021
      * Purpose: Calcular velocidade media
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_004.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 WS-VALORES.
           05 WS-KM            PIC S9(006)V9(002).
           05 WS-H             PIC S9(002)V9(002).
           05 WS-V             PIC S9(003)V9(002).
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY 'DIGITE A DISTANCIA PERCORRIDA EM KM'
           ACCEPT WS-KM
           DISPLAY 'DIGITE O TEMPO PARA PERCORRER A DISTANCIA EM HORAS'
           ACCEPT WS-H

           IF WS-KM GREATER 0 AND WS-H GREATER 0
               COMPUTE WS-V = WS-KM / WS-H
               DISPLAY 'A VELOCIDADE MEDIA DO AUTOMOVEL E = 'WS-V'Km/h'
           ELSE
               DISPLAY 'NAO E POSSIVEL CALCULAR A VELOCIDADE
      -        '- VOCE DEVE DIGITAR APENAS VALORES POSITIVOS'
           END-IF

           STOP RUN.
       END PROGRAM EXERCICIO_004.
