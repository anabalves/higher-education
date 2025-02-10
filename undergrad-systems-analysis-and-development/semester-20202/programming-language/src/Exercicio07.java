import java.util.Locale;
import java.util.Scanner;

public class Exercicio07 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double comprimento, largura, altura, volume;

		System.out.print("Digite o comprimento: ");
		comprimento = scan.nextDouble();

		System.out.print("Digite a largura: ");
		largura = scan.nextDouble();

		System.out.print("Digite a altura: ");
		altura = scan.nextDouble();
		
		volume = comprimento * largura * altura;

	    System.out.println("O volume do paralelepipedo e: " + volume + "m3");
	    
		scan.close();

	}

}