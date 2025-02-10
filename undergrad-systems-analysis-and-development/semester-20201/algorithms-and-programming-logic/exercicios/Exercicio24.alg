algoritmo "Exercicio24"

var

   num : inteiro

inicio

   escreva("Digite um numero: ")
   leia(num)
   
   se ((num Mod 2 = 0) E (num Mod 3 = 0)) entao
         escreva(num, " e divisivel por 2 e 3")
   senao
       se (num Mod 2 = 0) entao
          escreval(num, " e divisivel por 2")
       senao
            se (num Mod 3 = 0) entao
                 escreval(num, " e divisivel por 3")
            senao
                 escreval(num, " nao e divisivel por 2 e nem por 3")
            fimse
       fimse
   fimse

fimalgoritmo