import java.util.Scanner;

public class Exercicio55 {
	
	private static int horaInicial, horaFinal, minInicial, minFinal;
	
	private static void calcularDuracaoJogo() {
		
		int horaTotal = 0, minTotal = 0;
		
		if (horaFinal >= horaInicial) {
			horaTotal = (horaFinal + horaInicial);
		} else {
			horaTotal = ((horaFinal - horaInicial) + 24);
		} 
		
		if (minFinal >= minInicial) {
			minTotal = (minFinal + minInicial);
		} else {
			minTotal = ((minFinal - minInicial) + 60);
			horaTotal = (horaTotal - 1);
		}
		
        if (horaInicial < 0 || horaFinal < 0 || horaInicial > 23 || horaFinal > 23 || minInicial < 0 || minFinal < 0 || minInicial > 59 || minFinal > 59) {
        	System.out.println("Valor invalido! Por favor, informe valores dentro dos parametros: horas de 0 ate 23 e minutos de 0 ate 59");
        } else {
        	System.out.println("A duracao do jogo foi de: " + horaTotal + ":" + minTotal);
        }
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite a hora inicial do jogo: ");
		horaInicial = scan.nextInt();

		System.out.print("Digite o minuto inicial do jogo: ");
		minInicial = scan.nextInt();
		
		System.out.print("Digite a hora final do jogo: ");
		horaFinal = scan.nextInt();
		
		System.out.print("Digite o minuto final do jogo: ");
		minFinal = scan.nextInt();
		
		calcularDuracaoJogo();
		
		scan.close();
		
	}

}
