import java.util.Scanner;

public class Exercicio65 {

	private static Scanner scan;
	
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

	private static int calcularSoma(int maior, int menor) {
		int somaImpares = 0;

		System.out.print("Numeros Impares encontrados: ");
		for (int i = menor; i <= maior; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
				somaImpares += i;
			}
		}
		System.out.println();
		return somaImpares;
	}
	

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int num1, num2;

		System.out.print("Digite o primeiro numero: ");
		num1 = scan.nextInt();

		System.out.print("Digite o segundo numero: ");
		num2 = scan.nextInt();

		System.out.print("A soma dos numeros impares e "
				+ calcularSoma(verificaMaior(num1, num2), verificaMenor(num1, num2)));

		scan.close();
	}

}
