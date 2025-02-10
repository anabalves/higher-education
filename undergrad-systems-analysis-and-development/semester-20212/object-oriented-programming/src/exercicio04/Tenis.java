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
		System.out.println("Amarrando o t�nis!");
	}

	public void desamarrarTenis() {
		System.out.println("Desamarrando o t�nis!");
	}

	public void estahLimpo(boolean limpo) {
		if (limpo) {
			System.out.println("N�o precisa limpar o t�nis, j� est� limpo!");
		} else {
			System.out.println("O t�nis est� muito sujo, precisa limpar!");
		}
	}

	@Override
	public String toString() {
		return "T�nis " + marca + " " + modelo + " para " + uso + " " + genero + " "
				+ tamanho + " pisada " + tipoDePisada + " fechamento com " + modoDeFechar;
	}
	
}