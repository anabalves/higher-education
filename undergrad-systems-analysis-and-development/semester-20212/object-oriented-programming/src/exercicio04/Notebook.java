package exercicio04;

public class Notebook {

	String tipo;
	String modelo;
	String marca;
	String processador;
	int memoriaRAM;
	String placaDeVideo;
	boolean possuiSsd;
	int capacidadeHDSSD;
	double tamanhoDaTela;
	String sistemaOperacional;

	public Notebook(String tipo, String modelo, String marca, String processador, int memoriaRAM, String placaDeVideo,
			boolean possuiSsd, int capacidadeHDSSD, double tamanhoDaTela, String sistemaOperacional) {
		this.tipo = tipo;
		this.modelo = modelo;
		this.marca = marca;
		this.processador = processador;
		this.memoriaRAM = memoriaRAM;
		this.placaDeVideo = placaDeVideo;
		this.possuiSsd = possuiSsd;
		this.capacidadeHDSSD = capacidadeHDSSD;
		this.tamanhoDaTela = tamanhoDaTela;
		this.sistemaOperacional = sistemaOperacional;
	}

	public void ligarNotebook() {
		System.out.println("Ligando o notebook!");
	}

	public void desligarNotebook() {
		System.out.println("Desligando o notebook!");
	}

	public void reiniciarNotebook() {
		System.out.println("Reiniciando o notebook!");
	}

	public String ehSsdOuHd(boolean possuiSsd) {
		String ehSsdOuHd = "";

		if (possuiSsd == true)
			ehSsdOuHd = "SSD";

		else
			ehSsdOuHd = "HD";

		return ehSsdOuHd;
	}

	@Override
	public String toString() {
		return tipo + " " + modelo + " " + marca + " " + processador + " " + memoriaRAM + "GB\nPlaca de vídeo "
				+ placaDeVideo + " " + ehSsdOuHd(possuiSsd) + " " + capacidadeHDSSD + " GB " + " " + tamanhoDaTela + "\" "
				+ sistemaOperacional;
	}

}