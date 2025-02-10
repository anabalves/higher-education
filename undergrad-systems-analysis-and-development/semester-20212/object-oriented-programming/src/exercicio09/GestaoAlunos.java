package exercicio09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class GestaoAlunos {

	int indice;
	Aluno[] alunos = new Aluno[50];
	private Scanner scan;
	public static final SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
	
	long id;
	String nome;
	String ra;
	Date nascimento;

	public void criar() {
		System.out.println("\n============================| CADASTRO |============================\n");
		id = new Random().nextLong();

		System.out.print("Digite o nome do aluno: ");
		nome = scan.nextLine();

		System.out.print("Digite o RA do aluno: ");
		ra = scan.nextLine();

		while (true) {
			try {
				System.out.print("Digite a data de nascimento: (dd/MM/yyyy)		");
				nascimento = formatarData.parse(scan.nextLine());
				break;
			} catch (ParseException e) {
				System.err.println("ERROR - Data de nascimento inválida");
			}
		}

		alunos[indice] = new Aluno(id, nascimento, ra, nome);
		indice++;
	}

	public void atualizar() {
		System.out.println("\n============================| ATUALIZAÇÃO |============================\n");
		System.out.printf("Digite o RA do aluno: ");
		ra = scan.nextLine();

		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] != null && ra.equals(alunos[i].getRa())) {

				id = alunos[i].getId();

				System.out.print("Digite o nome do aluno: ");
				nome = scan.nextLine();

				while (true) {
					try {
						System.out.print("Digite a data de nascimento: (dd/MM/yyyy)		");
						nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());
						break;
					} catch (ParseException e) {
						System.err.println("ERROR - Data de nascimento inválida");
					}
				}

				System.out.println("Dados atualizados com sucesso!");
				alunos[i] = new Aluno(id, nascimento, ra, nome);
				return;
			} 
		}
		System.err.println("ERROR - RA não cadastrado");
	}

	public void excluir() {
		System.out.println("\n============================| EXCLUSÃO |============================\n");
		System.out.printf("Digite o RA do aluno: ");
		ra = scan.nextLine();

		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] != null && ra.equals(alunos[i].getRa())) {
				alunos[i] = null;

				while (i < alunos.length - 1) {
					alunos[i] = alunos[i + 1];
					i++;
				}

				System.out.println("Dados excluidos com sucesso!");
				indice--;
				return;
			}
		}
		System.err.println("ERROR - RA não cadastrado");
		
	}

	public void exibir() {
		System.out.println("\n============================| EXIBIÇÃO |============================\n");
		System.out.printf("Digite o RA do aluno: ");
		ra = scan.nextLine();

		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] != null && ra.equals(alunos[i].getRa())) {
				System.out.println(alunos[i].toString());
				return;
			} 
		}
		System.err.println("ERROR - RA não cadastrado");
	}

	public void menu() {
		scan = new Scanner(System.in);

		while (true) {
			System.out.println("\n============================| Gestão de Alunos |============================\n");
			System.out.println("\n---------------------------------| Opções |---------------------------------\n");
			System.out.println("(C)riar \n(E)xibir \n(R)emover \n(A)tualizar \n\n(S)air");
			System.out.println("\n============================================================================\n");

			String textoMaiusculo = scan.nextLine().toUpperCase();
			char letra = textoMaiusculo.charAt(0);

			switch (letra) {
			case 'C':
				criar();
				break;
			case 'E':
				exibir();
				break;
			case 'R':
				excluir();
				break;
			case 'A':
				atualizar();
				break;
			case 'S':
				System.out.println("Programa Finalizado!");
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		GestaoAlunos gestaoAlunos = new GestaoAlunos();
		gestaoAlunos.menu();
	}
}