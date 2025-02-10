package lista3.exercicios_1_e_2;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {
		
		ExercicioPilha exercicioPilha = new ExercicioPilha();
		ExercicioFila exercicioFila = new ExercicioFila();
		
		int opcao = 0;
		int numero;
		
		while (opcao != 7) {
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite a opção desejada: \n"
					+ "1 - Adicionar na Pilha\n"
					+ "2 - Remover na Pilha (e adicionar na Fila)\n"
					+ "3 - Exibir Pilha\n"
					+ "4 - Adicionar na Fila\n"
					+ "5 - Remover na Fila (e adicionar na Pilha)\n"
					+ "6 - Exibir Fila\n"
					+ "7 - Finalizar Programa!"
					));
			
			switch (opcao) {

			case 1:
				exercicioPilha.adicionaPilha(Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro para ser adicionado a Pilha: ")));
				break;

			case 2:
				numero = exercicioPilha.removePilha();
				exercicioFila.adicionaFila(numero);
				break;

			case 3:
				JOptionPane.showMessageDialog(null, "Pilha " + exercicioPilha.exibePilha());
				break;				

			case 4:
				exercicioFila.adicionaFila(Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro para ser adicionado a Fila: ")));
				break;				

			case 5:
				numero = exercicioFila.removeFila();
				exercicioPilha.adicionaPilha(numero);
				break;

			case 6:
				JOptionPane.showMessageDialog(null, "Fila " + exercicioFila.exibeFila());
				break;

			case 7:
				JOptionPane.showMessageDialog(null, "Programa Finalizado com sucesso!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida");
				break;
			
			}
		}
		
	}
	
}
