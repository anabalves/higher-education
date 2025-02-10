import java.util.Locale;
import java.util.Scanner;

public class Exercicio21 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		double nota1, nota2, nota3, nota4, media;

		System.out.print("Digite a primeira nota: ");
		nota1 = scan.nextDouble();

		System.out.print("Digite a segunda nota: ");
		nota2 = scan.nextDouble();

		System.out.print("Digite a terceira nota: ");
		nota3 = scan.nextDouble();

		System.out.print("Digite a quarta nota: ");
		nota4 = scan.nextDouble();

		media = (nota1 + nota2 + nota3 + nota4) / 4;
		System.out.println("A media e: " + media);

		if (media < 3) {
			System.out.println("Aluno Retido");
		} else if (media >= 6) {
			System.out.println("Aluno Aprovado");
		} else {
			System.out.println("Aluno Exame");
		}

		scan.close();

	}

}