package exercicio18;

public class Leitor implements Observer  {

	@Override
	public void update(Revista r) {
		System.out.println("Lendo o artigo " + r.artigo());
	}

}
