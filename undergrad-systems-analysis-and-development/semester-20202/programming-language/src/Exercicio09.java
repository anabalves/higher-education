import java.util.Locale;
import java.util.Scanner;

public class Exercicio09 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double num1, num2, somaQuadrados;

		System.out.print("Digite o primeiro valor: ");
		num1 = scan.nextDouble();

		System.out.print("Digite o segundo valor: ");
		num2 = scan.nextDouble();
		
		somaQuadrados = (num1 * num1) + (num2 * num2);

	    System.out.println("A soma dos quadrados e: " + somaQuadrados);
	    
		scan.close();

	}

}