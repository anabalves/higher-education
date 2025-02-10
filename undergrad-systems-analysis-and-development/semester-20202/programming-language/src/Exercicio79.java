import java.util.Locale;
import java.util.Scanner;

public class Exercicio79 {

	private static Scanner scan;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		scan = new Scanner(System.in);

		double valores[] = new double[30];
		int quantAcima = 0;
		double media = 0, soma = 0;

		for (int i = 0; i < valores.length; i++) {
			System.out.print("Digite o " + (i + 1) + "� numero para o 1� Vetor: ");
			valores[i] = scan.nextDouble();
			soma += valores[i];
		}

		media = soma / valores.length;
		System.out.println("A media do grupo e " + media);

		for (int i = 0; i < valores.length; i++) {
			if (valores[i] > media) {
				quantAcima += 1;
			} else if (valores[i] < media) {
				System.out.println(
						"O valor  " + valores[i] + " da posicao " + (i + 1) + " esta abaixo da media do grupo");
			}
		}

		System.out.print("A quantidade de notas acima da media do grupo e " + quantAcima);

	}

}