import java.util.Scanner;

public class Exercicio18 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int num1, num2, diferenca;

		System.out.print("Digite o primeiro valor: ");
		num1 = scan.nextInt();

		System.out.print("Digite o segundo valor: ");
		num2 = scan.nextInt();

		if (num1 >= num2) {
			diferenca = num1 - num2;
		} else {
			diferenca = num2 - num1;
		}

		System.out.println("A diferenca entre o maior valor pelo menor e: " + diferenca);

		scan.close();

	}

}