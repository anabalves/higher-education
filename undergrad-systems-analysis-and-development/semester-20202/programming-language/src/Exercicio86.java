public class Exercicio86 {

	public static void main(String[] args) {

		int matriz[][] = new int[8][8];

		for (int k = 0; k < 4; k++) {
			for (int i = k; i < (8 - k); i++) {
				for (int j = k; j < (8 - k); j++) {
					matriz[i][j] = k + 1;
				}
			}
		}

		String visualizarMatriz = "";

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				visualizarMatriz += matriz[i][j] + "\t";
			}
			visualizarMatriz += "\n";
		}

		System.out.println(visualizarMatriz);
	}
}