algoritmo "Exercicio62"

var

   num : inteiro

funcao calcularFatorial(num:inteiro):inteiro

var

   fat, i : inteiro

inicio

   fat <- 1

   para i := 1 ate num faca
        fat <- fat * i
   fimpara
   
   retorne fat

fimfuncao

inicio

   escreva("Digite um numero para calcular seu fatorial: ")
   leia (num)
   
   escreva("O fatorial de ", num, " e ", calcularFatorial(num))

fimalgoritmo