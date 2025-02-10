import java.util.Locale;
import java.util.Scanner;

public class Exercicio59 {

	private static int tipoInvest = 0;
	private static double valor;

	private static void calcularValorRendimento() {

		double valorRend;

		if (tipoInvest == 1) {
			System.out.println("Investimento em poupanca");
			valorRend = valor + (valor * 0.03);
			System.out.printf("O valor corrigido em 30 dias e de R$%.2f", valorRend);
		} else {
			System.out.println("Investimento em renda fixa");
			valorRend = valor + (valor * 0.05);
			System.out.printf("O valor corrigido em 30 dias e de R$%.2f", valorRend);
		}

	}

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		while (tipoInvest != 1 & tipoInvest != 2) {
			System.out.print("Digite o tipo de investimento 1 = poupanca e 2 = renda fixa: ");
			tipoInvest = scan.nextInt();
		}

		System.out.print("Digite o valor do investimento:  ");
		valor = scan.nextDouble();

		calcularValorRendimento();

		scan.close();

	}

}