import java.util.Random;

public class Exercicio87 {

	public static void main(String[] args) {

		int xadrez[][] = new int[8][8];
		int vet[] = new int[7];
		String tabuleiro = "Tabuleiro de xadrez: \n";

		Random gerador = new Random();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				xadrez[i][j] = gerador.nextInt(7) + 1;
				tabuleiro += "| " + xadrez[i][j] + "|";
				vet[xadrez[i][j] - 1] += 1;
			}
			tabuleiro += "\n";
		}

		System.out.println(tabuleiro);
		System.out.println("Quantidade de pecas no tabuleiro:");
		System.out.println("Quantidade de Peoes: " + vet[0]);
		System.out.println("Quantidade de Torres: " + vet[1]);
		System.out.println("Quantidade de Bispos: " + vet[2]);
		System.out.println("Quantidade de Cavalos: " + vet[3]);
		System.out.println("Quantidade de Rainhas: " + vet[4]);
		System.out.println("Quantidade de Reis: " + vet[5]);
		System.out.println("Quantidade de pecas vazias: " + vet[6]);
		
	}
	
}