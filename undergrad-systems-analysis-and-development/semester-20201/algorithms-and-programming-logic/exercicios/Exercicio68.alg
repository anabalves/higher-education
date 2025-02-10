algoritmo "Exercicio68"

var

   num, i, maior, menor : inteiro

funcao verificaMaior(num, maior: inteiro): inteiro

inicio

   se num > maior entao
      maior <- num
   fimse

   retorne maior

fimfuncao

funcao verificaMenor(num, menor: inteiro): inteiro

inicio

   se num < menor entao
      menor <- num
   fimse

   retorne menor

fimfuncao

inicio

   escreva("Digite o 1° numero: ")
   leia(num)

   maior <- num
   menor <- num

   para i:=2 ate 100 faca
      escreva("Digite o ", i, "° numero: ")
      leia(num)

      maior <- verificaMaior(num, maior)
      menor <- verificaMenor(num, menor)

   fimpara

   escreval("O maior numero e: ", maior)
   escreva("O menor numero e: ", menor)

fimalgoritmo