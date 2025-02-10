algoritmo "Exercicio63"

Var

   num: real

funcao calcularSerie(num: real): real

var

   resultSerie, i: real

inicio

   resultSerie <- 0
   i <- 1

   enquanto i <= num faca
      resultSerie <- (resultSerie + (1 / i))
      i <- i + 1
   fimenquanto
   
   retorne resultSerie

fimfuncao

Inicio

   escreva("Digite um numero para ser o limite do denominador da serie: ")
   leia(num)
   
   escreva("O resultado da soma da serie e ", calcularSerie(num):5:2)

fimalgoritmo