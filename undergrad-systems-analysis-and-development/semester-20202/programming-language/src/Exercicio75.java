import java.util.Locale;

public class Exercicio75 {

	private static double calcularSerie() {
		
		double soma = 0, numerador;

		for (numerador = 1; numerador <= 15; numerador++) {
			if (numerador % 2 == 0) {
				soma -= (numerador / (numerador * numerador));
			} else {
				soma += (numerador / (numerador * numerador));
			}
		}
		
		return soma;
	}
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);

		System.out.printf("O resultado da soma da serie e %.2f", calcularSerie());

	}

}