import java.util.Locale;
import java.util.Scanner;

public class Exercicio77 {

	private static Scanner scan;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		scan = new Scanner(System.in);

		int valores[] = new int[100];
		double media = 0;
		int maior = 0, menor = 0, soma = 0, quant = 0;

		for (int i = 0; i < valores.length; i++) {
			System.out.print("Digite o " + (i + 1) + "º numero: ");
			valores[i] = scan.nextInt();

			if (i == 0) {
				maior = valores[i];
				menor = valores[i];
			}

			else if (valores[i] > maior) {
				maior = valores[i];
			}

			else if (valores[i] < menor) {
				menor = valores[i];
			}

			soma += valores[i];
			quant += 1;

		}

		scan.close();

		media = soma / quant;

		System.out.println("O maior valor do vetor e " + maior);
		System.out.println("O menor valor do vetor e " + menor);
		System.out.printf("A media dos valores do vetor e %.2f", media);

	}

}