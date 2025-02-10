import java.util.Locale;
import java.util.Scanner;

public class Exercicio50 {

	private static double a, b, c;

	private static void calculaRaizQuadrada() {

		double delta, x1, x2;

		if (a == 0) {
			System.out.println("Nao e uma equacao de 2° grau, A deve ser diferente de 0");
		} else {
			delta = Math.pow(b, 2) - (4 * a * c);
			System.out.println("O valor de delta e: " + delta);
			if (delta > 0) {
				System.out.println("Duas raizes reais: quando delta for maior que zero");

				x1 = (-b + Math.sqrt(delta)) / (2 * a);
				x2 = (-b - Math.sqrt(delta)) / (2 * a);

				System.out.println("Raiz 1 e igual a: " + x1);
				System.out.println("Raiz 2 e igual a: " + x2);
			} else {
				if (delta == 0) {
					System.out.println("Quando delta for igual a zero ha apenas uma unica raiz real");

					x1 = (-b + Math.sqrt(delta)) / (2 * a);

					System.out.println("O Valor da Raiz e: " + x1);
				} else {
					System.out.println("Nenhuma raiz real: quando delta for menor que zero");
				}
			}
		}
	}

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o valor de A: ");
		a = scan.nextDouble();

		System.out.print("Digite o valor de B: ");
		b = scan.nextDouble();

		System.out.print("Digite o valor de C: ");
		c = scan.nextDouble();

		calculaRaizQuadrada();

		scan.close();

	}

}