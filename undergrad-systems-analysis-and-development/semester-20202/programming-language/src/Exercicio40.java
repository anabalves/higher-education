import java.util.Scanner;

public class Exercicio40 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int i, x, num1, num2, primo, temPrimo = 0, maior, menor;

		System.out.print("Digite o primeiro numero: ");
		num1 = scan.nextInt();

		System.out.print("Digite o segundo numero: ");
		num2 = scan.nextInt();

		if (num1 >= num2) {
			maior = num1;
			menor = num2;
		} else {
			maior = num2;
			menor = num1;
		}

		System.out.print("Numeros Primos encontrados no intervalo: ");
		for (i = menor; i <= maior; i++) {
			primo = 0;

			for (x = 1; x <= i; x++) {
				if (i % x == 0) {
					primo += 1;
				}
			}

			if (primo == 2) {
				System.out.print(i + " ");
				temPrimo = 1;
			}
		}

		if (temPrimo == 0) {
			System.out.print("Nao possui primos no intervalo");
		}
		
		scan.close();

	}

}