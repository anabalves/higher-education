package lista4.exercicioLojaVirtual;

import javax.swing.JOptionPane;

public class PilhaPrincipalDeProdutos {

	//Associacao entre classes	
	private Produtos produtos[];
	private int tamanho;

	public PilhaPrincipalDeProdutos(int capacidade) {
		produtos = new Produtos[capacidade];
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
		if (tamanho == produtos.length) {
			return true;
		} else {
			return false;
		}
	}

	public void AdicionarPilhaPrincipal(Produtos produto) {
		if (!VerifCheia()) {
			produtos[tamanho] = produto;
			tamanho++;
		} else {
			JOptionPane.showMessageDialog(null, "A Pilha de Produtos está Cheia!");
		}
	}

	public Produtos RemoverPilhaPrincipal() {
		Produtos produto = null;
		if (!VerifVazia()) {
			produto = produtos[tamanho - 1];
			tamanho--;
		}
		return produto;
	}

	public String percorrePrincipalProdutos() {
		String aux = " ";
		for (int i = 0; i < tamanho; i++) {
			aux = aux + "\n" + produtos[i].toString();
		}
		return aux;
	}

	public String ordemEsperaPilha(int ordemEspera) {
		Produtos retorno = null;

		if ((tamanho > 0) && (ordemEspera < tamanho) && (ordemEspera >= 0)) {
			retorno = produtos[ordemEspera];

			return "O produto " + retorno + "\nestá na posição " + (ordemEspera + 1) + "º da Pilha (ordem de espera).";
		} else {
			return "Error: posição do vetor inválida ou a Pilha está vazia!";
		}
	}

	public void pesquisaNome(String nomeProduto) {
		for (int i = 0; i < tamanho; i++) {
			if (produtos[i].getNome().equals(nomeProduto)) {
				JOptionPane.showMessageDialog(null, "O produto " + produtos[i] + "\nexiste na Pilha!.");
			} else {
				JOptionPane.showMessageDialog(null, "O produto não existe na Pilha!");
			}
		}
	}
}