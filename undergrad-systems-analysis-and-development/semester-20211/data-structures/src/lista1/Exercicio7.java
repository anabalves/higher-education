package lista1;

public class Exercicio7 {

	public static void main(String[] args) {
		int num = 1;
		System.out.print("A soma de todos os números de 1 a 100 é igual a " + somatoria(num));
	}

	private static int somatoria(int n) {
		if (n == 100) {
			return 100;
		} else {
			int soma = n + somatoria(n + 1);
			return soma;
		}
	}

}