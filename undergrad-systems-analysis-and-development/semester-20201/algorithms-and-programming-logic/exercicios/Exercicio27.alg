algoritmo "Exercicio27"

var

   numVoltas, tamCircuito, tempMinutos, velocMediaMs, velocMediaKmh : real

inicio

   escreva("Digite o numero de voltas no circuito: ")
   leia(numVoltas)
   escreva("Digite o tamanho do cicuito em metros: ")
   leia(tamCircuito)
   escreva("Digite o tempo de duracao em minutos: ")
   leia(tempMinutos)
   
   velocMediaMs <-((numVoltas * tamCircuito) / (tempMinutos * 60))
   velocMediaKmh <- velocMediaMs * 3.6
   
   escreva("A velocidade media percorrida no trajeto foi de ", velocMediaKmh, "km/h")

fimalgoritmo