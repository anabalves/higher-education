algoritmo "Exercicio21"

var

   nota1, nota2, nota3, nota4, media: real

inicio

   escreva("Digite a primeira nota: ")
   leia(nota1)
   escreva("Digite a segunda nota: ")
   leia(nota2)
   escreva("Digite a terceira nota: ")
   leia(nota3)
   escreva("Digite a quarta nota: ")
   leia(nota4)
   
   media <- (nota1 + nota2 + nota3 + nota4) / 4
   escreval("A media e: ", media)
   
   se (media < 3) entao
      escreval("Aluno Retido")
   senao
        se (media >= 6) entao
           escreval("Aluno Aprovado")
        senao
           escreval("Aluno Exame")
        fimse
   fimse
   
fimalgoritmo