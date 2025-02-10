import java.util.Scanner;

public class Exercicio68 {

	private static Scanner scan;

	private static int verificaMaior(int num, int maior) {
		
		if (num > maior) {
			maior = num;
		}
		
		return maior;
	}

	private static int verificaMenor(int num, int menor) {

		if (num < menor) {
			menor = num;
		}
		
		return menor;
	}

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int num, i, maior, menor;

		System.out.print("Digite o 1° numero: ");
		num = scan.nextInt();

		maior = num;
		menor = num;

		for (i = 2; i <= 100; i++) {
			System.out.print("Digite o " + i + "° numero: ");
			num = scan.nextInt();
			
			maior = verificaMaior(num, maior);
			
			menor = verificaMenor(num, menor);

		}

		System.out.print("O maior numero e: " + maior + "\nO menor numero e: " + menor);

		scan.close();
		
	}

}