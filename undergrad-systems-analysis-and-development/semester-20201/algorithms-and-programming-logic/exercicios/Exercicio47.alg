algoritmo "Exercicio47"

var

   tempo, velocidade: real
   
procedimento calculaLitrosDistancia

var

   litrosGastos, distanciaPercorrida: real

inicio

   distanciaPercorrida <- (velocidade * tempoReal)
   litrosGastos <- (distanciaPercorrida / 12)

   escreval("Foram gastos ", litrosGastos:5:2, " litros")
   escreval("A distancia percorrida foi de ", distanciaPercorrida:5:2, " Km")

fimprocedimento

inicio

   escreva("Informe o tempo total que voce gastou no percurso (minutos / 60 = horas): ")
   leia(tempo)
   escreva("Informe a velocidade media durante a viagem: ")
   leia(velocidade)
   calculaLitrosDistancia

fimalgoritmo