import java.util.Scanner;

public class Exercicio12 {

	public static void main(String[] args) {
				
		Scanner scan = new Scanner(System.in);
		int anoNascimento, anoAtual, idade, idadeFutura;

		System.out.print("Digite o ano de seu nascimento: ");
		anoNascimento = scan.nextInt();

		System.out.print("Digite o ano atual: ");
		anoAtual = scan.nextInt();
		
		idade = anoAtual - anoNascimento;
		idadeFutura = idade + 17;

	    System.out.println("Sua idade e: " + idade + " anos");
	    System.out.println("Daqui 17 anos sua idade sera: " + idadeFutura + " anos");
	    
		scan.close();

	}

}