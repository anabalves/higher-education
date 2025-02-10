      ******************************************************************
      * Author: CLAUDIO BENOSSI
      * Date: 06/09/2021
      * Purpose: EXERCICIO DE ESTRUTURA DE REPETIÇÃO E DECISÃO
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX05.
       DATA DIVISION.
       FILE SECTION.
       WORKING-STORAGE SECTION.
       01 WS-DATA          PIC X(10) VALUE SPACES.
      ******** VAMOS REDEFINIR A VARIAVEL DATA E QUEBRA EM PARTES ******
       01 WS-DATA-RECEBIDA REDEFINES WS-DATA.
          03 WS-DATA-DIA   PIC 9(02).
      * *** FILLER NÃO ARMAZENA NADA SÓ RESERVA O ESPAÇO
          03 FILLER        PIC X.
          03 WS-DATA-MES   PIC 9(02).
          03 FILLER        PIC X.
          03 WS-DATA-ANO   PIC 9(04).
          03 FILLER        PIC X.

       77 WS-NOME-MES      PIC X(10) VALUE SPACES.
       77 WS-CONTROLE      PIC X.

       PROCEDURE DIVISION.
      ********* PARAGRAFO QUE INDICA O INICIO DO PROGRA ****************
       P100-INICIO.
           DISPLAY "INICIO DO PROGRAMA".
           MOVE SPACES     TO WS-DATA
                              WS-NOME-MES.
           DISPLAY "INFORME UMA DATA: ".
           ACCEPT WS-DATA.

           PERFORM P200-VERIFICA-MES   THRU P200-VERIFICA-MES-FIM.
           PERFORM P300-EXIBIR-DADOS   THRU P300-EXIBIR-DADOS-FIM.
           PERFORM P900-TERMINO        THRU P900-TERMINO-FIM.
       P100-INICIO-FIM.

      ********** PARAGRAFO QUE FAZ A VERIFICAÇÃO DO PROGRAMA ***********
       P200-VERIFICA-MES.
           DISPLAY "VERIFICANDO O MES DA DATA QUE FOI INFORMADO"
           EVALUATE WS-DATA-MES
               WHEN 01
                   MOVE "JANEIRO"      TO WS-NOME-MES
               WHEN 02
                   MOVE "FEVEREIRO"    TO WS-NOME-MES
               WHEN 03
                   MOVE "MARCO"        TO WS-NOME-MES
               WHEN 04
                   MOVE "ABRIL"        TO WS-NOME-MES
               WHEN 05
                   MOVE "MAIO"         TO WS-NOME-MES
               WHEN 06
                   MOVE "JUNHO"        TO WS-NOME-MES
               WHEN 07
                   MOVE "JULHO"        TO WS-NOME-MES
               WHEN 08
                   MOVE "AGOSTO"       TO WS-NOME-MES
               WHEN 09
                   MOVE "SETEMBRO"     TO WS-NOME-MES
               WHEN 10
                   MOVE "OUTUBRO"      TO WS-NOME-MES
               WHEN 11
                   MOVE "NOVEMBRO"     TO WS-NOME-MES
               WHEN 12
                   MOVE "DEZEMBRO"     TO WS-NOME-MES
           END-EVALUATE.

       P200-VERIFICA-MES-FIM.

      ********** PARAGRAFO QUE EXIBI OS DADOS DO PROGRAMA **************
       P300-EXIBIR-DADOS.
           DISPLAY "O MES DA DATA INFORMADA FOI: " WS-NOME-MES.

           DISPLAY "DESEJA CONTINUAR: (S/N)".
           ACCEPT WS-CONTROLE.

           IF WS-CONTROLE = "S" THEN
               PERFORM P100-INICIO     THRU P100-INICIO-FIM
           END-IF.
       P300-EXIBIR-DADOS-FIM.

      ********** PARAGRAFO QUE INDICA O FIM DO PROGRAMA ****************
       P900-TERMINO.
            STOP RUN.
       P900-TERMINO-FIM.
       END PROGRAM PROGRAMA_EX05.
