algoritmo "Exercicio15"

var

   catetoOposto, catetoAdjacente, hipotenusa : real

inicio

   escreva("Digite o valor do cateto adjacente: ")
   leia(catetoAdjacente)
   escreva("Digite o valor do cateto oposto: ")
   leia(catetoOposto)

   hipotenusa <- RaizQ(Exp(catetoAdjacente, 2) + Exp(catetoOposto, 2))

   escreva("O valor da hipotenusa e: ", hipotenusa:5:2)

fimalgoritmo