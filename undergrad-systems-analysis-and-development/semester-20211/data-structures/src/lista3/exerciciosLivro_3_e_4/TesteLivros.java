package lista3.exerciciosLivro_3_e_4;

import javax.swing.JOptionPane;

public class TesteLivros {
	
	public static void main(String[] args) {
		ExercicioPilhaLivros exercicioPilhaLivros = new ExercicioPilhaLivros(5);
		ExercicioFilaLivros exercicioFilaLivros = new ExercicioFilaLivros(5);
	
		int opcao = 0;
		String tituloExemplar;
		int quantidadeExemplares;
		
		while (opcao != 7) {
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite a opção desejada: \n"
					+ "1 - Adicionar Livro na Pilha\n"
					+ "2 - Remover Livro na Pilha\n"
					+ "3 - Exibir Livros da Pilha\n"
					+ "4 - Adicionar Livro na Fila\n"
					+ "5 - Remover Livro na Fila\n"
					+ "6 - Exibir Livros da Fila\n"
					+ "7 - Finalizar Programa!"
					));
			
			switch (opcao) {

			case 1:
				tituloExemplar = JOptionPane.showInputDialog("Digite o título do livro: ");
				quantidadeExemplares = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de exemplares do livro: "));
				exercicioPilhaLivros.adicionaLivroPilha(new Livro(tituloExemplar, quantidadeExemplares));
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "O livro removido foi:\n" + exercicioPilhaLivros.removeLivroPilha());
				break;

			case 3:
				JOptionPane.showMessageDialog(null, "Pilha - Livros: " + exercicioPilhaLivros.exibeLivrosPilha());
				break;				

			case 4:
				tituloExemplar = JOptionPane.showInputDialog("Digite o título do livro: ");
				quantidadeExemplares = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de exemplares: "));
				exercicioFilaLivros.adicionaLivroFila(new Livro(tituloExemplar, quantidadeExemplares));
				break;				

			case 5:
				JOptionPane.showMessageDialog(null, "O livro removido foi:\n" + exercicioFilaLivros.removeLivroFila());
				break;

			case 6:
				JOptionPane.showMessageDialog(null, "Fila - Livros: " + exercicioFilaLivros.exibeLivrosFila());
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
