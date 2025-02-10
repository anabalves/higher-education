package lista1;

import javax.swing.JOptionPane;

public class Exercicio10 {

	public static void main(String[] args) {
		int num;
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro positivo para calcular a série de Fibonacci"));
		} while (num <= 0);
		System.out.print("A série de Fibonacci até o número " + num + " é ");
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