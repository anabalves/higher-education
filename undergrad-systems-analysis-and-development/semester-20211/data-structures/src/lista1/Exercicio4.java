package lista1;

public class Exercicio4 {

	public static void main(String[] args) {
		double matriz[][] = new double[4][4];
		double soma1a100 = 0;
		double qtdImpares30a50 = 0;
		double qtdDivisiveis8 = 0;
		double qtdImparesDivisiveis3 = 0;
		double fatorialMaiorNumero = 1;
		double maiorNumeroMatriz = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = getRandomNumber();
				System.out.println(matriz[i][j]);

				if (matriz[i][j] > 1 & matriz[i][j] < 100) {
					soma1a100 = soma1a100 + matriz[i][j];
				}
				if (matriz[i][j] > 30 & matriz[i][j] < 50 & matriz[i][j] % 2 == 1) {
					qtdImpares30a50 = qtdImpares30a50 + 1;
				}
				if (matriz[i][j] % 8 == 0) {
					qtdDivisiveis8 = qtdDivisiveis8 + 1;
				}
				if (matriz[i][j] % 2 == 1 & matriz[i][j] % 3 == 0) {
					qtdImparesDivisiveis3 = qtdImparesDivisiveis3 + 1;
				}
				if (matriz[i][j] > maiorNumeroMatriz || i == 0) {
					maiorNumeroMatriz = matriz[i][j];
				}

			}
		}
		
		for(int i = 1; i <= maiorNumeroMatriz; i++) {
			fatorialMaiorNumero = fatorialMaiorNumero * i;
		}

		System.out.println("A soma dos valores no intervalo de 1 a 100 � igual a " + soma1a100);
		System.out.println("A quantidade de n�meros �mpares entre 30 a 50 � igual a " + qtdImpares30a50);
		System.out.println("A quantidade de n�meros divis�veis por 8 � igual a " + qtdDivisiveis8);
		System.out.println("A quantidade de n�meros �mpares divis�veis por 3 � igual a " + qtdImparesDivisiveis3);
		System.out.println("O fatorial do maior n�mero informado na matriz � igual a " + fatorialMaiorNumero);

	}

	public static int getRandomNumber() {
		return (int) ((Math.random() * (100 - 1) + 1));
	}

}