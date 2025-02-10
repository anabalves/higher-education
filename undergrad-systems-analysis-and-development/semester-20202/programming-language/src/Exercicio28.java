import java.util.Locale;
import java.util.Scanner;

public class Exercicio28 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		double precoAtual, vendaMensal, precoNovo;

		System.out.print("Digite o preco atual do produto: ");
		precoAtual = scan.nextDouble();

		System.out.print("Digite a media mensal de vendas do produto: ");
		vendaMensal = scan.nextDouble();

		if (precoAtual < 30 & vendaMensal < 500) {
			precoNovo = precoAtual + (precoAtual * 0.1);
			System.out.print("o novo valor do produto e " + precoNovo);
		} else if (precoAtual >= 30 & precoAtual < 80 & vendaMensal >= 500 & vendaMensal < 1000) {
			precoNovo = precoAtual + (precoAtual * 0.15);
			System.out.print("o novo valor do produto e " + precoNovo);
		} else if (precoAtual >= 80 & vendaMensal >= 1000) {
			precoNovo = precoAtual - (precoAtual * 0.05);
			System.out.print("o novo valor do produto e " + precoNovo);
		} else {
			precoNovo = precoAtual;
			System.out.print("O valor do produto nao foi alterado, continua sendo R$" + precoNovo);
		}

		scan.close();

	}

}
