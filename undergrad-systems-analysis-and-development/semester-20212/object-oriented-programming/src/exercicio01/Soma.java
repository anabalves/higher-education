package exercicio01;

import java.util.Locale;
import java.util.Scanner;

public class Soma {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		double num1, num2, soma;

		System.out.print("Digite o primeiro n�mero: ");
		num1 = scan.nextDouble();

	    System.out.print("Digite o segundo n�mero: ");
	    num2 = scan.nextDouble();

	    soma = num1 + num2;

	    System.out.printf("SOMA = " + soma);

		scan.close();
	}
}