import java.util.Locale;
import java.util.Scanner;

public class Exercicio01 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double lado, area;

		System.out.print("Digite o lado do quadrado: ");
		lado = scan.nextDouble();

		area = lado * lado;

	    System.out.printf("A area do quadrado de lado " + lado + " e igual a " + area);

		scan.close();

	}

}