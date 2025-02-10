public class Exercicio71 {
	
	private static void verificarPossibilidades() {
		
		int dado1, dado2;

		for (dado1 = 1; dado1 <= 6; dado1++) {
			for (dado2 = 6; dado2 >= 1; dado2--) {
				if (dado1 + dado2 == 7) {
					System.out.println(dado1 + " + " + dado2 + " = " + (dado1 + dado2));
				}
			} 
			
		}

	}
	
	public static void main(String[] args) {
	
		System.out.println("Possibilidades de 2 dados darem a soma igual a 7: ");
		verificarPossibilidades();
	
	}

}