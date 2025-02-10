algoritmo "Exercicio46"

var

   horasTrab, valorHora, desconto, dependentes: inteiro

procedimento calculaSalario

var

   salarioBruto, salarioLiquido, salarioFinal: real

inicio

   salarioBruto <- (horasTrab * valorHora)
   salarioLiquido <- (salarioBruto - ((salarioBruto / 100) * desconto))
   salarioFinal <- salarioLiquido + (100 * dependentes)

   escreval("Seu salario bruto e R$", salarioBruto:5:2)
   escreval("Seu salario liquido e R$", salarioLiquido:5:2)
   escreval("Seu salario final e R$", salarioFinal:5:2)
   
fimprocedimento

inicio

   escreva("Digite as horas trabalhadas: ")
   leia(horasTrab)
   escreva("Digite o valor por hora: ")
   leia(valorHora)
   escreva("Digite o percentual de desconto: ")
   leia(desconto)
   escreva("Digite o numero de dependentes: ")
   leia(dependentes)
   calculaSalario

fimalgoritmo