algoritmo "Exercicio67"

var

   num, i : inteiro

funcao calcularFibonacci(num: inteiro): inteiro

var

   a, b, aux: inteiro

inicio

   a <- 0
   b <- 1
   
   para i:=0 ate num faca
      aux <- a
      a <- a + b
      b <- aux
   fimpara
   
   retorne a

fimfuncao

Inicio

   num <- 0

   enquanto num = 0 faca
      escreva("Digite um numero para ser o limite da sequencia de Fibonacci: ")
      leia(num)
   fimenquanto

   para i:=0 ate num faca
      escreva(calcularFibonacci(i), " ")
   fimpara

fimalgoritmo