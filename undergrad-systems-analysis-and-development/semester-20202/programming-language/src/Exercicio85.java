public class Exercicio85 {

	public static void main(String[] args) {

		int matriz[][] = new int[8][8];
		int aux = 0;
		String visualizarMatriz = "";

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				matriz[i][j] = (int) Math.pow(2, aux);
				aux += 1;
				visualizarMatriz += matriz[i][j] + "\t";
			}
			visualizarMatriz += "\n";
		}

		System.out.println(visualizarMatriz);
	}

}