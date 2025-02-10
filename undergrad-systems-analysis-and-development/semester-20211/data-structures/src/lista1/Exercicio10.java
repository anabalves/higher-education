package lista1;

import javax.swing.JOptionPane;

public class Exercicio10 {

	public static void main(String[] args) {
		int num;
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero inteiro positivo para calcular a s�rie de Fibonacci"));
		} while (num <= 0);
		System.out.print("A s�rie de Fibonacci at� o n�mero " + num + " � ");
		for (int i = 0; i < num; i++) {
			System.out.print(calculaSerieFibonacci(i) + " ");
		}
	}

	private static int calculaSerieFibonacci(int fibo) {
		if (fibo < 2)
			return fibo;
		else
			return calculaSerieFibonacci(fibo - 1) + calculaSerieFibonacci(fibo - 2);
	}

}