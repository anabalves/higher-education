algoritmo "Exercicio73"

var

   ana, maria : real

funcao calcularAnos(maria, ana : real):inteiro

var

   anos : inteiro

inicio

   anos <- 0

   enquanto (ana <= maria) faca
      maria <- maria + 0.02
      ana <- ana + 0.03
      anos <- anos + 1
   fimenquanto
   
   retorne anos

fimfuncao

inicio

   maria <- 1.50
   ana <- 1.10

   escreva("Daqui a ", calcularAnos(maria, ana), " anos Ana sera maior que Maria.")

fimalgoritmo