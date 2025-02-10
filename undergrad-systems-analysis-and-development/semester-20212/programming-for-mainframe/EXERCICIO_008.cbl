      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 09/10/2021
      * Purpose: A partir do arquivo aluno determinar se esta aprovado ou reprovado
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. EXERCICIO_008.
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT ALUNOS ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\alunos.txt'
           ORGANIZATION    IS SEQUENTIAL
           ACCESS MODE     IS SEQUENTIAL
           FILE STATUS     IS WS-FS-ALUNOS.

           SELECT ALUNOS2021 ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\alunos2021.txt'
           ORGANIZATION    IS SEQUENTIAL
           ACCESS MODE     IS SEQUENTIAL
           FILE STATUS     IS WS-FS-ALUNOS2021.

       DATA DIVISION.
       FILE SECTION.
       FD ALUNOS.
       01 ALUNOS-FILE.
           03 RGM-ALUNO            PIC 9(005).
           03 NOME-ALUNO           PIC A(020).

       FD ALUNOS2021.
       01 ALUNOS2021-FILE.
           03 RGM-ALUNOS2021       PIC 9(005).
           03 NOME-ALUNOS2021      PIC A(020).
           03 NOTA1-ALUNOS2021     PIC S9(002)V9(002).
           03 NOTA2-ALUNOS2021     PIC S9(002)V9(002).
           03 MEDIA-ALUNOS2021     PIC S9(002)V9(002).
           03 STATUS-ALUNOS2021    PIC X(010).
       WORKING-STORAGE SECTION.
       77 WS-FS-ALUNOS             PIC 99.
       77 WS-FS-ALUNOS2021         PIC 99.
       77 WS-CONTADOR              PIC 99.
       77 WS-EOF                   PIC 99.

       01 WS-ALUNO.
           03 WS-RGM-ALUNO             PIC 9(005).
           03 WS-NOME-ALUNO            PIC A(020).
       01 WS-ALUNO2021.
           03 WS-RGM-ALUNOS2021       PIC 9(005).
           03 WS-NOME-ALUNOS2021      PIC A(020).
           03 WS-NOTA1-ALUNOS2021     PIC S9(002)V9(002).
           03 WS-NOTA2-ALUNOS2021     PIC S9(002)V9(002).
           03 WS-MEDIA-ALUNOS2021     PIC S9(002)V9(002).
           03 WS-STATUS-ALUNOS2021    PIC X(010).
       PROCEDURE DIVISION.
       MAIN-PROCEDURE.
           DISPLAY '---------- LISTA DE ALUNOS ----------'

           SET WS-FS-ALUNOS       TO 0.
           SET WS-EOF             TO 0.

           OPEN INPUT ALUNOS
           OPEN EXTEND ALUNOS2021

           PERFORM UNTIL WS-EOF = 1
           READ ALUNOS INTO WS-ALUNO
           AT END
               MOVE 1 TO WS-EOF
           NOT AT END

           ADD 1 TO WS-CONTADOR

           OPEN OUTPUT ALUNOS2021
           MOVE WS-RGM-ALUNO   TO RGM-ALUNOS2021
           MOVE WS-NOME-ALUNO TO NOME-ALUNOS2021

           DISPLAY "RGM: " WS-RGM-ALUNO " NOME: " WS-NOME-ALUNO " "

           DISPLAY "DIGITE A NOTA 1 DE " WS-NOME-ALUNO
           ACCEPT NOTA1-ALUNOS2021
           DISPLAY "DIGITE A NOTA 2 DE " WS-NOME-ALUNO
           ACCEPT NOTA2-ALUNOS2021

           COMPUTE WS-MEDIA-ALUNOS2021 =
               ((NOTA1-ALUNOS2021 + NOTA2-ALUNOS2021)/2)
           MOVE WS-MEDIA-ALUNOS2021 TO MEDIA-ALUNOS2021

           IF (MEDIA-ALUNOS2021 >= 6 )
               MOVE "APROVADO" TO STATUS-ALUNOS2021
           ELSE
               MOVE "REPROVADO" TO STATUS-ALUNOS2021
           END-IF

           WRITE ALUNOS2021-FILE

           END-READ
           END-PERFORM.

           DISPLAY 'QUANTIDADE DE ALUNOS: ' WS-CONTADOR

           DISPLAY " "
           DISPLAY "------------- DADOS CADASTRADOS -------------"

            OPEN INPUT ALUNOS2021.

           PERFORM UNTIL WS-EOF = 1
           READ ALUNOS2021 INTO WS-ALUNO2021
           AT END
           MOVE 1 TO WS-EOF
           NOT AT END
           DISPLAY " RGM: "  WS-RGM-ALUNOS2021
           " NOME: " WS-NOME-ALUNOS2021
           " NOTA 1: " WS-NOTA1-ALUNOS2021
           " NOTA 2: " WS-NOTA2-ALUNOS2021
           " MEDIA: " WS-MEDIA-ALUNOS2021
           " STATUS: " WS-STATUS-ALUNOS2021
           END-READ
           END-PERFORM.

           CLOSE ALUNOS.
           CLOSE ALUNOS2021.

           STOP RUN.

       END PROGRAM EXERCICIO_008.
