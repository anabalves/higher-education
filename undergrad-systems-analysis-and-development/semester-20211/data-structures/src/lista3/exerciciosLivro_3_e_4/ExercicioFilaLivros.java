package lista3.exerciciosLivro_3_e_4;

import javax.swing.JOptionPane;

public class ExercicioFilaLivros {
	
	private int tamanho;
	private Livro livros[];
	
	public ExercicioFilaLivros(int capacidade) {
		livros = new Livro[capacidade];
		tamanho = 0;
	}

	public void adicionaLivroFila(Livro livro) {
		if (tamanho < livros.length) {
			livros[tamanho] = livro;
			tamanho++;
		} else {
			JOptionPane.showMessageDialog(null, "Fila de livros cheia!");
		}
	}
	
	public Livro removeLivroFila() {
		Livro retorno = null;
		if (tamanho >= 1) {
			retorno = livros[0];
			for (int i = 0; i < tamanho - 1; i++) {
				livros[i] = livros[i + 1];
			}
			tamanho--;
		} else {
			JOptionPane.showMessageDialog(null, "Fila de livros vazia!");
		}
		return retorno;
	}
	
	public String exibeLivrosFila() {
		String aux = " ";
		for (int i = 0; i < tamanho; i++) {
			aux = aux + "\n" + livros[i].toString();
		}
		return aux;
	}


}
