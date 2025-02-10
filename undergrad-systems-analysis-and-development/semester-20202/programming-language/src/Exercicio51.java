import java.util.Locale;
import java.util.Scanner;

public class Exercicio51 {

	private static double nota1, nota2, nota3, nota4;

	private static void calculaMedia() {
		
		double media;
		
		media = (nota1 + nota2 + nota3 + nota4) / 4;
		System.out.println("A media e: " + media);

		if (media < 3) {
			System.out.println("Aluno Retido");
		} else if (media >= 6) {
			System.out.println("Aluno Aprovado");
		} else {
			System.out.println("Aluno em Exame");
		}

	}
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite a primeira nota: ");
		nota1 = scan.nextDouble();

		System.out.print("Digite a segunda nota: ");
		nota2 = scan.nextDouble();

		System.out.print("Digite a terceira nota: ");
		nota3 = scan.nextDouble();

		System.out.print("Digite a quarta nota: ");
		nota4 = scan.nextDouble();
				
		calculaMedia();
	    
		scan.close();

	}

}