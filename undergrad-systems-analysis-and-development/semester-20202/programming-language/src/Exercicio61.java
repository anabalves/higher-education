public class Exercicio61 {
	
	private static int calcularQuadrado(int i) {
		return (int) Math.pow(i, 2);
	}

	public static void main(String[] args) {
		
		for (int i = 10; i <= 150; i++) {
			System.out.println("O quadrado de " + i + " e " + calcularQuadrado(i));
		}
		
	}

}