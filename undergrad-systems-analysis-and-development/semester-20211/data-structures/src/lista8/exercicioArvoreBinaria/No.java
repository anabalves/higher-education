package lista8.exercicioArvoreBinaria;

public class No {
	public Integer elemento;
	public No esquerda;
	public No direita;
	
	public No() {
		esquerda = null;
		elemento = null;
		direita = null;	
	}
	
	public No(Integer elemento, No esquerda, No direita) {
		this.elemento = elemento;
		this.esquerda = esquerda;
		this.direita = direita;
	}

	public No(Integer elemento) {
		this.esquerda = null;
		this.elemento = elemento;
		this.direita = null;	
	}

	public Integer getElemento() {
		return elemento;
	}

	public void setElemento(Integer elemento) {
		this.elemento = elemento;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}
}