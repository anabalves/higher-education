algoritmo "Exercicio30"

var

   anoNasc, anoAtual, ano, mesNasc, mesAtual, mes, diaNasc, diaAtual, dia :inteiro

inicio

   escreva("Digite o dia de nascimento: ")
   leia (diaNasc)
   escreva("Digite o mes de nascimento: ")
   leia (mesNasc)
   escreva("Digite o ano de nascimento: ")
   leia (anoNasc)

   escreva("Digite o dia atual: ")
   leia (diaAtual)
   escreva("Digite o mes atual: ")
   leia (mesAtual)
   escreva("Digite o ano atual: ")
   leia (anoAtual)

   para ano de anoNasc ate anoAtual faca
      se ((ano % 4 = 0) e (ano % 100 <> 0) ou (ano % 400 = 0)) entao
         diaAtual <- diaAtual + 1
      fimse
   fimpara

   se (diaAtual < diaNasc) entao
      diaAtual <- diaAtual + 30
      mesAtual <- mesAtual - 1
   senao
      se (diaAtual > 30) entao
         diaAtual <- diaAtual - 30
         mesAtual <- mesAtual + 1
      fimse
   fimse

   se (mesAtual < mesNasc) entao
      mesAtual <- mesAtual + 12
      anoAtual <- anoAtual - 1
   fimse
   
   dia <- (diaAtual - diaNasc)
   mes <- (mesAtual - mesNasc)
   ano <- (anoAtual - anoNasc)

   escreva(ano, " anos,", mes, " meses e", dia, " dias.")

fimalgoritmo