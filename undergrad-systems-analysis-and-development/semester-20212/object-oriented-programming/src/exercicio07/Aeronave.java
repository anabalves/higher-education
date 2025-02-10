package exercicio07;

public class Aeronave {

	private int numero;
	private int capacidade;
	private String modelo;
	private String companhia;
	private String fabricante;
	private Piloto piloto;
	
	public Aeronave(int numero, int capacidade, String modelo, String companhia, String fabricante, Piloto piloto) {
		this.numero = numero;
		this.capacidade = capacidade;
		this.modelo = modelo;
		this.companhia = companhia;
		this.fabricante = fabricante;
		this.piloto = piloto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCompanhia() {
		return companhia;
	}

	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public Piloto getPiloto() {
		return piloto;
	}
	
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	   
	public void voando() {
		System.out.println("O avião " + numero + ", da companhia " + companhia + ", levantou voo, com o piloto "
				+ piloto.getNome());
	}

	public void desembarcando() {
		System.out.println("Os passageiros do avião " + numero + " desembarcaram.");
	}

}