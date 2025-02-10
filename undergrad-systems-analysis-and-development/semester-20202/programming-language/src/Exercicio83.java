import java.util.Locale;
import java.util.Scanner;

public class Exercicio83 {

	private static Scanner scan;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		scan = new Scanner(System.in);

		int matriz[][] = new int[4][3];
		String produtos[] = { "Camisetas", "Calcas", "Vestidos" };
		String semanas[] = { "Semana 1", "Semana 2", "Semana 3", "Semana 4" };
		int vendaSemana[] = new int[4];
		int vendaProduto[] = new int[3];
		int totalVendas = 0;

		for (int semana = 0; semana < 4; semana++) {
			for (int produto = 0; produto < 3; produto++) {
				if (produto == 0) {
					System.out.print("Digite a quantidade de camisetas vendidas na " + (semana + 1) + "� semana: ");
					matriz[semana][produto] = scan.nextInt();
					vendaProduto[0] += matriz[semana][produto];
					totalVendas += matriz[semana][produto];

				} else if (produto == 1) {
					System.out.print("Digite a quantidade de calcas vendidas na " + (semana + 1) + "� semana: ");
					matriz[semana][produto] = scan.nextInt();
					vendaProduto[1] += matriz[semana][produto];
					totalVendas += matriz[semana][produto];
				} else {
					System.out.print("Digite a quantidade de vestidos vendidos na " + (semana + 1) + "� semana: ");
					matriz[semana][produto] = scan.nextInt();
					vendaProduto[2] += matriz[semana][produto];
					totalVendas += matriz[semana][produto];
				}
				vendaSemana[semana] += matriz[semana][produto];
			}
		}
		
		System.out.println();
		
		for(int i = 0; i < 2; i++) {
			System.out.print("\t");
		}
		
		for (int i = 0; i < produtos.length; i++) {
			System.out.print(produtos[i] + "\t");
		}

		for (int i = 0; i < semanas.length; i++) {
			for (int linha = 0; linha < matriz.length; linha++) {
				System.out.println("\t\t");
				System.out.print(semanas[i]+"\t\t");
				i = i + 1;
				for (int coluna = 0; coluna < produtos.length; coluna++) {
					System.out.print(matriz[linha][coluna] + "\t");
				}
			}
		}
		
		System.out.println("\n");
        System.out.println("A quantidade de produtos vendidos na primeira semana foi de: " + vendaSemana[0]);
        System.out.println("A quantidade de produtos vendidos na segunda semana foi de: " + vendaSemana[1]);
        System.out.println("A quantidade de produtos vendidos na terceira semana foi de: " + vendaSemana[2]);
        System.out.println("A quantidade de produtos vendidos na quarta semana foi de: " + vendaSemana[3]);
        System.out.println("A quantidade de camisetas vendidos no mes foi de: " + vendaProduto[0]);
        System.out.println("A quantidade de calcas vendidos no mes foi de: " + vendaProduto[1]);
        System.out.println("A quantidade de vestidos vendidos no mes foi de: " + vendaProduto[2]);        
        System.out.println("A quantidade total de produtos vendidos no mes foi de: " + totalVendas);

	}

}