algoritmo "Exercicio49"

var

   num1, num2 : real

procedimento calculaMaior

inicio

   se (num1 >= num2) entao
      se (num1 > num2) entao
         escreva("O maior valor e  ", num1)
      senao
         escreva("Os valores sao iguais")
      fimse
   senao
      escreva("O maior valor e  ", num2)
   fimse

fimprocedimento

inicio

   escreva("Digite o primeiro numero: ")
   leia(num1)
   escreva("Digite o segundo numero: ")
   leia(num2)
   calculaMaior

fimalgoritmo