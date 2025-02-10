algoritmo "Exercicio53"

var

   num1, num2, num3, num4: inteiro

procedimento ordemCrescente

inicio

   se (num2 < num1) entao
      escreval("O segundo valor informado e menor que o primeiro! Digite novamente.")
   senao
      se (num3 < num1) ou (num3 < num2) entao
         escreval("O terceiro valor informado e menor que o primeiro e segundo! Digite novamente.")
      senao
         se (num4 < num1) entao
            escreval("Os valores em ordem crescente sao: ", num4, " ", num1, " ", num2, " ", num3)
         senao
            se (num4 < num2) entao
               escreval("Os valores em ordem crescente sao: ", num1, " ", num4, " ", num2, " ", num3)
            senao
               se (num4 < num3) entao
                  escreval("Os valores em ordem crescente sao: ", num1, " ", num2, " ", num4, " ", num3)
               senao
                  escreval("Os valores em ordem crescente sao: ", num1, " ", num2, " ", num3, " ", num4)
               fimse
            fimse
         fimse
      fimse
   fimse

fimprocedimento

inicio

   escreva("Digite o primeiro valor: ")
   leia(num1)
   escreva("Digite o segundo valor: ")
   leia(num2)
   escreva("Digite o terceiro valor: ")
   leia(num3)
   escreva("Digite o quarto valor: ")
   leia(num4)
   ordemCrescente

fimalgoritmo