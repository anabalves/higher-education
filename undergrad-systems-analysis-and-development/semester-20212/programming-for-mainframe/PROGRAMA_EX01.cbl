      ******************************************************************
      * Author: ANA BEATRIZ BARBOSA ALVES
      * Date: 11/09/2021
      * Purpose: NOSSO PRIMEIRO PROGRAMA EM COBOL
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX01.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       INPUT-OUTPUT SECTION.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       77 WS-EXIBIR    PIC X(20) VALUE SPACES.
       PROCEDURE DIVISION.
           MAIN-PROC SECTION.

           P001-PROC1.
               MOVE 'P001-PROC1'   TO WS-EXIBIR
               DISPLAY WS-EXIBIR
               PERFORM SEC-PROC.
           P001-PROC2.
               MOVE 'P001-PROC2'   TO WS-EXIBIR
               DISPLAY WS-EXIBIR
               PERFORM SEC-PROC.
           P001-PROC3.
               IF WS-EXIBIR NOT EQUAL 'P002-PROC3' THEN
                   MOVE 'P001-PROC3'   TO WS-EXIBIR
                   DISPLAY WS-EXIBIR
                   PERFORM P002-PROC3
               ELSE
                   PERFORM FIM-PROC
               END-IF.
           SEC-PROC SECTION.
           P002-PROC1.
               IF WS-EXIBIR NOT EQUAL 'P001-PROC2' THEN
                   MOVE 'P002-PROC1'   TO WS-EXIBIR
                   DISPLAY WS-EXIBIR
                   PERFORM P001-PROC2
               END-IF.
           P002-PROC2.
               MOVE 'P002.PROC2'   TO WS-EXIBIR
               DISPLAY WS-EXIBIR
               PERFORM P001-PROC3.
           P002-PROC3.
               MOVE 'P002-PROC3'   TO WS-EXIBIR
               DISPLAY WS-EXIBIR
               PERFORM P001-PROC3.
           FIM-PROC SECTION.
               MOVE 'FIM-PROC' TO WS-EXIBIR
               DISPLAY WS-EXIBIR
               STOP RUN.
       END PROGRAM PROGRAMA_EX01.
