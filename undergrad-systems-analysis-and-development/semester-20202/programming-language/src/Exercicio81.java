import java.util.Scanner;

public class Exercicio81 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int valores[] = new int[20];

		for (int i = 0; i < valores.length; i++) {
			System.out.print("Digite o " + (i + 1) + "� numero para o 1� Vetor: ");
			valores[i] = scan.nextInt();
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
			System.out.println("A posicao " + (i+1) + " do vetor possui o valor " + valores[i]);
		}

	}

}