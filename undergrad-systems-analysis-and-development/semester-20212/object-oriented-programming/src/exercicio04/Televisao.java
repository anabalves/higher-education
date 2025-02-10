package exercicio04;

public class Televisao {

	boolean smartTV;
	String tipoDeTela;
	int tamanhoDaTela;
	String marca;
	String resolucaoDaImagem;
	String modelo;

	public Televisao(boolean smartTV, String tipoDeTela, int tamanhoDaTela, String marca, String resolucaoDaImagem,
			String modelo) {
		this.smartTV = smartTV;
		this.tipoDeTela = tipoDeTela;
		this.tamanhoDaTela = tamanhoDaTela;
		this.marca = marca;
		this.resolucaoDaImagem = resolucaoDaImagem;
		this.modelo = modelo;
	}

	public void ligarTelevisao() {
		System.out.println("Ligando a Televis�o!");
	}

	public void desligarTelevisao() {
		System.out.println("Desligando a Televis�o!");
	}

	public void mudarCanalTelevisao() {
		System.out.println("Mudando o canal da Televis�o!");
	}

	public String ehSmartTV(boolean smartTV) {
		String ehSmartTV = "";

		if (smartTV == true)
			ehSmartTV = "Smart TV";

		else
			ehSmartTV = "TV";

		return ehSmartTV;
	}

	@Override
	public String toString() {
		return ehSmartTV(smartTV) + " " + tipoDeTela + " " + tamanhoDaTela + "\" " + marca + " " + resolucaoDaImagem
				+ " " + modelo;
	}

}