import java.util.Locale;
import java.util.Scanner;

public class Exercicio03 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double base, altura, area;

		System.out.print("Digite a base do triangulo: ");
		base = scan.nextDouble();

		System.out.print("Digite a altura do triangulo: ");
		altura = scan.nextDouble();
		
		area = (base * altura) / 2;

	    System.out.printf("A area do triangulo e igual a: " + area);

		scan.close();

	}

}