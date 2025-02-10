import java.util.Scanner;

public class Exercicio35 {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		int i, num1, num2, maior, menor, somaImpares = 0;

		System.out.print("Digite o primeiro numero: ");
		num1 = scan.nextInt();

		System.out.print("Digite o segundo numero: ");
		num2 = scan.nextInt();

		if (num1 >= num2) {
			maior = num1;
			menor = num2;
		} else {
			maior = num2;
			menor = num1;
		}
		
		System.out.print("Numeros Impares encontrados: ");
		for (i = menor; i <= maior; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
				somaImpares += i;
			}
		}

		System.out.println();
		System.out.print("A soma dos numeros impares e " + somaImpares);
		
		scan.close();

	}
	
}