import java.util.Scanner;

public class Exercicio62 {

	private static Scanner scan;

	private static int calcularFatorial(int num) {

		int fat = 1;

		for (int i = 1; i <= num; i++) {
			fat *= i;
		}

		return fat;
	}

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int num;

		System.out.print("Digite um numero para calcular seu fatorial: ");
		num = scan.nextInt();

		System.out.print("O fatorial de " + num + " e " + calcularFatorial(num));
		
		scan.close();

	}

}