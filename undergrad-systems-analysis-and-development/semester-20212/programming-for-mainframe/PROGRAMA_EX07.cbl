      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 02/09/2021
      * Purpose: Trabalhando com arquivos de dados
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX07.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT CLIENTES ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\clientes.txt'
           ORGANIZATION IS SEQUENTIAL
           ACCESS MODE IS SEQUENTIAL
           FILE STATUS IS WS-FS.
       DATA DIVISION.
       FILE SECTION.
       FD CLIENTES.
       01 REG-CLIENTE.
           03 COD-CLIENTE          PIC 9(03).
           03 NOME-CLIENTE         PIC X(20).
           03 TELEFONE-CLIENTE     PIC X(14).
       WORKING-STORAGE SECTION.
       77 WS-FS PIC 99.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            DISPLAY "------------ CADASTRO DE CLIENTE ------------"
            SET WS-FS  TO 0.
            OPEN EXTEND CLIENTES

            IF WS-FS EQUAL 35 THEN
                OPEN OUTPUT CLIENTES
            END-IF

            IF WS-FS EQUAL ZEROS
                DISPLAY 'INFORME O CODIGO DO CLIENTE'
                ACCEPT COD-CLIENTE
                DISPLAY 'INFORME O NOME DO CLIENTE'
                ACCEPT NOME-CLIENTE
                DISPLAY 'INFORME O TELEFONE-CLIENTE'
                ACCEPT TELEFONE-CLIENTE

                WRITE REG-CLIENTE

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

            CLOSE CLIENTES

            STOP RUN.
       END PROGRAM PROGRAMA_EX07.
