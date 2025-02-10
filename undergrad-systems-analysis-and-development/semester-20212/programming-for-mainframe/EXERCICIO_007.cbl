      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 09/10/2021
      * Purpose: A partir do arquivo duplicata separar em pagas e vencidas
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_007.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT DUPLICATAS ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\duplicatas.txt'
           ORGANIZATION    IS SEQUENTIAL
           ACCESS MODE     IS SEQUENTIAL
           FILE STATUS     IS WS-FS-DUPLICATAS.

           SELECT DUPL_VENCIDAS ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\dupl_vencidas.txt'
           ORGANIZATION    IS SEQUENTIAL
           ACCESS MODE     IS SEQUENTIAL
           FILE STATUS     IS WS-FS-DUPL_VENCIDAS.

           SELECT DUPL_PAGAS ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\dupl_pagas.txt'
           ORGANIZATION    IS SEQUENTIAL
           ACCESS MODE     IS SEQUENTIAL
           FILE STATUS     IS WS-FS-DUPL_PAGAS.
       DATA DIVISION.
       FILE SECTION.
       FD DUPLICATAS.
       01 REG-DUPLICATA.
           03 DUPL-NR-DUPLICATA        PIC 9(004).
           03 DUPL-COD-CLIENTE         PIC 9(003).
           03 DUPL-DT-EMISSAO          PIC 9(008).
           03 DUPL-DT-VENCIMENTO       PIC 9(008).
           03 DUPL-VL-FATURA           PIC S9(013)V9(002).
           03 DUPL-ST-DUPLICATA        PIC X(003).

       FD DUPL_VENCIDAS.
       01 REG-DUPL_VENCIDAS.
           03 DUPL-V-NR-DUPLICATA      PIC 9(004).
           03 DUPL-V-COD-CLIENTE       PIC 9(003).
           03 DUPL-V-DT-EMISSAO        PIC 9(008).
           03 DUPL-V-DT-VENCIMENTO     PIC 9(008).
           03 DUPL-V-VL-FATURA         PIC S9(013)V9(002).
           03 DUPL-V-ST-DUPLICATA      PIC X(003).

       FD DUPL_PAGAS.
       01 REG-DUPL_PAGAS.
           03 DUPL-P-NR-DUPLICATA      PIC 9(004).
           03 DUPL-P-COD-CLIENTE       PIC 9(003).
           03 DUPL-P-DT-EMISSAO        PIC 9(008).
           03 DUPL-P-DT-VENCIMENTO     PIC 9(008).
           03 DUPL-P-VL-FATURA         PIC S9(013)V9(002).
           03 DUPL-P-ST-DUPLICATA      PIC X(003).

       WORKING-STORAGE SECTION.
       77 WS-FS-DUPLICATAS             PIC 99.
       77 WS-FS-DUPL_VENCIDAS          PIC 99.
       77 WS-FS-DUPL_PAGAS             PIC 99.
       77 WS-EOF                       PIC 99.

       01 WS-DUPLICATA.
           03 WS-DUPL-NR-DUPLICATA     PIC 9(004).
           03 WS-DUPL-COD-CLIENTE      PIC 9(003).
           03 WS-DUPL-DT-EMISSAO       PIC 9(008).
           03 WS-DUPL-DT-VENCIMENTO    PIC 9(008).
           03 WS-DUPL-VL-FATURA        PIC S9(013)V9(002).
           03 WS-DUPL-ST-DUPLICATA     PIC X(003).

       01 WS-CONTADORES.
           03 WS-LIDOS                 PIC 9(006) VALUE ZEROS.
           03 WS-GRAVADOS-VENCIDOS     PIC 9(006) VALUE ZEROS.
           03 WS-GRAVADOS-PAGOS        PIC 9(006) VALUE ZEROS.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            DISPLAY '---------- LISTA DE DUPLICATAS ----------'

            SET WS-FS-DUPLICATAS   TO 0.
            SET WS-EOF             TO 0.

            OPEN INPUT DUPLICATAS
            OPEN EXTEND DUPL_VENCIDAS
            OPEN EXTEND DUPL_PAGAS

            PERFORM UNTIL WS-EOF = 1
               READ DUPLICATAS INTO WS-DUPLICATA
                   AT END
                       MOVE 1 TO WS-EOF
                   NOT AT END

                   ADD 1 TO WS-LIDOS

                   DISPLAY ' N. DA DUPLICATA: ' WS-DUPL-NR-DUPLICATA
                       ' CODIGO DO CLIENTE: ' WS-DUPL-COD-CLIENTE
                       ' DATA DE EMISSAO: ' WS-DUPL-DT-EMISSAO
                       ' DATA DE VENCIMENTO: ' WS-DUPL-DT-VENCIMENTO
                       ' VALOR DA DUPLICATA: ' WS-DUPL-VL-FATURA
                       ' STATUS DA DUPLICATA: ' WS-DUPL-ST-DUPLICATA

               IF WS-DUPL-ST-DUPLICATA = "SIM"

                   IF WS-FS-DUPL_PAGAS EQUAL 35 THEN
                       OPEN OUTPUT DUPL_PAGAS
                   END-IF

                   MOVE WS-DUPL-NR-DUPLICATA   TO DUPL-P-NR-DUPLICATA
                   MOVE WS-DUPL-COD-CLIENTE    TO DUPL-P-COD-CLIENTE
                   MOVE WS-DUPL-DT-EMISSAO     TO DUPL-P-DT-EMISSAO
                   MOVE WS-DUPL-DT-VENCIMENTO  TO DUPL-P-DT-VENCIMENTO
                   MOVE WS-DUPL-VL-FATURA      TO DUPL-P-VL-FATURA
                   MOVE WS-DUPL-ST-DUPLICATA   TO  DUPL-P-ST-DUPLICATA

                   WRITE REG-DUPL_PAGAS

                   ADD 1 TO WS-GRAVADOS-PAGOS

                ELSE

                   IF WS-FS-DUPL_VENCIDAS EQUAL 35 THEN
                       OPEN OUTPUT DUPL_VENCIDAS
                   END-IF

                   MOVE WS-DUPL-NR-DUPLICATA   TO DUPL-V-NR-DUPLICATA
                   MOVE WS-DUPL-COD-CLIENTE    TO DUPL-V-COD-CLIENTE
                   MOVE WS-DUPL-DT-EMISSAO     TO DUPL-V-DT-EMISSAO
                   MOVE WS-DUPL-DT-VENCIMENTO  TO DUPL-V-DT-VENCIMENTO
                   MOVE WS-DUPL-VL-FATURA      TO DUPL-V-VL-FATURA
                   MOVE WS-DUPL-ST-DUPLICATA   TO  DUPL-V-ST-DUPLICATA

                   WRITE REG-DUPL_VENCIDAS

                   ADD 1 TO WS-GRAVADOS-VENCIDOS

               END-READ
            END-PERFORM.

            DISPLAY 'QUANTIDADE DE DUPLICATAS: ' WS-LIDOS
            DISPLAY 'QUANTIDADE DE DUPLICATAS PAGAS: ' WS-GRAVADOS-PAGOS
            DISPLAY 'QUANTIDADE DE DUPLICATAS VENCIDAS: '
               WS-GRAVADOS-VENCIDOS

            CLOSE DUPLICATAS.
            CLOSE DUPL_VENCIDAS.
            CLOSE DUPL_PAGAS.

            STOP RUN.
       END PROGRAM EXERCICIO_007.
