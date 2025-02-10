algoritmo "Exercicio05"

var

   a, b, c, delta, x1, x2 : real

inicio

   escreva("Digite o valor de a: ")
   leia(a)
   escreva("Digite o valor de b: ")
   leia(b)
   escreva("Digite o valor de c: ")
   leia(c)
   
   delta <- (Exp(b, 2)) - (4 * a * c)

   escreval("O valor de delta e: ", delta)
   
   x1 <- (-b + raizQ(delta)) / (2 * a)
   x2 <- (-b - raizQ(delta)) / (2 * a)

   escreval("Raiz 1 e igual a: ", x1)
   escreval("Raiz 2 e igual a: ", x2)
   
fimalgoritmo