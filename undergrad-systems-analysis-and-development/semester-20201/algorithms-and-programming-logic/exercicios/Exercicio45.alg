algoritmo "Exercicio45"

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

   escreva("O resultado da soma da serie e ", soma:3:2)

fimalgoritmo