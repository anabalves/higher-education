import java.util.Scanner;

public class Exercicio32 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int num, fat = 1;

		System.out.print("Digite um numero para calcular seu fatorial: ");
		num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
			fat *= i;
		}

		System.out.print("O fatorial de " + num + " e " + fat);
		
		scan.close();

	}

}