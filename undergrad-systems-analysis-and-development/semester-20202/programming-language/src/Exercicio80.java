import java.util.Scanner;

public class Exercicio80 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int A[] = new int[20];
		int soma = 0;

		for (int i = 0; i < A.length; i++) {
			System.out.print("Digite o " + (i + 1) + "� numero: ");
			A[i] = scan.nextInt();
		}

		for (int i = 0; i < (A.length / 2); i++) {
			soma += (A[i] - A[A.length - (i + 1)]);
		}

		System.out.print("A soma da equacao e igual a " + soma);

	}

}