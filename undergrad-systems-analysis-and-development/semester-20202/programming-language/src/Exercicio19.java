import java.util.Locale;
import java.util.Scanner;

public class Exercicio19 { 
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		double num1, num2;

		System.out.print("Digite o primeiro valor: ");
		num1 = scan.nextDouble();

		System.out.print("Digite o segundo valor: ");
		num2 = scan.nextDouble();
		
		if (num1 >= num2) {
			if (num1 > num2) {
				System.out.println("O maior valor e " + num1);
			} else {
				System.out.println("Os valores sao iguais");
			}
		} else {
			System.out.println("O maior valor e " + num2);
		}
	    
		scan.close();

	}

}