public class Exercicio73 {

	private static int calcularAnos(double maria, double ana) {
		
		int anos = 0;

		while (ana <= maria) {
			maria += 0.02;
			ana += 0.03;
			anos += 1;
		}
		
		return anos;
		
	}
	
	public static void main(String[] args) {
		
		double maria = 1.50, ana = 1.10;

		System.out.print("Daqui a " + calcularAnos(maria, ana) + " anos Ana sera maior que Maria.");

	}

}
