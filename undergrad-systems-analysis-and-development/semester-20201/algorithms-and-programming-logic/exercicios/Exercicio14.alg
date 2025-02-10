algoritmo "Exercicio14"

var

   angulo1, angulo2, angulo3 : real

inicio

   escreva("Digite o valor do primeiro angulo: ")
   leia(angulo1)
   escreva("Digite o valor do segundo angulo: ")
   leia(angulo2)

   angulo3 <- 180 - (angulo1 + angulo2)
   
   escreva("O valor do terceiro angulo e: ", angulo3, "°")
   
fimalgoritmo