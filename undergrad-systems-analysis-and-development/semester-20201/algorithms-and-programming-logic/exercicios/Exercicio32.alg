algoritmo "Exercicio32"

var

   num, fat, i :inteiro

inicio

   escreva("Digite um numero para calcular seu fatorial: ")
   leia (num)
   
   fat <- 1
   
   para i := 1 ate num faca
        fat <- fat * i
   fimpara
   
   escreval ("O fatorial de ", num, " e ", fat)

fimalgoritmo