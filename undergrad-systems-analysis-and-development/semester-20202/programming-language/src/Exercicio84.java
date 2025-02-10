import java.util.Locale;
import java.util.Scanner;

public class Exercicio84 {

	private static Scanner scan;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		scan = new Scanner(System.in);

		int matriz[][] = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == j) {
					matriz[i][j] = (int) Math.pow(4, i);
				} else {
					System.out.print("Digite um numero para a " + (i + 1) + "° linha da " +  (j + 1) +  "ï¿½ coluna: ");
					matriz[i][j] = scan.nextInt();
				}
			}
		}

		String visualizarMatriz = "";

		for (int linha = 0; linha < 4; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				visualizarMatriz += matriz[linha][coluna] + "\t";
			}
			visualizarMatriz += "\n";
		}

		System.out.println(visualizarMatriz);
	}

}