      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 25/09/2021
      * Purpose: Calcular a media diaria da temperatura por 7 dias
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX04.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 WS-DIAS.
           03 FILLER               PIC X(015) VALUE 'DOMINGO'.
           03 FILLER               PIC X(015) VALUE 'SEGUNDA-FEIRA'.
           03 FILLER               PIC X(015) VALUE 'TERCA-FEIRA'.
           03 FILLER               PIC X(015) VALUE 'QUARTA-FEIRA'.
           03 FILLER               PIC X(015) VALUE 'QUINTA-FEIRA'.
           03 FILLER               PIC X(015) VALUE 'SEXTA-FEIRA'.
           03 FILLER               PIC X(015) VALUE 'SABADO'.

       01 FILLER REDEFINES WS-DIAS.
           03  WS-DIA              PIC X(015) OCCURS 7.

           03 WS-TEMPERATURA       PIC S9(013)V9(002) OCCURS 7.

       77 WS-MEDIA                 PIC 9(003) VALUE ZERO.
       77 WS-QTDE-DIA-ACIMA        PIC 9(003) VALUE ZERO.
       77 WS-QTDE-DIA-ABAIXO       PIC 9(003) VALUE ZERO.

       77 WS-CONTROLE              PIC 9(001) VALUE 1.

       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           INITIALISE WS-MEDIA
           INITIALISE WS-QTDE-DIA-ACIMA
           INITIALISE WS-QTDE-DIA-ABAIXO

      *>  ******************* ESTRUTURA DE REPETICAO *******************
           PERFORM UNTIL WS-CONTROLE EQUAL 8
               DISPLAY 'DIGITE A TEMPERATURA DA ' WS-DIA(WS-CONTROLE)
               ACCEPT WS-TEMPERATURA(WS-CONTROLE)
               ADD WS-TEMPERATURA(WS-CONTROLE) TO WS-MEDIA
               ADD 1 TO WS-CONTROLE
           END-PERFORM

           DIVIDE 7 INTO WS-MEDIA ROUNDED

           MOVE 1 TO WS-CONTROLE

           PERFORM UNTIL WS-CONTROLE EQUAL 8
               IF WS-TEMPERATURA(WS-CONTROLE) GREATER WS-MEDIA
                   ADD 1 TO WS-QTDE-DIA-ACIMA
               END-IF

               IF WS-TEMPERATURA(WS-CONTROLE) LESS WS-MEDIA
                   ADD 1 TO WS-QTDE-DIA-ABAIXO
               END-IF
               ADD 1 TO WS-CONTROLE
           END-PERFORM

           DISPLAY 'A MEDIA DA TEMPERATURA E ' WS-MEDIA
           DISPLAY 'DIAS ACIMA DA MEDIA E ' WS-QTDE-DIA-ACIMA
           DISPLAY 'DIAS ABAIXO DA MEDIA E ' WS-QTDE-DIA-ABAIXO

           STOP RUN.
       END PROGRAM PROGRAMA_EX04.
