import java.util.Scanner;

public class Exercicio67 {

	private static Scanner scan;

	private static int calcularFibonacci(int num) {

		int a = 0, b = 1, aux;

		for (int i = 0; i < num; i++) {
			aux = a;
			a = a + b;
			b = aux;
		}

		return a;

	}
	
	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int num = 0;

		while (num == 0) {
			System.out.print("Digite um numero para ser o limite da sequencia de Fibonacci: ");
			num = scan.nextInt();
		}

		for (int i = 0; i < num; i++) {
			System.out.print(calcularFibonacci(i) + " ");
		}
		
		scan.close();

	}

}