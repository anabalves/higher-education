algoritmo "Exercicio52"

var

   num1, num2: inteiro

procedimento ordemCrescente

inicio

   se (num1 = num2) entao
      escreval("Os valores devem ser diferentes")
   senao
      se (num1 < num2) entao
         escreval("Os valores em ordem crescente sao: ", num1, " e ", num2)
      senao
         escreval("Os valores em ordem crescente sao: ", num2, " e ", num1)
      fimse
   fimse

fimprocedimento

inicio

   escreva("Digite o primeiro numero: ")
   leia(num1)
   escreva("Digite o segundo numero: ")
   leia(num2)
   ordemCrescente

fimalgoritmo