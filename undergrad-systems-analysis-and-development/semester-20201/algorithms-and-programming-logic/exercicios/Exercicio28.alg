algoritmo "Exercicio28"

var

   precoAtual, vendaMensal, precoNovo: real

inicio

   escreva("Digite o preco atual do produto: ")
   leia(precoAtual)
   escreva("Digite a media mensal de vendas do produto: ")
   leia(vendaMensal)

   se ((precoAtual < 30) e (vendaMensal < 500)) entao
      precoNovo <- (precoAtual + (precoAtual * 0.1))
      escreva("O novo valor do produto e R$", precoNovo)
   senao
      se ((precoAtual >= 30) e (precoAtual < 80)) e ((vendaMensal >= 500) E (vendaMensal < 1000)) entao
         precoNovo <- (precoAtual + (precoAtual * 0.15))
         escreva("o novo valor do produto e R$", precoNovo)
      senao
         se ((precoAtual >= 80) e (vendaMensal >= 1000)) entao
            precoNovo <- (precoAtual - (precoAtual * 0.05))
            escreva("o novo valor do produto e R$", precoNovo)
         senao
            precoNovo <- precoAtual
            escreval ("O valor do produto nao foi alterado, continua sendo R$", precoNovo)
         fimse
      fimse
   fimse

fimalgoritmo