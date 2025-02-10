import java.util.Locale;
import java.util.Scanner;

public class Exercicio10 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double num1, num2, diferenca;

		System.out.print("Digite o primeiro valor: ");
		num1 = scan.nextDouble();

		System.out.print("Digite o segundo valor: ");
		num2 = scan.nextDouble();
		
		diferenca = num1 - num2;

	    System.out.println("A diferenca entre os valores e: " + diferenca);
	    
		scan.close();

	}

}