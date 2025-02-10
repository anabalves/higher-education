import java.util.Scanner;

public class Exercicio38 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int num, i, maior, menor;

		System.out.print("Digite o 1° numero: ");
		num = scan.nextInt();

		maior = num;
		menor = num;

		for (i = 2; i <= 100; i++) {
			System.out.print("Digite o " + i + "° numero: ");
			num = scan.nextInt();
			if (num > maior) {
				maior = num;
			}

			if (num < menor) {
				menor = num;
			}
		}

		System.out.print("O maior numero e: " + maior + "\nO menor numero e: " + menor);

		scan.close();
		
	}

}