import java.util.Locale;
import java.util.Scanner;

public class Exercicio15 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double catetoOposto, catetoAdjacente, hipotenusa;

		System.out.print("Digite o valor do cateto adjacente: ");
		catetoAdjacente = scan.nextDouble();

		System.out.print("Digite o valor do cateto oposto: ");
		catetoOposto = scan.nextDouble();
		
		hipotenusa = Math.sqrt(Math.pow(catetoAdjacente, 2) + Math.pow(catetoOposto, 2));
	     
	    System.out.printf("O valor da hipotenusa e: %.2f", hipotenusa);
	    
		scan.close();

	}

}