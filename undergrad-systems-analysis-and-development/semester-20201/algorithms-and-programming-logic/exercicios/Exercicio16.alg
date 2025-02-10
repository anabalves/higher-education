algoritmo "Exercicio16"

var

   dependentes : inteiro
   horasTrab, valorHora, desconto, salarioBruto, salarioLiquido, salarioFinal: real

inicio

   escreval("Digite as horas trabalhadas: ")
   Leia (horasTrab)
   escreval("Digite o valor por hora: ")
   Leia (valorHora)
   escreval("Digite o percentual de desconto: ")
   Leia (desconto)
   escreval("Digite o numero de dependentes: ")
   Leia (dependentes)
   
   salarioBruto <- (horasTrab * valorHora)
   salarioLiquido <- salarioBruto - ((salarioBruto/100) * desconto)
   salarioFinal <- salarioLiquido + (100 * dependentes)

   escreval("Seu salario bruto e R$", salarioBruto:6:2)
   escreval("Seu salario liquido e R$", salarioLiquido:6:2)
   escreval("Seu salario Final e R$", salarioFinal:6:2)
   
fimalgoritmo