package exercicio07;

public class Piloto extends Pessoa {
	
	private int breve;
	private int horasVoo;
	private String licenca;
	
	public Piloto(String nome, long cpf, int idade, float peso, int breve, int horasVoo, String licenca) {
		super(nome, cpf, idade, peso);
		this.breve = breve;
		this.horasVoo = horasVoo;
		this.licenca = licenca;
	}
	
	public int getBreve() {
		return breve;
	}
	public void setBreve(int breve) {
		this.breve = breve;
	}
	
	public int getHorasVoo() {
		return horasVoo;
	}
	
	public void setHorasVoo(int horasVoo) {
		this.horasVoo = horasVoo;
	}
	
	public String getCategoria() {
		return licenca;
	}
	
	public void setCategoria(String categoria) {
		this.licenca = categoria;
	}

	public void pilotando() {
		System.out.println("O piloto " + getNome() + " está pilotando o avião");
	}
	
	public void avisarTurbulencia() {
		System.out.println("O piloto " + getNome() + " fala \"Passageiros estamos entrando numa turbulência!\"");
	}

}