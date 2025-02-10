import java.util.Arrays;
import java.util.Scanner;

public class Exercicio78 {

	private static Scanner scan;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		int vetor1[] = new int[3];
		int vetor2[] = new int[3];
		int vetor3[] = new int[6];
		
		for (int i = 0; i < vetor1.length; i++) {
			System.out.print("Digite o " + (i + 1) + "º numero para o 1º Vetor: ");
			vetor1[i] = scan.nextInt();
			vetor3[i] = vetor1[i];
		}
		
		for (int i = 0; i < vetor2.length; i++) {
			System.out.print("Digite o " + (i + 1) + "º numero para o 2º Vetor: ");
			vetor2[i] = scan.nextInt();
			vetor3[i + vetor1.length] = vetor2[i];
		}
		
		System.out.print("Vetor 3 " + (Arrays.toString(vetor3)));

	}

}