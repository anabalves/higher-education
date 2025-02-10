import java.util.Scanner;

public class Exercicio74 {
	
	private static double calcularPotencia(int base, int expoente) {
		
		double resultado = Math.pow(base, expoente);
		
		return resultado;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int base, expoente;

		System.out.print("Digite o valor da base: ");
		base = scan.nextInt();

		System.out.print("Digite o valor do expoente: ");
		expoente = scan.nextInt();

		System.out.printf(base + " ^ " + expoente + " = " + calcularPotencia(base, expoente));

		scan.close();

	}

}