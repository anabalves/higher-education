import java.util.Locale;
import java.util.Scanner;

public class Exercicio05 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double a, b, c, delta, x1, x2;

		System.out.print("Digite o valor de a: ");
		a = scan.nextDouble();

		System.out.print("Digite o valor de b: ");
		b = scan.nextDouble();
		
		System.out.print("Digite o valor de c: ");
		c = scan.nextDouble();
		
		delta = Math.pow(b,2) - (4 * a * c);

	    System.out.println("O valor de delta e: " + delta);
	    
	    x1 = (-b + Math.sqrt(delta)) / (2 * a);
	    x2 = (-b - Math.sqrt(delta)) / (2 * a);	    
	    
	    System.out.println("Raiz 1 e igual a: " + x1);
	    System.out.println("Raiz 2 e igual a: " + x2);

		scan.close();

	}

}