package exercicio07;

public class Passageiro extends Pessoa {

	private int numeroAssento;
	private int numeroPassaporte;
	private String classe;

	public Passageiro(String nome, long cpf, int idade, float peso, int numeroAssento, int numeroPassaporte,
			String classe) {
		super(nome, cpf, idade, peso);
		this.numeroAssento = numeroAssento;
		this.numeroPassaporte = numeroPassaporte;
		this.classe = classe;
	}
	
	public int getNumeroAssento() {
		return numeroAssento;
	}

	public void setNumeroAssento(int numeroAssento) {
		this.numeroAssento = numeroAssento;
	}

	public int getNumeroPassaporte() {
		return numeroPassaporte;
	}

	public void setNumeroPassaporte(int numeroPassaporte) {
		this.numeroPassaporte = numeroPassaporte;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public void sentarLugar() {
		System.out.println("O(A) passageiro(a) " + getNome() + " está localizado(a) no assento " + numeroAssento + ", na classe " + classe);
	}
	
	public void colocarCinto() {
		System.out.println("O(A) passageiro(a) " + getNome() + " colocou o cinto de segurança!");
	}

}