algoritmo "semnome"
// Função :
// Autor :
// Data : 26/06/2020
// Seção de Declarações 
var
percM, PercF, mediaI: real
idade, qtdM, qtdF, somaIdade, totalP, maior, menor : inteiro
sexo, pesquisa : caractere
inicio
idade <- 0
totalP <- 0
repita
   limpatela
   totalP <- totalP + 1
   escreval("Digite sua idade: ")
   leia(idade)
   repita
      escreval("Digite seu sexo M/F: ")
      leia(sexo)
      se (sexo <> "M") e (sexo <> "F") entao
         escreval("Sexo incorreto, regedite")
      fimse
   ate (sexo = "M") ou (sexo = "F")
   somaIdade <- somaIdade + idade
   se (sexo = "M") entao
      qtdM <- qtdM + 1
   senao
      se (sexo = "F") entao
         qtdF <- qtdF + 1
      fimSe
   fimSe
   se(idade>maior)entao
      maior <- idade
   senao
      se (idade<menor)entao
         menor <- idade
      fimse
   fimse

   escreval("Deseja fazer mais uma pesquisa? Digite N para não ou S para sim")
   leia(pesquisa)
ate (pesquisa = "N")

mediaI <- somaIdade / totalP

percM <- qtdM/totalP*100
percF <- qtdF/totalP*100

escreval("Total de pessoas pesquisadas   : ", totalP)
escreval("Total de homens pesquisados    : ", qtdM, " (", percM:1, "%)")
escreval("Total de mulheres pesquisadas  : ", qtdF, " (", percF:1, "%)")
escreval("Média de idade dos pesquisados : ", mediaI)
escreval("A idade mais velha encontrada  : ", maior)
escreval("A idade mais nova encontrada   : ", menor)
fimalgoritmo
