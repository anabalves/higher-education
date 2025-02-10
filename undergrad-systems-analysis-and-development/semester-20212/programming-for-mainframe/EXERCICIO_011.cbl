      ******************************************************************
      * Author: ANA BEATRIZ BARBOSA ALVES
      * Date: 20/11/2021
      * Purpose: CALCULAR O PESO EM OUTRO PLANETA
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_011.
       ENVIRONMENT DIVISION.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       77 WS-PESO                  PIC 9(03)V99.
       77 WS-PESO-PLANETA          PIC 9(03)V999.
       77 WS-NRO                   PIC 9.
           88 WS-NRO-PLANETA       VALUE 1 THRU 6.
       77 W-OPCAO                  PIC X(01) VALUE SPACES.
       PROCEDURE DIVISION.
           DISPLAY '------[SEU PESO EM OUTRO PLANELA]-----'.
       ROT-001.
            DISPLAY 'INFORME SEU PESO NA TERRA:'
            ACCEPT WS-PESO
            IF WS-PESO = ZEROS
               DISPLAY "PESO NAO PODE SER ZERADO"
               GO TO ROT-001.

       ROT-002.
           DISPLAY 'INFORME O CODIGO DO PLANETA: '
           DISPLAY '1 - MERCURIO'
           DISPLAY '2 - VENUS'
           DISPLAY '3 - MARTE'
           DISPLAY '4 - JUPITER'
           DISPLAY '5 - SATURNO'
           DISPLAY '6 - URANO'
           ACCEPT WS-NRO
           IF (WS-NRO < 1 OR WS-NRO > 6) THEN
               DISPLAY "NRO DO PLANETA INVALIDO"
               GO TO ROT-002.

      *>   ********* ESTRUTURA DE CONTROLE E DO TIPO COMPARACAO ********
       ROT-003.
           EVALUATE WS-NRO
               WHEN 1
                   COMPUTE WS-PESO-PLANETA = (WS-PESO / 10) * 0.37
                   DISPLAY 'SEU PESO EM MERCURIO E = ' WS-PESO-PLANETA
               WHEN 2
                   COMPUTE WS-PESO-PLANETA = (WS-PESO / 10) * 0.88
                   DISPLAY 'SEU PESO EM VENUS E = ' WS-PESO-PLANETA
               WHEN 3
                   COMPUTE WS-PESO-PLANETA = (WS-PESO / 10) * 0.38
                   DISPLAY 'SEU PESO EM MARTE E = ' WS-PESO-PLANETA
               WHEN 4
                   COMPUTE WS-PESO-PLANETA = (WS-PESO / 10) * 2.64
                   DISPLAY 'SEU PESO EM JUPITER E = ' WS-PESO-PLANETA
               WHEN 5
                   COMPUTE WS-PESO-PLANETA = (WS-PESO / 10) * 1.15
                   DISPLAY 'SEU PESO EM SATURNO E = ' WS-PESO-PLANETA
               WHEN 6
                   COMPUTE WS-PESO-PLANETA = (WS-PESO / 10) * 1.17
                   DISPLAY 'SEU PESO EM URANO E = ' WS-PESO-PLANETA
           END-EVALUATE.
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

       END PROGRAM EXERCICIO_011.
