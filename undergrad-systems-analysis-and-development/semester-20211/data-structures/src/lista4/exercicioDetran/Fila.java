package lista4.exercicioDetran;

import javax.swing.JOptionPane;

public class Fila {

	//Associacao entre classes	
	private Pessoas pessoas[];
	private int tamanho;

	public Fila(int capacidade){
		pessoas = new Pessoas[capacidade];
		tamanho = 0;
	}
	
	public boolean VerifVazia() {
		if (tamanho == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean VerifCheia(){
		if (tamanho == pessoas.length){
			return true;
		}

		else{
			return false;
		}
	}

	public void AdicionarFila(Pessoas pessoa){
		if (!VerifCheia()) {
			pessoas[tamanho] = pessoa;
			tamanho++;
		} else {
			JOptionPane.showMessageDialog(null, "A Fila está cheia!");
		}
	}

	public Pessoas RemoverFila() {
		Pessoas pessoa = null;
		if (!VerifVazia()) {
			pessoa = pessoas[0];
			for (int i = 0; i < tamanho - 1; i++){
				pessoas[i] = pessoas[i + 1];
			}
			tamanho--;
		}
		return pessoa;
	}
	
	public String percorreFila() {
		String aux = " ";
		for (int i = 0; i < tamanho; i++) {
			aux = aux + "\n" + pessoas[i].toString();
		}
		return aux;
	}

	public String ordemEsperaFila(int ordemEspera) {
		Pessoas retorno = null;

		if ((tamanho > 0) && (ordemEspera < tamanho) && (ordemEspera >= 0)) {
			retorno = pessoas[ordemEspera];
			
			return "A pessoa  " + retorno + "\nestá na posição " + (ordemEspera + 1) + "º da Fila (ordem de espera).";
		} else {
			return "Posição do vetor inválida!";
		}
	}
	
}
