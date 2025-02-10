package exercicio07;

public class Pessoa {

	private String nome;
	private long cpf;
	private int idade;
	private float peso;

	public Pessoa(String nome, long cpf, int idade, float peso) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void embarcando() {
		System.out.println(nome + " embarcou no avião");
	}

}