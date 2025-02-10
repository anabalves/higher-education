algoritmo "Exercicio74"

var

   base, expoente : inteiro

funcao calcularPotencia(base, expoente: inteiro): real

var

   resultado : real

inicio

   resultado <- Exp(base, expoente)
   
   retorne resultado

fimfuncao

inicio

   escreva ("Digite o valor da base: ")
   leia (base)
   escreva ("Digite o valor do expoente: ")
   leia (expoente)

   escreva(base, " ^ ", expoente," = ", calcularPotencia(base, expoente))

fimalgoritmo