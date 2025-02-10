import java.util.Locale;
import java.util.Scanner;

public class Exercicio47 {
	
	private static double tempo, velocidade;

	private static void calculaLitrosDistancia() {
		
		double litrosGastos, distanciaPercorrida;
		
		distanciaPercorrida = velocidade * tempo;
		litrosGastos = distanciaPercorrida / 12;
		
		System.out.printf("Foram gastos %.2f litros%n", litrosGastos);
		System.out.printf("A distancia percorrida foi de %.2fKm", distanciaPercorrida);
	
	}
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);

		System.out.print("Informe o tempo total que voce gastou no percurso (minutos / 60 = horas): ");
		tempo = scan.nextDouble();

		System.out.print("Informe a velocidade media durante a viagem: ");
		velocidade = scan.nextDouble();
		
		calculaLitrosDistancia();
	    
		scan.close();

	}

}