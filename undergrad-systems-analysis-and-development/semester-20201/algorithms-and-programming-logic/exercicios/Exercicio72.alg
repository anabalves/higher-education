algoritmo "Exercicio72"

funcao calcularSerie(): real

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
   
   retorne soma

fimfuncao

inicio

   escreva("O resultado da serie e ", calcularSerie():4:2)

fimalgoritmo