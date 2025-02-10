      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 02/09/2021
      * Purpose: Trabalhando com arquivos de dados
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_006.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT FORNECEDORES ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\fornecedores.txt'
           ORGANIZATION IS SEQUENTIAL
           ACCESS MODE IS SEQUENTIAL
           FILE STATUS IS WS-FS.
       DATA DIVISION.
       FILE SECTION.
       FD FORNECEDORES.
       01 REG-FORNECEDOR.
           03 COD-FORNECEDOR          PIC 9(05).
           03 NOME-FORNECEDOR         PIC X(20).
           03 TELEFONE-FORNECEDOR     PIC X(15).
       WORKING-STORAGE SECTION.
       77 WS-FS PIC 99.

       01  WS-DADOS-FORNECEDOR  PIC X(40) VALUE SPACES.
       01  FILLER REDEFINES WS-DADOS-FORNECEDOR.
           03 WS-COD-FORNECEDOR          PIC 9(05).
           03 WS-NOME-FORNECEDOR         PIC X(20).
           03 WS-TELEFONE-FORNECEDOR     PIC X(15).

       77 WS-STATUS-EOF    PIC A VALUE SPACE.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            DISPLAY "------------ CADASTRO DE FORNECEDOR ------------"
            SET WS-FS  TO 0.
            OPEN EXTEND FORNECEDORES

            IF WS-FS EQUAL 35 THEN
                OPEN OUTPUT FORNECEDORES
            END-IF

            IF WS-FS EQUAL ZEROS
                DISPLAY 'INFORME O CODIGO DO FORNECEDOR'
                ACCEPT COD-FORNECEDOR
                DISPLAY 'INFORME O NOME DO FORNECEDOR'
                ACCEPT NOME-FORNECEDOR
                DISPLAY 'INFORME O TELEFONE DO FORNECEDOR'
                ACCEPT TELEFONE-FORNECEDOR

                WRITE REG-FORNECEDOR

                IF WS-FS NOT EQUAL ZEROS
                    DISPLAY 'ERRO - NÃO FOI POSSIVEL GRAVAR O REGISTRO'
                    DISPLAY 'FILE STATUS: ' WS-FS
                ELSE
                    DISPLAY  'REGISTRO GRAVADO COM SUCESSO!'
                END-IF
            ELSE
                DISPLAY 'ERRO AO CRIAR O ARQUIVO'
                DISPLAY 'FILE STATUS: ' WS-FS
            END-IF

            CLOSE FORNECEDORES

            DISPLAY " "
            DISPLAY "------------- DADOS CADASTRADOS -------------"

            OPEN INPUT FORNECEDORES.

            PERFORM UNTIL WS-STATUS-EOF = 'F'
               READ FORNECEDORES INTO WS-DADOS-FORNECEDOR
                   AT END MOVE 'F' TO WS-STATUS-EOF
                       NOT AT END
                       DISPLAY COD-FORNECEDOR" | "NOME-FORNECEDOR " | "
                           TELEFONE-FORNECEDOR
               END-READ
            END-PERFORM.

            CLOSE FORNECEDORES.

            STOP RUN.
       END PROGRAM EXERCICIO_006.
