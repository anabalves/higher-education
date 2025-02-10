package lista1;

import javax.swing.JOptionPane;

public class Exercicio11 {

	public static void main(String[] args) {
		int num;
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro positivo para calcular a série"));
		} while (num <= 0);
		System.out.print("O cálculo da série: \n 1 ");
		for (int i = 1; i < num; i++) {
			System.out.print(" + 1/" + (i + 1));
		}
		System.out.println("\n é igual a " + (0 + CalcularSerie(num)));
	}

	public static double CalcularSerie(int num) {
		if (num == 1)
			return 1.0;
		else
			return 1.0 / num + CalcularSerie(num - 1);
	}

}