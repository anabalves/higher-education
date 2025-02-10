import java.util.Locale;
import java.util.Scanner;

public class Exercicio76 {

	private static Scanner scan;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		scan = new Scanner(System.in);

		int valores[] = new int[50];
		double media = 0;
		int somaImpares = 0, soma = 0, quant = 0;

		for (int i = 0; i < valores.length; i++) {
			System.out.print("Digite o " + (i + 1) + "º numero: ");
			valores[i] = scan.nextInt();

			if ((valores[i] >= 10) & (valores[i] <= 200)) {
				soma += valores[i];
				quant += 1;
			}

			if (valores[i] % 2 != 0) {
				somaImpares += valores[i];
			}

		}

		scan.close();

		if (quant != 0) {
			media = soma / quant;
			System.out.printf("A media dos valores entre 10 e 200 e igual a %.2f\n", media);
		} else {
			System.out.println("Nao ha valores entre 10 e 200");
		}
		
		System.out.print("A soma dos numeros impares e igual a " + somaImpares);

	}

}