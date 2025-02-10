package exercicio04;

public class Tenis {

	String marca;
	String modelo;
	String uso;
	String genero;
	int tamanho;
	String tipoDePisada;
	String modoDeFechar;
	boolean limpo;
	
	public Tenis(String marca, String modelo, String uso, String genero, int tamanho, String tipoDePisada, String modoDeFechar) {
		this.marca = marca;
		this.modelo = modelo;
		this.uso = uso;
		this.genero = genero;
		this.tamanho = tamanho;
		this.tipoDePisada = tipoDePisada;
		this.modoDeFechar = modoDeFechar;
	}

	public void amarrarTenis() {
		System.out.println("Amarrando o tênis!");
	}

	public void desamarrarTenis() {
		System.out.println("Desamarrando o tênis!");
	}

	public void estahLimpo(boolean limpo) {
		if (limpo) {
			System.out.println("Não precisa limpar o tênis, já está limpo!");
		} else {
			System.out.println("O tênis está muito sujo, precisa limpar!");
		}
	}

	@Override
	public String toString() {
		return "Tênis " + marca + " " + modelo + " para " + uso + " " + genero + " "
				+ tamanho + " pisada " + tipoDePisada + " fechamento com " + modoDeFechar;
	}
	
}