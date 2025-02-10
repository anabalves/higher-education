import java.util.Scanner;

public class Exercicio64 {

	private static Scanner scan;

	private static int calcularTabuada(int num, int i) {

		int resultado;

		resultado = i * num;

		return resultado;
	}

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int num;

		System.out.print("Digite um numero para calcular a tabuada: ");
		num = scan.nextInt();

		for (int i = 0; i <= 10; i++) {
			System.out.println(num + " x " + i + " = " + calcularTabuada(num, i));
		}
		
		scan.close();

	}

}