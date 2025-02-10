algoritmo "Exercicio43"

var

   ana, maria : real
   anos : inteiro

inicio

   maria <- 1.50
   ana <- 1.10
   anos <- 0

   enquanto (ana <= maria) faca
      maria <- maria + 0.02
      ana <- ana + 0.03
      anos <- anos + 1
   fimenquanto

   escreva("Daqui a", anos, " anos Ana sera maior que Maria.")

fimalgoritmo