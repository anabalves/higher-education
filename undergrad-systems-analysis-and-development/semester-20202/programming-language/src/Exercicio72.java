import java.util.Locale;

public class Exercicio72 {

	private static double calcularSerie() {

		double soma = 0, denominador = 1;
		int numerador;

		for (numerador = 1; numerador <= 50; numerador++) {
			soma = soma + (numerador / denominador);
			denominador = denominador + 2;
		}

		return soma;

	}
	
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		System.out.printf("O resultado da serie e %.2f", calcularSerie());

	}

}
