import java.util.Scanner;

public class Exercicio70 {

	private static void verificaPrimos(int maior, int menor) {

		int x, primo, temPrimo = 0;

		System.out.print("Numeros Primos encontrados no intervalo: ");
		for (int i = menor; i <= maior; i++) {
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

	}

	private static int verificaMaior(int num1, int num2) {

		int maior;

		if (num1 >= num2) {
			maior = num1;
			return maior;
		} else {
			maior = num2;
			return maior;
		}

	}

	private static int verificaMenor(int num1, int num2) {

		int menor;

		if (num1 >= num2) {
			menor = num2;
			return menor;
		} else {
			menor = num1;
			return menor;
		}

	}

	
	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int num1, num2;

		System.out.print("Digite o primeiro numero: ");
		num1 = scan.nextInt();

		System.out.print("Digite o segundo numero: ");
		num2 = scan.nextInt();

		verificaPrimos(verificaMaior(num1, num2), verificaMenor(num1, num2));
		
		scan.close();

	}
	
}