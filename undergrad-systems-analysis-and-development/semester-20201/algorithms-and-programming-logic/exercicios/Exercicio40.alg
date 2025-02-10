algoritmo "Exercicio40"

var

   i, x, num1, num2, primo, temPrimo, maior, menor : inteiro

inicio

   escreva ("Digite o primeiro numero: ")
   leia (num1)
   escreva ("Digite o segundo numero: ")
   leia (num2)

   se (num1 >= num2) entao
      maior <- num1
      menor <- num2
   senao
      maior <- num2
      menor <- num1
   fimse
   
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

fimalgoritmo