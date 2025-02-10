package lista4.exercicioDetran;

import javax.swing.JOptionPane;

public class Pilha {

	//Associacao entre classes	
	private Pessoas pessoas[];
	private int tamanho;

	public Pilha(int capacidade) {
		pessoas = new Pessoas[capacidade];
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
		if (tamanho == pessoas.length) {
			return true;
		} else {
			return false;
		}
	}

	public void AdicionarPilha(Pessoas pessoa) {
		if (!VerifCheia()) {
			pessoas[tamanho] = pessoa;
			tamanho++;
		} else {
			JOptionPane.showMessageDialog(null, "A Pilha de Pessoas Removidas está Cheia!");
		}
	}

	public String RemoverPilha() {
		Pessoas pessoa = null;
		if (!VerifVazia()) {
			pessoa = pessoas[tamanho - 1];
			tamanho--;
			return "A Pessoa Removida Permanentemente da Fila foi " + pessoa;
		} else {
			return "A Pilha de Pessoas Removidas está Vazia!";
		}
	}

	public String percorrePilha() {
		String aux = " ";
		for (int i = 0; i < tamanho; i++) {
			aux = aux + "\n" + pessoas[i].toString();
		}
		return aux;
	}

}
