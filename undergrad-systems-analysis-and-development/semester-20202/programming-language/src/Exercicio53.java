import java.util.Scanner;

public class Exercicio53 {

	private static double num1, num2, num3, num4;

	private static void ordemCrescente() {

		if (num2 < num1) {
			System.err.println("O segundo valor informado e menor que o primeiro! Digite novamente.");
		} else if (num3 < num1 || num3 < num2) {
			System.err.println("O terceiro valor informado e menor que o primeiro e segundo! Digite novamente.");
		} else {
			if (num4 < num1) {
				System.out.println("Os valores em ordem crescente sao: " + num4 + " " + num1 + " " + num2 + " " + num3);
			} else if (num4 < num2) {
				System.out.println("Os valores em ordem crescente sao: " + num1 + " " + num4 + " " + num2 + " " + num3);
			} else if (num4 < num3) {
				System.out.println("Os valores em ordem crescente sao: " + num1 + " " + num2 + " " + num4 + " " + num3);
			} else {
				System.out.println("Os valores em ordem crescente sao: " + num1 + " " + num2 + " " + num3 + " " + num4);
			}
		}

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o primeiro valor: ");
		num1 = scan.nextDouble();

		System.out.print("Digite o segundo valor: ");
		num2 = scan.nextDouble();

		System.out.print("Digite o terceiro valor: ");
		num3 = scan.nextDouble();

		System.out.print("Digite o quarto valor: ");
		num4 = scan.nextDouble();

		ordemCrescente();

		scan.close();

	}
}