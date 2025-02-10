algoritmo "Exercicio64"

var

   num, i : inteiro

funcao calcularTabuada(num, i: inteiro): inteiro

var

   resultado : inteiro

inicio

   resultado <- num * i
   retorne resultado

fimfuncao

inicio

   escreva("Digite um numero para calcular a tabuada: ")
   leia(num)

   para i:=0 ate 10 faca
      escreval (num, " x ", i, " = ", calcularTabuada(num, i))
   fimpara

fimalgoritmo