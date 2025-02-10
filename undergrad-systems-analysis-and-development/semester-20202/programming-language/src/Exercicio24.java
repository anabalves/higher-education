import java.util.Scanner;

public class Exercicio24 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int num;
		
		System.out.print("Digite um numero: ");
		num = scan.nextInt();

		if (num % 2 == 0 & num % 3 == 0) {
			System.out.println(num + " e divisivel por 2 e 3");
		} else if (num % 2 == 0) {
			System.out.println(num + " e divisivel por 2");
		} else if (num % 3 == 0) {
			System.out.println(num + " e divisivel por 3");
		} else {
			System.out.println(num + " nao e divisivel por 2 e nem por 3");
		}

		scan.close();

	}

}
