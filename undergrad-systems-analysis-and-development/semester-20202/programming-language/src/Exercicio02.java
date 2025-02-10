import java.util.Locale;
import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		double salario, novoSalario;

		System.out.print("Digite o salario: ");
		salario = scan.nextDouble();

		novoSalario = salario + (salario * 0.15);

	    System.out.print("O novo salario com reajuste de 15% e igual a " + novoSalario);

		scan.close();

	}

}