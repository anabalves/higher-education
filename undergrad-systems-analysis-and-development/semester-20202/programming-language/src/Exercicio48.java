import java.util.Scanner;

public class Exercicio48 {

	private static int  num1, num2;

	private static void calculaDiferenca() {
		
		int diferenca;
		
		if (num1 >= num2) {
			diferenca = num1 - num2;
		} else {
			diferenca = num2 - num1;
		}

		System.out.println("A diferenca entre o maior valor pelo menor e: " + diferenca);
		
	}
	
	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o primeiro valor: ");
		num1 = scan.nextInt();

		System.out.print("Digite o segundo valor: ");
		num2 = scan.nextInt();
		
		calculaDiferenca();
	    
		scan.close();

	}

}