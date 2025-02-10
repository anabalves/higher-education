      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 02/09/2021
      * Purpose: Trabalhando com arquivos de dados
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. PROGRAMA_EX06.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT ALUNOS ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\alunos.txt'
           ORGANIZATION IS SEQUENTIAL.
       DATA DIVISION.
       FILE SECTION.
       FD ALUNOS.
       01 ALUNOS-FILE.
           03 RGM-ALUNO    PIC 9(05).
           03 NOME-ALUNO   PIC A(20).

       WORKING-STORAGE SECTION.
       01  WS-DADOS-ALUNO  PIC X(25) VALUE SPACES.
       01  FILLER REDEFINES WS-DADOS-ALUNO.
           03 WS-RGM-ALUNO     PIC 9(05).
           03 WS-NOME-ALUNO    PIC A(20).

       77 WS-STATUS-EOF    PIC A VALUE SPACE.
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
            OPEN INPUT ALUNOS.

            PERFORM UNTIL WS-STATUS-EOF = 'F'
               READ ALUNOS INTO WS-DADOS-ALUNO
                   AT END MOVE 'F' TO WS-STATUS-EOF
                       NOT AT END
                           DISPLAY WS-RGM-ALUNO " - " WS-NOME-ALUNO " "
               END-READ
            END-PERFORM.

            CLOSE ALUNOS.

            STOP RUN.
       END PROGRAM PROGRAMA_EX06.
