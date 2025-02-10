package exercicio08;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {

		Dinossauro skeep = new Dinossauro();
		Scanner scan = new Scanner(System.in);

		char letra = ' ';

		while (letra != 'E') {
			System.out.println("\n===========================| Dinossauro Skeep |===========================\n");
			System.out.println("\n---------------------------| Status do Skeep |----------------------------\n");
			skeep.status();
			System.out.println("\n--------------------------------| Opções |---------------------------------\n");
			System.out.println(
					"(P)ular \n(C)orrer \nCo(M)er \nC(A)ntar \nTomar (S)ol \nFicar na S(O)mbra \n\n(E)ncerrar jogo");
			System.out.println("\n============================================================================\n");

			String textoMaiusculo = scan.nextLine().toUpperCase();
			letra = textoMaiusculo.charAt(0);

			switch (letra) {
			case 'P':
				skeep.pular();
				break;
			case 'C':
				skeep.correr();
				break;
			case 'M':
				skeep.comer();
				break;
			case 'A':
				skeep.cantar();
				break;
			case 'S':
				skeep.tomarSol();
				break;
			case 'O':
				skeep.ficarNaSombra();
				break;
			case 'E':
				System.out.print("Jogo Finalizado");
				break;
			default:
				System.out.print("Opção inválida");
				break;
			}
			
		}

		scan.close();

	}

}