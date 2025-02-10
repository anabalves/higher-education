import java.util.Locale;
import java.util.Scanner;

public class Exercicio16 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		int dependentes;
		double horasTrab, valorHora, desconto, salarioBruto, salarioLiquido, salarioFinal;

		System.out.print("Digite as horas trabalhadas: ");
		horasTrab = scan.nextInt();

		System.out.print("Digite o valor por hora: ");
		valorHora = scan.nextInt();

		System.out.print("Digite o percentual de desconto: ");
		desconto = scan.nextInt();

		System.out.print("Digite o numero de dependentes: ");
		dependentes = scan.nextInt();

		salarioBruto = horasTrab * valorHora;
		salarioLiquido = salarioBruto - ((salarioBruto / 100) * desconto);
		salarioFinal = salarioLiquido + (100 * dependentes);
				
		System.out.printf("Seu salario bruto e R$%.2f %n", salarioBruto);
		System.out.printf("Seu salario liquido e R$%.2f %n", salarioLiquido);
		System.out.printf("Seu salario final e R$%.2f", salarioFinal);

		scan.close();

	}

}