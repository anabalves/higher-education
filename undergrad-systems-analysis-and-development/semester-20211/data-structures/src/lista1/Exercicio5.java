package lista1;

import javax.swing.JOptionPane;

public class Exercicio5 {

	public static void main(String[] args) {
		int matriz[][] = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == j) {
					matriz[i][j] = (int) Math.pow(3, i);
				} else if (i != j) {
					matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Digite números inteiros positivos para visualizar graficamente a matriz"));
				}
			}
		}

		String visualizarGraficaMatriz = ""; 

		for (int linha = 0; linha < 4; linha++) { 
			for (int coluna = 0; coluna < 4; coluna++) { 
				visualizarGraficaMatriz = visualizarGraficaMatriz + matriz[linha][coluna] + " ";
			}
			visualizarGraficaMatriz = visualizarGraficaMatriz + "\n";
		}

		System.out.println(visualizarGraficaMatriz);
	}
}