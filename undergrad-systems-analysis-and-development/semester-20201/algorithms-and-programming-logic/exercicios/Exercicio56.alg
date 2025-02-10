algoritmo "Exercicio56"

var

   num1, num2 : inteiro

procedimento verificaMultiplo

var

   maior, menor : inteiro

inicio

   se (num1 > num2) entao
      maior <- num1
      menor <- num2
   senao
      maior <- num2
      menor <- num1
   fimse

   se (maior Mod menor = 0) entao
      escreva(maior, " e multiplo de ", menor)
   senao
      escreva(maior, " nao e multiplo de ", menor)
   fimse

fimprocedimento

inicio

   escreva("Digite o primeiro numero: ")
   leia(num1)
   escreva("Digite o segundo numero: ")
   leia(num2)
   verificaMultiplo

fimalgoritmo