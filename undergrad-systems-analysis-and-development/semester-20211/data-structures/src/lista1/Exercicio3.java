package lista1;

public class Exercicio3 {

	public static void main(String[] args) {
		int[] valores = new int[100];

		for (int i = 0; i < 100; i++) {
			valores[i] = getRandomNumber();
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 99; j++) {
				if (valores[j] > valores[j + 1]) {
					int auxiliar = valores[j];
					valores[j] = valores[j + 1];
					valores[j + 1] = auxiliar;
				}
			}
		}

		System.out.println("O vetor classificado em ordem crescente: ");
		for (int i = 0; i < 100; i++) {
			System.out.println(valores[i]);
		}
	}

	public static int getRandomNumber() {
		return (int) ((Math.random() * (50 - (-50)) + (-50)));
	}

}