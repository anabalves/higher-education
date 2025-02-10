import java.util.Locale;
import java.util.Scanner;

public class Exercicio33 {

	private static Scanner scan;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		scan = new Scanner(System.in);

		double i, num, resultSerie = 0;

		System.out.print("Digite um numero para ser o limite do denominador da serie: ");
		num = scan.nextInt();

		for (i = 1; i <= num; i++) {
			resultSerie += (1 / i);
		}
		
		System.out.printf("O resultado da soma da serie e %.2f", resultSerie);
		
		scan.close();

	}

}