algoritmo "Exercicio65"

var

   num1, num2: inteiro

funcao verificaMaior(num1, num2 : inteiro): inteiro

var

   maior: inteiro

inicio

   se (num1 >= num2) entao
      maior <- num1
      retorne maior
   senao
      maior <- num2
      retorne maior
   fimse

fimfuncao

funcao verificaMenor(num1, num2 : inteiro): inteiro

var

   menor: inteiro

inicio

   se (num1 >= num2) entao
      menor <- num2
      retorne menor
   senao
      menor <- num1
      retorne menor
   fimse

fimfuncao

funcao calcularSoma(maior, menor: inteiro): inteiro

var

   somaImpares, i : inteiro

inicio

   somaimpares <- 0

   escreva("Numeros Impares encontrados: ")
   para i de menor ate maior faca
      Se (i Mod 2 <> 0) entao
         escreva(i, " ")
         somaimpares <- somaimpares + i
      fimse
   fimpara
   escreval
   retorne somaimpares

fimfuncao

inicio

   escreva("Digite o primeiro numero: ")
   leia (num1)
   escreva("Digite o segundo numero: ")
   leia (num2)

   escreva("A soma dos numeros impares e ", calcularSoma(verificaMaior(num1, num2), verificaMenor(num1, num2)))

fimalgoritmo