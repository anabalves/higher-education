algoritmo "Exercicio12"

var

   anoNascimento, anoAtual, idade, idadeFutura : inteiro

inicio

   escreva("Digite o ano de seu nascimento: ")
   leia(anoNascimento)
   escreva("Digite o ano atual: ")
   leia(anoAtual)

   idade <- anoAtual - anoNascimento
   idadeFutura <- idade + 17

   escreval("Sua idade e: ", idade, " anos")
   escreva("Daqui 17 anos sua idade sera: ", idadeFutura, " anos")

fimalgoritmo