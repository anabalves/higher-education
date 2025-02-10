      ******************************************************************
      * Author: ANA BEATRIZ BARBOSA ALVES
      * Date: 20/11/2021
      * Purpose: CALCULAR DIVISIVEL
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_012.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       77 WS-NUM                   PIC 9(5).
       77 W-OPCAO                  PIC X(01) VALUE SPACES.
       PROCEDURE DIVISION.
           DISPLAY '------[DIVISIVEL POR 10, 5 E 2]-----'.
       ROT-001.
            DISPLAY 'INFORME UM NUMERO:'
            ACCEPT WS-NUM
            IF WS-NUM = ZEROS
               DISPLAY "NUMERO NAO PODE SER ZERADO"
               GO TO ROT-001.

       ROT-002.
            IF FUNCTION MOD(WS-NUM, 10) = 0 AND
                FUNCTION MOD(WS-NUM, 5) = 0 AND
                FUNCTION MOD(WS-NUM, 2) = 0
                DISPLAY WS-NUM," E DIVISIVEL POR 10, 5 E 2"
            ELSE IF FUNCTION MOD(WS-NUM, 10) = 0 AND
                FUNCTION MOD(WS-NUM, 5) = 0
                DISPLAY WS-NUM," E DIVISIVEL POR 10 E 5"
            ELSE IF FUNCTION MOD(WS-NUM, 10) = 0 AND
                FUNCTION MOD(WS-NUM, 2) = 0
                DISPLAY WS-NUM," E DIVISIVEL POR 10 E 2"
            ELSE IF FUNCTION MOD(WS-NUM, 5) = 0 AND
                FUNCTION MOD(WS-NUM, 2) = 0
                DISPLAY WS-NUM," E DIVISIVEL POR 5 E 2"
            ELSE IF FUNCTION MOD(WS-NUM, 10) = 0
                DISPLAY WS-NUM," E DIVISIVEL POR 10"
            ELSE IF FUNCTION MOD(WS-NUM, 10) = 0
                DISPLAY WS-NUM," E DIVISIVEL POR 10"
            ELSE IF FUNCTION MOD(WS-NUM, 5) = 0
                 DISPLAY WS-NUM," E DIVISIVEL POR 5"
            ELSE IF FUNCTION MOD(WS-NUM, 2) = 0
                 DISPLAY WS-NUM," E DIVISIVEL POR 2"
            ELSE
               DISPLAY WS-NUM," NAO E DIVISIVEL POR 10, 5 E 2".
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

       END PROGRAM EXERCICIO_012.
