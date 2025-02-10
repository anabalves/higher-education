package exercicio07;

public class Aeroporto {

	private String sigla;
	private String nome;
	private String localizacao;
	private int numeroPista;
	Aeronave aeronave;
	
	public Aeroporto(String sigla, String nome, String localizacao, int numeroPista, Aeronave aeronave) {
		this.sigla = sigla;
		this.nome = nome;
		this.localizacao = localizacao;
		this.numeroPista = numeroPista;
		this.aeronave = aeronave;
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getNumeroPista() {
		return numeroPista;
	}

	public void setNumeroPista(int numeroPista) {
		this.numeroPista = numeroPista;
	}

	public void levantandoVoo() {
		System.out.println("O avião " + aeronave.getNumero() + " saiu de " + localizacao + 
				", no Aeroporto " + nome + ", na pista " + numeroPista );
	}
	
	public void pousando() {
		System.out.println("O avião " + aeronave.getNumero() + " pousou em " + localizacao + 
				", no Aeroporto " + nome + ", na pista " + numeroPista );
	}

}