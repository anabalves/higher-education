import java.util.Locale;
import java.util.Scanner;

public class Exercicio11 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double raio, comprimento;

		System.out.print("Digite o raio da circunferencia: ");
		raio = scan.nextDouble();
		
		comprimento = Math.PI * 2 * raio;

	    System.out.printf("O comprimento da circunferencia e: %.2f", comprimento);
	    
		scan.close();

	}

}