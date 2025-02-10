algoritmo "Exercicio75"

funcao calcularSerie(): real

var

   soma : real
   numerador : inteiro

inicio

   para numerador:=1 ate 15 faca
      se (numerador Mod 2 = 0) entao
         soma <- (soma - (numerador / (numerador * numerador)))
      senao
         soma <- (soma + (numerador / (numerador * numerador)))
      fimse
   fimpara

   retorne soma

fimfuncao

inicio

   escreva("O resultado da soma da serie e ", calcularSerie():3:2)

fimalgoritmo