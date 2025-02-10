package lista1;

public class Exercicio1 {
	
	static double[] valoresSaldos = new double[100];
	static double mediaSaldosPositivos = 0;
	static double mediaGeralSaldos = 0;
	static double somaSaldosNegativos = 0;
	static double qtd100a1000 = 0;
	
	public Double getRandomNumber() {
		return ((Math.random() * (1000 - (-1000)) + (-1000)));
	}

	public void calculaSaldos(double[] valoresSaldos, double mediaSaldosPositivos, double mediaGeralSaldos, double somaSaldosNegativos, double qtd100a1000) {
		System.out.println("Valores: \n");
		
		for (int i = 0; i < 100; i++) {
			valoresSaldos[i] = getRandomNumber();
			System.out.println(valoresSaldos[i]);
			mediaGeralSaldos = mediaGeralSaldos + valoresSaldos[i];

			if (valoresSaldos[i] > 100 & valoresSaldos[i] < 1000) {
				mediaSaldosPositivos = mediaSaldosPositivos + valoresSaldos[i];
				qtd100a1000++;
			} else if (valoresSaldos[i] < 0) {
				somaSaldosNegativos = somaSaldosNegativos + valoresSaldos[i];
			}

		}
		System.out.println("----------------------------");

		mediaGeralSaldos = mediaGeralSaldos / 100;
		mediaSaldosPositivos = mediaSaldosPositivos / qtd100a1000;
		
		System.out.println("A média dos saldos positivos entre 100 à 1000 é igual a: " + mediaSaldosPositivos);
		System.out.println("A média geral dos saldos é igual a: " + mediaGeralSaldos);
		System.out.println("A soma dos saldos negativos é igual a: " + somaSaldosNegativos);
	}

	public static void main(String[] args) {
		Exercicio1 t = new Exercicio1();
		t.calculaSaldos(valoresSaldos, mediaSaldosPositivos, mediaGeralSaldos, somaSaldosNegativos, qtd100a1000);
	}
}