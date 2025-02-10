package lista3.exerciciosLivro_3_e_4;

import javax.swing.JOptionPane;

public class ExercicioPilhaLivros {
	private int tamanho;
	private Livro livros[];

	public ExercicioPilhaLivros(int capacidade) {
		livros = new Livro[capacidade];
		tamanho = 0;
	}
	
	public void adicionaLivroPilha(Livro livro) {
		if (tamanho < livros.length) {
			livros[tamanho] = livro;
			tamanho++;
		} else {
			JOptionPane.showMessageDialog(null, "Pilha de livros cheia!");
		}
		
	}

	public Livro removeLivroPilha() {
		Livro livro =  null;
		if (tamanho > 0) {
			livro = livros[tamanho - 1];
			tamanho--;
		} else {
			JOptionPane.showMessageDialog(null, "Pilha de livros vazia!");
		}
		return (livro);
	}

	public String exibeLivrosPilha() {
		String aux = " ";
		for (int i = 0; i < tamanho; i++) {
			aux = aux + "\n" + livros[i].toString();
		}
		return aux;
	}

}
