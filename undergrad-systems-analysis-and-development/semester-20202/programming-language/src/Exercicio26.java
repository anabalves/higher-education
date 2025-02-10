import java.util.Scanner;

public class Exercicio26 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int num1, num2, maior, menor;
		
		System.out.print("Digite o primeiro numero: ");
		num1 = scan.nextInt();

		System.out.print("Digite o segundo numero: ");
		num2 = scan.nextInt();
		
		if (num1 > num2) {
			maior = num1;
			menor = num2;
		} else {
			maior = num2;
			menor = num1;			
		}

		if (maior % menor == 0) {
			System.out.print(maior + " e multiplo de " + menor);
		} else {
			System.out.print(maior + " nao e multiplo de " + menor);
		}
		
		scan.close();

	}


}