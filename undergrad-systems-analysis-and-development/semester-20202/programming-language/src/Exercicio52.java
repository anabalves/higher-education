import java.util.Scanner;

public class Exercicio52 {
	
	private static int num1, num2;
	
	private static void ordemCrescente() {
		
		if (num1 == num2) {
			System.out.println("Os valores devem ser diferentes");
		} else if (num1 < num2) {
			System.out.println("Os valores em ordem crescente sao: " + num1 + " e " + num2);
		} else {
			System.out.println("Os valores em ordem crescente sao: " + num2 + " e " + num1);
		}
		
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite o primeiro numero: ");
		num1 = scan.nextInt();

		System.out.print("Digite o segundo numero: ");
		num2 = scan.nextInt();
		
		ordemCrescente();
		
		scan.close();

	}

}