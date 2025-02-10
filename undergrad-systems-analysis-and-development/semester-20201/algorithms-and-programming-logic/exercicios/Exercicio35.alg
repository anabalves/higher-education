algoritmo "Exercicio35"

var

   i, num1, num2, maior, menor, somaImpares: inteiro

inicio

   escreva("Digite o primeiro numero: ")
   leia (num1)
   escreva("Digite o segundo numero: ")
   leia (num2)

   se (num1 >= num2) entao
      maior <- num1
      menor <- num2
   senao
      maior <- num2
      menor <- num1
   fimse
   
   somaimpares <- 0
   
   escreva("Numeros Impares encontrados: ")
   para i de menor ate maior faca
      Se (i Mod 2 <> 0) entao
         escreva(i, " ")
         somaimpares <- somaimpares + i
      fimse
   fimpara
   
   escreval
   escreva("A soma dos numeros impares e ", somaimpares)

fimalgoritmo