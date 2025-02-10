algoritmo "Exercicio42"

var

   soma, denominador : real
   numerador: inteiro

inicio

   denominador <-1
   soma <- 0
   
   para numerador := 1 ate 50 faca
      soma <- soma + (numerador/denominador)
      denominador <-denominador + 2
   fimpara

   escreva("O resultado da serie e ", soma:4:2)

fimalgoritmo