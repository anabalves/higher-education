algoritmo "Exercicio59"

var

   tipoInv : inteiro
   valor : real

procedimento calcularValorRendimento

var

   valorRend: real

inicio

   se (tipoInv = 1) entao
      escreval("Investimento em poupanca")
      valorRend <- (valor + (valor * 0.03))
      escreva("O valor corrigido em 30 dias e de ", valorRend:6:2, " reais.")
   senao
      escreval("Investimento em renda fixa")
      valorRend <- (valor + (valor * 0.05))
      escreva("O valor corrigido em 30 dias e de ", valorRend:6:2, " reais.")
   fimse

fimprocedimento

inicio

   enquanto ((tipoInv <> 1) e (tipoInv <> 2)) faca
      escreval("Digite o tipo de investimento 1 = poupanca e 2 = renda fixa")
      leia (tipoInv)
   fimenquanto

   escreval ("Digite o valor do investimento: ")
   leia (valor)
   
   calcularValorRendimento

fimalgoritmo