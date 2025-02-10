      ******************************************************************
      * Author: Ana Beatriz Barbosa Alves
      * Date: 06/11/2021
      * Purpose: Continuando com nosso sistema de controle de estoque,
      * agora nos programas que permitem a consulta de todos os itens no
      * caso uma listagem e na consulta individual.
      * Vamos criar um programa que possa fazer a listagem de todos
      * os produtos, mas também me ofereça a oportunidade de localizar
      * um registro específico. (Unir os dois últimos programas
      * desenvolvidos), além das melhorias que forem necessárias.
      * Tectonics: cobc
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. ATIVIDADE_02.
      *************************************************
      * MELHORIAS NA CONSULTA E LISTAGEM DE PRODUTOS  *
      *************************************************
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT PRODUTOS ASSIGN TO
              'D:\GitHub\fatec\20212-programacao-para-mainframe\Arquivos
      -        '\produtos.txt'
           ORGANIZATION IS INDEXED
           ACCESS IS DYNAMIC
           RECORD KEY IS COD-PRODUTO
           FILE STATUS IS WS-FS.
       DATA DIVISION.
       FILE SECTION.
       FD PRODUTOS.
       01 REG-PRODUTO.
          03 COD-PRODUTO           PIC 9(03).
          03 NOME-PRODUTO          PIC X(20).
          03 ESTOQUE-PRODUTO       PIC 9(09).
       WORKING-STORAGE SECTION.
       77 WS-FS            PIC 99.
       77 WS-EOF           PIC 99.
       77 WS-CONTADOR      PIC 99.
       77 W-OPCAO          PIC 99.

       01 WS-PRODUTO.
          03 WS-COD-PRODUTO           PIC 9(03).
          03 WS-NOME-PRODUTO          PIC X(20).
          03 WS-ESTOQUE-PRODUTO       PIC 9(09).

      *-------------------[ DIVISAO DE PROCEDIMENTOS ]------------------
       PROCEDURE DIVISION.
      *
      *****************************************
      * ROTINA DE MENU *
      *****************************************
      *
       MENU-001.
            DISPLAY '-------------------[ MENU ]-------------------'
            DISPLAY "1 - CONSULTA | 2 - LISTAR | 99 - SAIR"
            DISPLAY " "
            ACCEPT W-OPCAO
            IF W-OPCAO = 1
               GO TO CON-001.
            IF W-OPCAO = 2
               GO TO LIS-001.
            IF W-OPCAO = 99
               GO TO ROT-FIM.
            IF W-OPCAO NOT = 1 AND 2 AND 99
               DISPLAY "*** DIGITE APENAS 1 OU 2 OU 99 ***"
               DISPLAY " "
               GO TO MENU-001.

       LIS-001.
            SET WS-EOF  TO 0
            SET WS-FS TO 0
            SET WS-CONTADOR TO 0
            OPEN INPUT PRODUTOS
            DISPLAY '---------- LISTAGEM DE PRODUTOS -------------'
            PERFORM UNTIL WS-EOF = 1
               READ PRODUTOS INTO WS-PRODUTO
                   AT END MOVE 1 TO WS-EOF NOT AT END
                       DISPLAY ' COD. PRODUTO: ' WS-COD-PRODUTO
                               ' NOME PRODUTO: ' WS-NOME-PRODUTO
                               ' QTDE EM ESTOQUE: ' WS-ESTOQUE-PRODUTO
                       ADD 1 TO WS-CONTADOR
               END-READ
            END-PERFORM
            DISPLAY 'TOTAL DE REGISTRO LOCALIZADOS: ' WS-CONTADOR
            DISPLAY " "
            CLOSE PRODUTOS
            GO TO MENU-001.

       CON-001.
            OPEN I-O PRODUTOS.
            DISPLAY '---------- CONSULTA DE PRODUTOS -------------'
            DISPLAY 'INFORME O CODIGO DO PRODUTO'
            ACCEPT COD-PRODUTO

            READ PRODUTOS RECORD INTO WS-PRODUTO
              KEY IS COD-PRODUTO
                   INVALID KEY
                       DISPLAY 'CODIGO DO PRODUTO INVALIDO'
                       DISPLAY " "
                       GO TO CON-001
                   NOT INVALID KEY
                       DISPLAY 'CODIGO DO PRODUTO: ' WS-COD-PRODUTO
                       DISPLAY 'NOME DO PRODUTO: ' WS-NOME-PRODUTO
                       DISPLAY 'QTDE EM ESTOQUE: ' WS-ESTOQUE-PRODUTO
                       DISPLAY " "
            END-READ.
            CLOSE PRODUTOS
            GO TO MENU-001.

      **********************
      * ROTINA DE FIM      *
      **********************
       ROT-FIM.
               CLOSE PRODUTOS
               EXIT PROGRAM.
       ROT-FIMP.
               EXIT PROGRAM.
       ROT-FIMS.
               STOP RUN.
