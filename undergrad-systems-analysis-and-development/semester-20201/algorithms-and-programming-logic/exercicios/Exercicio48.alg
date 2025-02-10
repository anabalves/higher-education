algoritmo "Exercicio48"

var

   num1, num2 : inteiro

procedimento calculaDiferenca

var

   diferenca : inteiro

inicio

   se (num1 >= num2) entao
      diferenca <- (num1 - num2)
   senao
      diferenca <- (num2 - num1)
   fimse
   
   escreva("A diferenca entre o maior valor pelo menor e: ", diferenca)

fimprocedimento

inicio

   escreva("Digite o primeiro valor: ")
   leia(num1)
   escreva("Digite o segundo valor: ")
   leia(num2)
   calculaDiferenca

fimalgoritmo