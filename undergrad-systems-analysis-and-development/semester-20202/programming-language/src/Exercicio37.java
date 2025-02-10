import java.util.Scanner;

public class Exercicio37 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int i, a = 0, b = 1, aux, num = 0;

		while (num == 0) {
			System.out.print("Digite um numero para ser o limite da sequencia de Fibonacci: ");
			num = scan.nextInt();
		}

		for (i = 0; i < num; i++) {
			System.out.print(a + " ");
			aux = a;
			a = a + b;
			b = aux;
		}
		
		scan.close();

	}

}