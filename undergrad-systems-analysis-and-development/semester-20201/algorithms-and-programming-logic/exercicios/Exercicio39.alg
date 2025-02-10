algoritmo "Exercicio39"

var

   casa : inteiro
   grao, qtd, total : real

inicio

   total <- 0

   para casa:=1 ate 64 faca
      qtd <- casa - 1
      grao <- Exp(2, qtd)
      total <- total + grao
      escreval("A casa", casa ," possui ", grao ," graos")
   fimpara
   
   escreva("A quantidade de graos contidos em um tabuleiro de xadrez e ", total)

fimalgoritmo