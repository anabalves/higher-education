algoritmo "Exercicio17"

var

   velocidade, tempoTotal, litrosGastos, distanciaPercorrida: real

inicio

   escreval("Informe o tempo total que voce gastou no percurso (minutos / 60 = horas): ")
   leia(tempoTotal)
   escreval("Informe a velocidade media durante a viagem: ")
   leia(velocidade)

   distanciaPercorrida <- velocidade * tempoTotal
   litrosGastos <- distanciaPercorrida / 12

   escreval("Foram gastos ", litrosGastos:5:2, " litros")
   escreval("A distancia percorrida foi de ", distanciaPercorrida:5:2, " Km")

fimalgoritmo