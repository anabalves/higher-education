package lista1;

public class Exercicio9 {

	public static void main(String[] args) {
		int soma = 300;
		System.out.print("A soma de todos os números ímpares de 1 a 300 é igual a " + somaImpares(soma));
	}

	private static int somaImpares(int num) {
		if (num == 0)
			return 0;
		if (num % 2 != 0)
			return num + somaImpares(num - 1);
		
		return somaImpares(num - 1);
	}

}