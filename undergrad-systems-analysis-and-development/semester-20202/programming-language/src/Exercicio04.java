import java.util.Locale;
import java.util.Scanner;

public class Exercicio04 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double celsius, fahrenheit;

		System.out.print("Digite a temperatura em celsius: ");
		celsius = scan.nextDouble();
		
		fahrenheit = ((9 * celsius) + 160) / 5;

	    System.out.printf("A temperatura em fahrenheit e igual a: " + fahrenheit);

		scan.close();

	}

}