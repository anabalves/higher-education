algoritmo "Exercicio71"

procedimento verificarPossibilidades

var

   dado1, dado2: inteiro

inicio

   para dado1 de 1 ate 6 passo 1 faca
      para dado2 de 6 ate 1 passo -1 faca
         se ((dado1 + dado2) = 7)  entao
            escreval(dado1, " + ", dado2, " = ", (dado1 + dado2))
         fimse
      fimpara
   fimpara

fimprocedimento

inicio

		escreval("Possibilidades de 2 dados darem a soma igual a 7: ")
		verificarPossibilidades

Fimalgoritmo