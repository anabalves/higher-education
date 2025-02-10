      ******************************************************************
      * Author: ANA BEATRIZ BARBOSA ALVES
      * Date: 20/11/2021
      * Purpose: CALCULAR
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_013.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       77 NUM              PIC 9(5).
       77 SOMA             PIC 9(10).
       77 CONTADOR         PIC 9(2) VALUE 1.
       01 ARRAY.
           03 NUM-ARRAY    PIC 9(10) OCCURS 10 TIMES.
       77 W-OPCAO                  PIC X(01) VALUE SPACES.
       PROCEDURE DIVISION.
       DISPLAY "GUARDAR NUMEROS E SOMAR INFERIORES A 40".
       ROT-001.
           PERFORM UNTIL CONTADOR > 10
               DISPLAY "DIGITE O VALOR " CONTADOR
               ACCEPT NUM
               MOVE NUM TO NUM-ARRAY(CONTADOR)

               IF NUM < 40
                   COMPUTE SOMA = SOMA + NUM
               END-IF

               ADD 1 TO CONTADOR

           END-PERFORM
           DISPLAY "SOMA " SOMA.
      *
      *****************************************
      * ROTINA DE MENU *
      *****************************************
      *
       MENU-001.
            DISPLAY "NOVO CALCULO? (S/N) : ".
            ACCEPT W-OPCAO
            IF W-OPCAO = "S" OR "s"
               GO TO ROT-001.
            IF W-OPCAO = "N" OR "n"
               GO TO ROT-FIM.
            IF W-OPCAO NOT = "S" AND "s"
               DISPLAY "*** DIGITE APENAS S=SIM e N=NAO ***"
               GO TO MENU-001.

      *
      *****************************************
      * ROTINA DE FIM *
      *****************************************
      *
       ROT-FIM.
            EXIT PROGRAM.
       END PROGRAM EXERCICIO_013.
