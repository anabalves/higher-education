algoritmo "Exercicio70"

var

   num1, num2 : inteiro

procedimento verificaPrimo(maior, menor: inteiro)

var

   i, x, primo, temPrimo : inteiro

inicio

   escreva("Numeros Primos encontrados no intervalo: ")

   para i:= menor ate maior faca
      primo <- 0

      para x := 1 ate i faca
         se (i Mod x = 0) entao
            primo <- primo + 1
         fimse
      fimpara

      se primo = 2 entao
         escreva(i, " ")
         temPrimo <- 1
      fimse
   fimpara

   se temPrimo = 0 entao
      escreva("Nao possui primos no intervalo")
   fimse

fimprocedimento

funcao verificaMaior(num1, num2: inteiro): inteiro

var

   maior : inteiro

inicio

   se (num1 >= num2) entao
      maior <- num1
      retorne maior
   senao
      maior <- num2
      retorne maior
   fimse

fimfuncao

funcao verificaMenor(num1, num2 : inteiro): inteiro

var

   menor : inteiro

inicio

   se (num1 >= num2) entao
      menor <- num2
      retorne menor
   senao
      menor <- num1
      retorne menor
   fimse


fimfuncao

inicio

   escreva ("Digite o primeiro numero: ")
   leia (num1)
   escreva ("Digite o segundo numero: ")
   leia (num2)

   verificaPrimo(verificaMaior(num1, num2), verificaMenor(num1, num2))

fimalgoritmo