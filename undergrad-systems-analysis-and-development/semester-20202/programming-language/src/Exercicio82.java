import java.util.Random;
import java.util.Scanner;

public class Exercicio82 {

	private static Scanner scan;

	public static void main(String[] args) {

		Random gerador = new Random();
		scan = new Scanner(System.in);

		int valores[] = new int[20];
		int esquerda = 0, direita = valores.length, procurado;

		for (int i = 0; i < valores.length; i++) {
			valores[i] = gerador.nextInt(100) + 1;
		}

		for (int i = 0; i < valores.length; i++) {
			for (int j = 0; j < (valores.length - 1); j++) {
				if (valores[j] > valores[j + 1]) {
					int auxiliar = valores[j];
					valores[j] = valores[j + 1];
					valores[j + 1] = auxiliar;
				}
			}
		}

		System.out.println("O vetor classificado em ordem crescente: ");
		for (int i = 0; i < valores.length; i++) {
			System.out.println("A posicao " + (i + 1) + "� do vetor possui o valor " + valores[i]);
		}

		System.out.print("Digite o numero que ser� procurado no vetor: ");
		procurado = scan.nextInt();

		int resultado = pesquisaBinaria(valores, esquerda, direita - 1, procurado);
		if (resultado == -1)
			System.out.print("Ops :( esse valor nao esta no vetor!");
		else
			System.out.println("O numero " + procurado + " foi encontrado na posicao " + (resultado + 1) + "� do vetor");

	}

	static int pesquisaBinaria(int[] valores, int esquerda, int direita, int procurado) {
		if (direita >= esquerda) {
			int meio = esquerda + (direita - esquerda) / 2;
			if (valores[meio] == procurado)
				return meio;

			if (valores[meio] > procurado)
				return pesquisaBinaria(valores, esquerda, meio - 1, procurado);

			return pesquisaBinaria(valores, meio + 1, direita, procurado);
		}

		return -1;
	}

}