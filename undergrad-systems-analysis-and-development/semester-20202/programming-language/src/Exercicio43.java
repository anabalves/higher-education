public class Exercicio43 {

	public static void main(String[] args) {

		double maria = 1.50, ana = 1.10;
		int anos = 0;

		while (ana <= maria) {
			maria += 0.02;
			ana += 0.03;
			anos += 1;
		}

		System.out.print("Daqui a " + anos + " anos Ana sera maior que Maria.");

	}

}