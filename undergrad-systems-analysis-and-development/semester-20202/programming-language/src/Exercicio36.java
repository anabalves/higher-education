import java.util.Locale;
import java.util.Scanner;

public class Exercicio36 {

	private static Scanner scan;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		scan = new Scanner(System.in);

		double i, num, resultSerie = 0, fat = 1;

		System.out.print("Digite um numero para ser o limite do denominador da serie: ");
		num = scan.nextInt();

		for (i = 1; i <= num; i++) {
			fat *= i;
			resultSerie += (1 / fat);
		}
		
		System.out.printf("O resultado da soma da serie e %.2f", resultSerie);
		
		scan.close();

	}

}