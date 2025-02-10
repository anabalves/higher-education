import java.util.Scanner;

public class Exercicio60 {
	
	private static int  anoNasc, anoAtual, mesNasc, mesAtual, diaNasc, diaAtual;
	
	private static void calcularDiaMesAno() {
	
		int ano, mes, dia;
		
		for (ano = anoNasc; ano <= anoAtual; ano++) {
			if (ano % 4 == 0 & ano % 100 != 0 || ano % 400 == 0) {
				diaAtual += 1;
			}
		}

		if (diaAtual < diaNasc) {
			diaAtual += 30;
			mesAtual -= 1;
		} else if (diaAtual > 30) {
			diaAtual -= 30;
			mesAtual += 1;
		}
		
		if (mesAtual < mesNasc) {
			mesAtual += 12;
			anoAtual -= 1;
		}

		dia = (diaAtual - diaNasc);
		mes = (mesAtual - mesNasc);
		ano = (anoAtual - anoNasc);

		System.out.print(ano + " anos, " + mes + " meses e " + dia + " dias");
		
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite o dia de nascimento: ");
		diaNasc = scan.nextInt();

		System.out.print("Digite o mes de nascimento: ");
		mesNasc = scan.nextInt();
		
		System.out.print("Digite o ano de nascimento: ");
		anoNasc = scan.nextInt();
		
		System.out.print("Digite o dia atual: ");
		diaAtual = scan.nextInt();
		
		System.out.print("Digite o mes atual: ");
		mesAtual = scan.nextInt();

		System.out.print("Digite o ano atual: ");
		anoAtual = scan.nextInt();
		
		calcularDiaMesAno();
		
		scan.close();

	}

}
