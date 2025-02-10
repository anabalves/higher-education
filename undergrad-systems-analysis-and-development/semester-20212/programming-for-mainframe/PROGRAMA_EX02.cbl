      ******************************************************************
      * Author: ANA BEATRIZ BARBOSA ALVES
      * Date: 18/09/2021
      * Purpose: EXEMPLO DE OPERADORES ARITMÉTICOS
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX02.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
           SPECIAL-NAMES.
               DECIMAL-POINT IS COMMA.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 WS-VALORES.
           05 WS-NUM1      PIC S9(06).
           05 WS-NUM2      PIC S9(06).
           05 WS-RESUL     PIC S9(06).
           05 WS-MASCARA   PIC -ZZ.ZZ9,99.
           05 WS-OP        PIC X(1).
       PROCEDURE DIVISION.
       P001-PRINCIPAL.
           INITIALISE WS-VALORES.

           DISPLAY " QUAL OPERACAO (+, -, * ou /) : "
           ACCEPT WS-OP

           DISPLAY " INFORME O PRIMEIRO VALOR: "
           ACCEPT WS-NUM1

           DISPLAY " INFORME O SEGUNDO VALOR: "
           ACCEPT WS-NUM2

           IF WS-OP EQUAL "+"
               ADD WS-NUM1 WS-NUM2 GIVING WS-RESUL
      *>          COMPUTE WS-RESUL = WS-NUM1 + WS-NUM2
               MOVE WS-RESUL TO WS-MASCARA
               DISPLAY WS-NUM1 " + " WS-NUM2 " = " WS-MASCARA
           ELSE
           IF WS-OP EQUAL "-"
               SUBTRACT WS-NUM2 FROM WS-NUM1 GIVING WS-RESUL
      *>          COMPUTE WS-RESUL = WS-NUM1 - WS-NUM2
               MOVE WS-RESUL TO WS-MASCARA
               DISPLAY WS-NUM1 " - " WS-NUM2 " = " WS-MASCARA
           ELSE
           IF WS-OP EQUAL "*"
               MULTIPLY WS-NUM1 BY WS-NUM2 GIVING WS-RESUL
      *>          COMPUTE WS-RESUL = WS-NUM1 * WS-NUM2
               MOVE WS-RESUL TO WS-MASCARA
               DISPLAY WS-NUM1 " * " WS-NUM2 " = " WS-MASCARA
           ELSE
           IF WS-OP EQUAL "/"
               DIVIDE WS-NUM2 INTO WS-NUM1 GIVING WS-RESUL
      *>          COMPUTE WS-RESUL = WS-NUM1 / WS-NUM2
               MOVE WS-RESUL TO WS-MASCARA
               DISPLAY WS-NUM1 " / " WS-NUM2 " = " WS-MASCARA
           ELSE
               DISPLAY "ESSA OPERACAO NAO E VALIDA"
           END-IF.
           STOP RUN.
       END PROGRAM PROGRAMA_EX02.
