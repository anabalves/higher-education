package exercicio18;

public class SuperInteressante implements Revista, Subject {
	
	private String artigo;
	private Observer observer;

	public void publicarArtigo(String artigo) {
		this.artigo = artigo;
		notificar();
	}

	@Override
	public void notificar() {
		observer.update(this);
	}

	@Override
	public void registrar(Observer o) {
		observer = o;
	}

	@Override
	public String artigo() {
		return artigo;
	}

}
