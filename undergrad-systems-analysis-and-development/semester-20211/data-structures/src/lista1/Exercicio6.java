package lista1;

import javax.swing.JOptionPane;

public class Exercicio6 {

	public static void main(String[] args) {
		int num;
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero inteiro positivo para calcular seu fatorial"));
		} while (num < 0);
		System.out.print("O fatorial de " + num + " � " + calculaFatorial(num));
	}

	private static int calculaFatorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * calculaFatorial(n - 1);
	}

}