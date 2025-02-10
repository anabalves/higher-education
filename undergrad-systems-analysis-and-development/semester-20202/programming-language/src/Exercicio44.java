import java.util.Scanner;

public class Exercicio44 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int base, expoente;

		System.out.print("Digite o valor da base: ");
		base = scan.nextInt();

		System.out.print("Digite o valor do expoente: ");
		expoente = scan.nextInt();

		System.out.printf(base + " ^ " + expoente + " = " + Math.pow(base, expoente));

		scan.close();

	}

}