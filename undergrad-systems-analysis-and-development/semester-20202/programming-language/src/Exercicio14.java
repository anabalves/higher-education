import java.util.Locale;
import java.util.Scanner;

public class Exercicio14 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double angulo1, angulo2, angulo3;

		System.out.print("Digite o valor do primeiro angulo do triangulo: ");
		angulo1 = scan.nextDouble();

		System.out.print("Digite o valor do segundo angulo do triangulo: ");
		angulo2 = scan.nextDouble();
		
		angulo3 = 180 - (angulo1 + angulo2);
	     
	    System.out.printf("O valor do terceiro angulo e: %.2f°", angulo3);
	    
		scan.close();

	}

}