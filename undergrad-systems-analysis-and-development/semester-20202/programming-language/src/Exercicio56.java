import java.util.Scanner;

public class Exercicio56 {

	private static int num1, num2;

	private static void verificaMultiplo() {

		int maior, menor;

		if (num1 > num2) {
			maior = num1;
			menor = num2;
		} else {
			maior = num2;
			menor = num1;
		}

		if (maior % menor == 0) {
			System.out.print(maior + " e multiplo de " + menor);
		} else {
			System.out.print(maior + " nao e multiplo de " + menor);
		}

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o primeiro numero: ");
		num1 = scan.nextInt();

		System.out.print("Digite o segundo numero: ");
		num2 = scan.nextInt();

		verificaMultiplo();

		scan.close();

	}

}
