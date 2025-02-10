package lista4.exercicioLojaVirtual;

public class Produtos {
	
	private int ID;
	private String nome;
	private double valor;
	private int quantidade;
	
	public Produtos(int iD, String nome, double valor, int quantidade) {
		this.ID = iD;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getID() {
		return (ID);
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getNome() {
		return (nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return (valor);
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return (quantidade);
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String toString(){
		String retorno = "ID: "+ this.ID + ", Nome: "+ this.nome + ", Valor: " + this.valor + ", Quantidade: " + this.quantidade;
		return retorno;
	}

}
