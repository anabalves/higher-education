package lista1;

import javax.swing.JOptionPane;

public class Exercicio2 {
	
	public static void main(String[] args) {
		int[] valores = new int[5];
		int[] valoresFatorial = new int[5];

		for (int i = 0; i < 5; i++) {
			valores[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero inteiro positivo para calcular seu fatorial"));
		}

		for (int i = 0; i < 5; i++) {
			valoresFatorial[i] = calculaFatorial(valores[i]);
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("O fatorial do n�mero " + valores[i] + " � igual a: " + valoresFatorial[i]);
		}
	}
	
	public static int calculaFatorial(int num) {
		int fatorial = 1;
		for (int i = 2; i <= num; i++) {
			fatorial = fatorial * i;
		}
		return fatorial;
	}

}