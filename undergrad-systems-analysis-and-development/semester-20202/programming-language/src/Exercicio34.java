import java.util.Scanner;

public class Exercicio34 {

	private static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);

		int i, num, resultado;

		System.out.print("Digite um numero para calcular a tabuada: ");
		num = scan.nextInt();

		for (i = 0; i <= 10; i++) {
			resultado = i * num;
			System.out.println(num + " x " + i + " = " + resultado);
		}
		
		scan.close();

	}

}