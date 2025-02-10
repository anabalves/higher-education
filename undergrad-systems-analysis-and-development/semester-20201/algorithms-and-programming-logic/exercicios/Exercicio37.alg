algoritmo "Exercicio37"

var

   i, a, b, aux, num : inteiro

inicio

   a <- 0
   b <- 1
   num <- 0

   enquanto num = 0 faca
      escreva("Digite um numero para ser o limite da sequencia de Fibonacci: ")
      leia(num)
   fimenquanto

   para i:=1 ate num faca
      escreva(a, " ")
      aux <- a
      a <- a + b
      b <- aux
   fimpara

fimalgoritmo