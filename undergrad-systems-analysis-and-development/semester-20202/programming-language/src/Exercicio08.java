import java.util.Locale;
import java.util.Scanner;

public class Exercicio08 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double depositoPoupanca, rendPoupanca;

		System.out.print("Digite o valor do deposito: ");
		depositoPoupanca = scan.nextDouble();
		
		rendPoupanca = depositoPoupanca + (depositoPoupanca * 0.013);

	    System.out.println("O valor do deposito apos 1 mes de aplicacao e: " + rendPoupanca);
	    
		scan.close();

	}

}