      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 26/11/2021
      * Purpose: Desenvolva um programa em Cobol para que solicite ao
      * usuário o seu nome, sua idade e 10 valores inteiros, esses 10
      * valores devem ser armazenados em um vetor, criar um segundo
      * vetor também com 10 posições onde será copiado os valores do
      * primeiro vetor, porém em caso de valores negativo o valor deve
      * ser substituído por 1, ao final exibir o nome e a idade
      * informada pelo usuário e os dois vetores na tela do usuário
      * assim como a somatória de todos os valores do segundo vetor
      * (onde não tem valores negativos).
      * Também será necessário salvar em um arquivo sequencial de nome
      * “PROVA.TXT”, o nome do usuário, sua idade e a soma dos
      * valores do segundo vetor.
      *
      * Estrutura do arquivo PROVA.TXT
      * NOME-ALUNO PIC x(50)
      * IDADE-ALUNO PIC X(03)
      * SOMA-VALORES PIC 9(09)
      *
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. P2_PARTEB.
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT PROVA ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -       '\prova.txt'
           ORGANIZATION IS SEQUENTIAL
           ACCESS MODE IS SEQUENTIAL
           FILE STATUS IS WS-FS.
       DATA DIVISION.
       FILE SECTION.
       FD PROVA.
       01 REG-PROVA.
           03 NOME-ALUNO           PIC X(50).
           03 IDADE-ALUNO          PIC X(03).
           03 SOMA-VALORES         PIC 9(09).
       WORKING-STORAGE SECTION.
           77 WS-FS            PIC 99.
           77 SOMA             PIC 9(09).
           77 CONTADOR         PIC 9(2) VALUE 1.
           01 VETOR01.
               03 NUM-VETOR01    PIC S9(10) OCCURS 10 TIMES.
           01 VETOR02.
               03 NUM-VETOR02    PIC S9(10) OCCURS 10 TIMES.
           PROCEDURE DIVISION.
           MAIN-PROCEDURE.
            DISPLAY "------------ PROVA 02 ------------"
            SET WS-FS  TO 0.
            OPEN EXTEND PROVA

            IF WS-FS EQUAL 35 THEN
               OPEN OUTPUT PROVA
            END-IF

            IF WS-FS EQUAL ZEROS
               DISPLAY 'INFORME O NOME DO ALUNO'
               ACCEPT NOME-ALUNO
               DISPLAY 'INFORME A IDADE DO ALUNO'
               ACCEPT IDADE-ALUNO

               PERFORM UNTIL CONTADOR > 10

                   DISPLAY "DIGITE O " CONTADOR " NUMERO: "
                   ACCEPT NUM-VETOR01(CONTADOR)

                   IF NUM-VETOR01(CONTADOR) IS NEGATIVE THEN
                       MOVE 1 TO NUM-VETOR02(CONTADOR)
                   ELSE
                       MOVE NUM-VETOR01(CONTADOR) TO
                           NUM-VETOR02(CONTADOR)
                   END-IF

                   COMPUTE SOMA = SOMA + NUM-VETOR02(CONTADOR)

                   ADD 1 TO CONTADOR

               END-PERFORM

               MOVE SOMA TO SOMA-VALORES

               WRITE REG-PROVA

               DISPLAY " "
               DISPLAY "NOME: " NOME-ALUNO
               DISPLAY "IDADE: " IDADE-ALUNO

               SET CONTADOR TO 1
               DISPLAY "VETOR 1: "
               PERFORM UNTIL CONTADOR > 10
                   DISPLAY CONTADOR  " ==> " NUM-VETOR01(CONTADOR)
                   ADD 1 TO CONTADOR
               END-PERFORM
               DISPLAY " "

               SET CONTADOR TO 1
               DISPLAY "VETOR 2: "
               PERFORM UNTIL CONTADOR > 10
                   DISPLAY CONTADOR " ==> " NUM-VETOR02(CONTADOR)
                   ADD 1 TO CONTADOR
               END-PERFORM
               DISPLAY " "

               DISPLAY "SOMA DO VETOR 2: " SOMA-VALORES
               DISPLAY " "

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

            CLOSE PROVA

            STOP RUN.
           END PROGRAM P2_PARTEB.
