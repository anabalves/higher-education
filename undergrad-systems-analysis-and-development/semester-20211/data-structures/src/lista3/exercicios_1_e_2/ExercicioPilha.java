package lista3.exercicios_1_e_2;

import javax.swing.JOptionPane;

public class ExercicioPilha {
	
	private int pilha[];
	private int tamanho;
	
	public ExercicioPilha() {
		pilha = new int[5];
		tamanho = 0;
	}

	public void adicionaPilha(int numero) {
		if (tamanho < pilha.length) {
			pilha[tamanho] = numero;
			tamanho++;
		} else {
			JOptionPane.showMessageDialog(null, "Pilha cheia!");
		}
	}

	public int removePilha() {
		int removido = 0;
		if (tamanho >= 1) {
			removido = pilha[tamanho - 1];
			pilha[tamanho - 1] = 0;
			tamanho--;
		} else {
			JOptionPane.showMessageDialog(null, "Pilha vazia!");
		}
		JOptionPane.showMessageDialog(null, "O número removido foi:\n" + removido);
		return removido;
	}

	public String exibePilha() {
		String aux = " ";
		for (int i = 0; i < tamanho; i++) {
			aux = aux + "\n" + pilha[i];
		}
		return aux;
	}

}
