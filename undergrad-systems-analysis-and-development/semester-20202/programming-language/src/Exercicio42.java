import java.util.Locale;

public class Exercicio42 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		double soma = 0, denominador = 1;
		int numerador;

		for (numerador = 1; numerador <= 50; numerador++) {
			soma += (numerador / denominador);
			denominador += 2;
		}

		System.out.printf("O resultado da serie e %.2f", soma);

	}

}