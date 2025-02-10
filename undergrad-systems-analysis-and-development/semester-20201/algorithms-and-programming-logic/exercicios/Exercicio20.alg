algoritmo "Exercicio20"

var

   a, b, c, delta, x1, x2 : real

inicio

   escreva("Digite o valor de A: ")
   leia(a)
   escreva("Digite o valor de B: ")
   leia(b)
   escreva("Digite o valor de C: ")
   leia(c)

   se (a = 0) entao
      escreval("Nao e uma equacao de 2° grau, A deve ser diferente de 0")
   senao
      delta <- Exp(b, 2) - (4 * a * c)
      escreval("O valor de delta e: ", delta)
      se (delta > 0) entao
         escreval("Duas raizes reais: quando delta for maior que zero.")
         x1 <- (-b + RaizQ(delta)) / (2 * a)
         x2 <- (-b - RaizQ(delta)) / (2 * a)
         escreval("Raiz 1 e igual a: ", x1)
         escreval("Raiz 2 e igual a: ", x2)
      senao
         se (delta = 0) entao
            escreval("Quando delta for igual a zero ha apenas uma unica raiz real.")
            x1 <- (-b + RaizQ(delta)) / (2 * a)
            escreval("O Valor da Raiz e " , x1)
         senao
            escreval("Nenhuma raiz real: quando delta for menor que zero.")
         fimse
      fimse
   fimse

fimalgoritmo