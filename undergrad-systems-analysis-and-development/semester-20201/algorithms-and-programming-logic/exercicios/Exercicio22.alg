algoritmo "Exercicio22"

var

   num1, num2 : inteiro

inicio

   Escreva ("Digite o primeiro numero: ")
   Leia (num1)
   Escreva ("Digite o segundo numero: ")
   Leia (num2)
   
   se (num1 = num2) entao
      escreval("Os valores devem ser diferentes")
   senao
      se (num1 < num2) entao
         escreval("Os valores em ordem crescente sao: ", num1, " e ", num2, ".")
      senao
         escreval("Os valores em ordem crescente sao: ", num2," e ", num1, ".")
      fimse
   fimse
   
fimalgoritmo