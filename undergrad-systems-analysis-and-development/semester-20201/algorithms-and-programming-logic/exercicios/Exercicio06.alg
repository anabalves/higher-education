algoritmo "Exercicio06"

var

   X, Y, troca : real

inicio

   escreva("Digite X: ")
   leia(X)
   escreva("Digite Y: ")
   leia(Y)

   troca <- X
   X <- Y
   Y <- troca

   escreval("O valor de X e: ", X)
   escreval("O valor de Y e: ", Y)

fimalgoritmo