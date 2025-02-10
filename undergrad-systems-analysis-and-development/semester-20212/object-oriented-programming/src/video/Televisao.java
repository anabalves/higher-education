package video;

public class Televisao {
	
	// Caracteristicas
	private int tamanho;
	private String marca;
	private String modelo;
	private boolean ligada;
	
	// Construtores
	
	public Televisao(int tamanho, String marca, String modelo) {
		this.tamanho = tamanho;
		this.marca = marca;
		this.modelo = modelo;
	}

	// Comportamentos
	void ligar() {
		System.out.println("Ligando a televisao");
		ligada = true;
	}
	
	void desligar() {
		System.out.println("Desligando... Obrigada por utilizar a televisao!");
		ligada = false;
	}
	
	void aumentarVolume(int volume) {
		System.out.println("Aumentando o volume em " + volume);
	}

	void diminuirVolume(int volume) {
		System.out.println("Diminuindo o volume em " + volume);
	}
	
	void mudarCanal(int canal) {
		System.out.println("Mudando para o canal " + canal);
	}
	
	public String toString() {
		return marca + " " + tamanho + "\" " + modelo;
	}
	
	// Encapsulamento
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isLigada() {
		return ligada;
	}

	public void setLigada(boolean ligada) {
		this.ligada = ligada;
	}
}