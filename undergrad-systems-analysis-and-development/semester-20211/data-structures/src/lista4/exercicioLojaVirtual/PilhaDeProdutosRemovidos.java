package lista4.exercicioLojaVirtual;

import javax.swing.JOptionPane;

public class PilhaDeProdutosRemovidos {
	
	//Associacao entre classes	
	private Produtos produtosRemovidos[];
	private int tamanho;

	public PilhaDeProdutosRemovidos(int capacidade) {
		produtosRemovidos = new Produtos[capacidade];
		tamanho = 0;
	}
	
	public boolean VerifVazia() {
		if (tamanho == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean VerifCheia() {
		if (tamanho == produtosRemovidos.length) {
			return true;
		} else {
			return false;
		}
	}


	public void AdicionarPilhaProdutosRemovidos(Produtos produto) {
		if (!VerifCheia()) {
			produtosRemovidos[tamanho] = produto;
			tamanho++;
		} else {
			JOptionPane.showMessageDialog(null, "A Pilha de Produtos está Cheia!");
		}
	}

	public String RemoverPilhaDeProdutosRemovidos() {
		Produtos produto = null;
		if (!VerifVazia()) {
			produto = produtosRemovidos[tamanho - 1];
			tamanho--;
			return "O Produto Removido Permanentemente da Fila foi " + produto;
		} else {
			return "A Pilha de Produtos Removidos está Vazia!";
		}
	}

	public String percorrePilhaDeProdutosRemovidos() {
		String aux = " ";
		for (int i = 0; i < tamanho; i++) {
			aux = aux + "\n" + produtosRemovidos[i].toString();
		}
		return aux;
	}

}
