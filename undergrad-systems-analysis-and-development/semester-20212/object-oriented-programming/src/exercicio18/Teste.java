package exercicio18;

public class Teste {

	public static void main(String[] args) {
		
		SuperInteressante superInteressante = new SuperInteressante();
		Leitor leitor = new Leitor();

		superInteressante.registrar(leitor);

		superInteressante.publicarArtigo("Fatec ZL faz parceria com o MIT para desenvolvimento de novas tecnologias");
	
	}

}