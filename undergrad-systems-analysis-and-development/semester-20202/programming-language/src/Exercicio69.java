public class Exercicio69 {
	
	private static double calcularGraos(double grao, double qtd) {
		
		grao = Math.pow(2, qtd);
		return grao;
		
	}
	
	private static double calcularGraosTotal(double grao, double total) {
		
		total += grao;
		return total;
		
	}

	public static void main(String[] args) {

		int casa;
		double grao = 0, qtd, total = 0;

		for (casa = 1; casa <= 64; casa++) {
			qtd = casa - 1;
			grao = calcularGraos(grao, qtd); 
			total = calcularGraosTotal(grao, total);
			System.out.println("A casa " + casa + " possui " + grao + " graos");
		}

		System.out.print("A quantidade de graos contidos em um tabuleiro de xadrez e " + total);

	}

}