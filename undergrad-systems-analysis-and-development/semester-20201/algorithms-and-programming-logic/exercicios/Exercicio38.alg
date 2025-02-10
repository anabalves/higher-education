algoritmo "Exercicio38"

var

   num, i, maior, menor : inteiro

inicio

   escreva("Digite o 1° numero: ")
   leia(num)

   maior <- num
   menor <- num

   para i:=2 ate 100 faca
      escreva("Digite o ", i, "° numero: ")
      leia(num)
      se num > maior entao
         maior <- num
      fimse

      se num < menor entao
         menor <- num
      fimse
   fimpara
   
   escreval("O maior numero e: ", maior)
   escreva("O menor numero e: ", menor)
   
fimalgoritmo