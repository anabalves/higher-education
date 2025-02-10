      ******************************************************************
      * Author: ANA BEATRIZ BARBOSA ALVES
      * Date: 20/11/2021
      * Purpose: CALCULAR
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_014.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       77 NUM              PIC 9(5).
       77 MAIOR            PIC 9(5).
       77 MENOR            PIC 9(5).
       77 CONTADOR         PIC 9(2) VALUE 1.
       01 ARRAY.
           03 NUM-ARRAY    PIC 9(10) OCCURS 10 TIMES.
       77 W-OPCAO                  PIC X(01) VALUE SPACES.
       PROCEDURE DIVISION.
       DISPLAY "LER 100 NUMEROS E DESCOBRIR O MENOR E MAIOR".
       ROT-001.
           PERFORM UNTIL CONTADOR > 10
               DISPLAY "DIGITE O " CONTADOR " NUMERO: "
               ACCEPT NUM-ARRAY(CONTADOR)

               IF CONTADOR EQUAL 1
                   COMPUTE MAIOR = NUM-ARRAY(CONTADOR)
                   COMPUTE MENOR = NUM-ARRAY(CONTADOR)
               END-IF

               IF NUM-ARRAY(CONTADOR) > MAIOR
                   COMPUTE MAIOR = NUM-ARRAY(CONTADOR)
               END-IF

               IF NUM-ARRAY(CONTADOR) < MENOR
                   COMPUTE MENOR = NUM-ARRAY(CONTADOR)
               END-IF

               ADD 1 TO CONTADOR

           END-PERFORM

           DISPLAY "O MENOR VALOR DO VETOR E " MENOR
           DISPLAY "O MAIOR VALOR DO VETOR E " MAIOR.

            STOP RUN.
       END PROGRAM EXERCICIO_014.
