public class Exercicio41 {

	public static void main(String[] args) {

		int dado1, dado2;

		for (dado1 = 1; dado1 <= 6; dado1++) {
			for (dado2 = 6; dado2 >= 1; dado2--) {
				if (dado1 + dado2 == 7) {
					System.out.println(dado1 + " + " + dado2 + " = " + (dado1 + dado2));
				}
			}
		}
		
	}

}