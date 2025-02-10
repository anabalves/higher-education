package exercicio02;

public class ErroStackOverflow {

	private static void chamadaRecursiva() {
		chamadaRecursiva();	
	}
	
	public static void main(String[] args) {
		chamadaRecursiva();
	}
}