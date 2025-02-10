algoritmo "Exercicio66"

var

   num: real

funcao calcularSerie(num: real): real

var

   resultSerie, fat, i: real

inicio

   resultSerie <- 0
   fat <- 1
   i <- 1

   enquanto (i <= num) faca
      fat <- fat * i
      resultSerie <- (resultSerie + (1 / fat))
      i <- i + 1
   fimenquanto
   
   retorne resultSerie

fimfuncao

Inicio

   escreva("Digite um numero para ser o limite do denominador da serie: ")
   leia (num)
   
   escreva("O resultado da soma da serie e ", calcularSerie(num):5:2)

fimalgoritmo