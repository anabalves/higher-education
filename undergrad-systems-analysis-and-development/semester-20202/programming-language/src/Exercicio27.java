import java.util.Locale;
import java.util.Scanner;

public class Exercicio27 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		double numVoltas, tamCircuito, tempMinutos, velocMediaMs, velocMediaKmh;
		
		System.out.print("Digite o numero de voltas no circuito: ");
		numVoltas = scan.nextDouble();

		System.out.print("Digite o tamanho do cicuito em metros: ");
		tamCircuito = scan.nextDouble();

		System.out.print("Digite o tempo de duracao em minutos ");
		tempMinutos = scan.nextDouble();

		velocMediaMs = ((numVoltas * tamCircuito) / (tempMinutos * 60));
		velocMediaKmh = velocMediaMs * 3.6;
		
		System.out.printf("A velocidade media percorrida no trajeto foi de %.2fKM/H", velocMediaKmh);

		scan.close();

	}

}
