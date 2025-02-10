package lista1;

public class Exercicio8 {

	public static void main(String[] args) {
		int soma = 200;
		System.out.print("A soma de todos os números pares de 1 a 200 é igual a " + somaPares(soma));
	}

	private static int somaPares(int num) {
		if (num == 0)
			return 0;
		if (num % 2 == 0)
			return num + somaPares(num - 1);
		
		return somaPares(num - 1);
	}

}