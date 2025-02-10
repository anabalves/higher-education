package lista3.exercicios_1_e_2;

import javax.swing.JOptionPane;

public class ExercicioFila {

	private static int fila[];
	private static int tamanho;
	private static int inicioFila = 0;
	private static int proximaPosicao;
	
	public ExercicioFila() {                       
		fila = new int[5];                    
		tamanho = 0;                            
	}

	public void adicionaFila(int numero) {
		if (tamanho < fila.length) {
			fila[proximaPosicao] = numero;
			tamanho++;
			proximaPosicao++;
			if (proximaPosicao==5) {
				proximaPosicao=0;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Fila cheia!");
		}
	}

	public int removeFila() {
		int removido = 0;
		if (fila.length >= 1 && tamanho > 0) {
			removido = fila[inicioFila];
			fila[inicioFila] = 0;
			tamanho--;
			inicioFila++;
			if (inicioFila == 5) {
				inicioFila = 0;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Fila vazia!");
		}
		JOptionPane.showMessageDialog(null, "O número removido foi:\n" + removido);
		return removido;
	}

	public String exibeFila() {
		String aux = " ";
		for (int i = 0; i < tamanho; i++) {
			aux = aux + "\n" + fila[i];
		}
		return aux;
	}

}
