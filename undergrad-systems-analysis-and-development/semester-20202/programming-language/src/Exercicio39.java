public class Exercicio39 {

	public static void main(String[] args) {

		int casa;
		double grao, qtd, total = 0;

		for (casa = 1; casa <= 64; casa++) {
			qtd = casa - 1;
			grao = Math.pow(2, qtd);
			total += grao;
			System.out.println("A casa " + casa + " possui " + grao + " graos");
		}

		System.out.print("A quantidade de graos contidos em um tabuleiro de xadrez e " + total);

	}
	
}