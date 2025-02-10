algoritmo "Exercicio69"

var

   casa : inteiro
   grao, qtd, total : real

funcao  calcularGraos(grao, qtd : real): real

inicio

   grao <- exp(2,qtd)

   retorne grao

fimfuncao

funcao  calcularGraosTotal(grao, total: real): real

inicio

   total <- total + grao

   retorne total

fimfuncao


inicio

   total <- 0

   para casa:=1 ate 64 faca
      qtd <- casa - 1
      grao <- calcularGraos(grao, qtd)
      total <- calcularGraosTotal(grao, total)
      escreval("A casa", casa ," possui ", grao ," graos")
   fimpara

   escreva("A quantidade de graos contidos em um tabuleiro de xadrez e ", total)

fimalgoritmo