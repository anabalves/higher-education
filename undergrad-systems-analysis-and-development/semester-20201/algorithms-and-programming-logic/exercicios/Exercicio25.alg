algoritmo "Exercicio25"

var

   horaInicial, horaFinal, minInicial, minFinal, horaTotal, minTotal : inteiro

inicio

   escreva("Digite a hora inicial do jogo: ")
   leia(horaInicial)
   escreva("Digite o minuto inicial do jogo: ")
   leia(minInicial)
   escreva("Digite a hora final do jogo: ")
   leia(horaFinal)
   escreva("Digite o minuto final do jogo: ")
   leia(minFinal)
   
   horaTotal <- 0
   minTotal <- 0
   
   se (horaFinal >= horaInicial) entao
      horaTotal <-(horaFinal + horaInicial)
   senao
      horaTotal <- ((horaFinal - horaInicial) + 24)
   fimse
   
   se (minFinal >= minInicial) entao
      minTotal <- (minFinal + minInicial)
   senao
      minTotal <- ((minFinal - minInicial) + 60)
      horaTotal <- (horaTotal - 1)
   fimse
   
   se ((horaInicial < 0) ou (horaFinal < 0) ou (horaInicial > 23) ou (horaFinal > 23) ou (minInicial < 0) ou (minFinal < 0) ou (minInicial > 59) ou (minFinal > 59)) entao
      escreva("Por favor informe valores dentro dos parametros: horas de 0 ate 23 e minutos de 0 ate 59")
   senao
      escreva("A duracao do jogo foi de: ", horaTotal, ":", minTotal)
   fimse

fimalgoritmo