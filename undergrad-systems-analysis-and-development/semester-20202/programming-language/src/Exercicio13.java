import java.util.Locale;
import java.util.Scanner;

public class Exercicio13 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double qtdAlimentoKg;
		int diasConsumo;

		System.out.print("Digite a quantidade de alimento (Em Kg): ");
		qtdAlimentoKg = scan.nextDouble();
		
	    diasConsumo = (int) (qtdAlimentoKg / 0.05);
	     
	    System.out.print("Essa quantidade de alimento durara por " + diasConsumo + " dias");
	    
		scan.close();

	}

}