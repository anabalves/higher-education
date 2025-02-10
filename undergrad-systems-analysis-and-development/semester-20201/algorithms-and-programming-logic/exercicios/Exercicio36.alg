algoritmo "Exercicio36"

var

   i, num, resultSerie, fat : real
   
Inicio

   escreva ("Digite um numero para ser o limite do denominador da serie: ")
   leia (num)

   resultSerie <- 0
   fat <- 1
   i <- 1

   enquanto (i <= num) faca
      fat <- fat * i
      resultSerie <- (resultSerie + (1 / fat))
      i <- i + 1
   fimenquanto

   escreva("O resultado da soma da serie e ", resultSerie:5:2)

fimalgoritmo