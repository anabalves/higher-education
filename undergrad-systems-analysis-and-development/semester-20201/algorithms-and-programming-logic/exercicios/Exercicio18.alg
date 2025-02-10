algoritmo "Exercicio18"

var

   num1, num2, diferenca : INTEIRO

inicio

   escreval("Digite o primeiro valor: ")
   Leia (num1)
   escreval("Digite o segundo valor: ")
   Leia (num2)

   se (num1 >= num2) entao
      diferenca <- (num1 - num2)
   senao
      diferenca <- (num2 - num1)
   fimse

   escreval("A diferenca entre o maior valor pelo menor e: ", diferenca)

fimalgoritmo