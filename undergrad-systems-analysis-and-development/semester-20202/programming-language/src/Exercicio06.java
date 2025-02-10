import java.util.Locale;
import java.util.Scanner;

public class Exercicio06 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double X, Y, troca;

		System.out.print("Digite X: ");
		X = scan.nextDouble();

		System.out.print("Digite Y: ");
		Y = scan.nextDouble();
		
		troca = X;
		X = Y;
		Y = troca;

	    System.out.println("O valor de X e: " + X);
	    System.out.println("O valor de Y e: " + Y);
	    
		scan.close();

	}

}