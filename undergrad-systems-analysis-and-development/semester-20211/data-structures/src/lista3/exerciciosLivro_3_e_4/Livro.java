package lista3.exerciciosLivro_3_e_4;

public class Livro {
	
	private String tituloExemplar;
	private int quantidadeExemplares;
	
	public Livro(String tituloExemplar, int quantidadeExemplares) {
		this.tituloExemplar = tituloExemplar;
		this.quantidadeExemplares = quantidadeExemplares;
	}
	
	public String getTituloExemplar() {
		return tituloExemplar;
	}
	public void setTituloExemplar(String tituloExemplar) {
		this.tituloExemplar = tituloExemplar;
	}
	public int getQuantidadeExemplares() {
		return quantidadeExemplares;
	}
	public void setQuantidadeExemplares(int quantidadeExemplares) {
		this.quantidadeExemplares = quantidadeExemplares;
	}
	
	public String toString() {
		String aux = "Título: " + this.tituloExemplar + "  \n Quantidade de exemplares: " + this.quantidadeExemplares + "\n";
		return aux;
	}
	
}
