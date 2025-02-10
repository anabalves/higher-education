algoritmo "Exercicio33"

var

   num, resultSerie : real
   i : inteiro

inicio

   escreva("Digite um numero para ser o limite do denominador da serie: ")
   leia (num)

   resultSerie <- 0
   i <- 1

   enquanto i <= num faca
      resultSerie <- (resultSerie + (1 / i))
      i <- i + 1
   fimenquanto

   escreva("O resultado da soma da serie e ", resultSerie:5:2)

fimalgoritmo