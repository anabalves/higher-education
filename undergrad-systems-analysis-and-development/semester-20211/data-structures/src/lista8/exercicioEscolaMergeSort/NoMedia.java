package lista8.exercicioEscolaMergeSort;

public class NoMedia {
	private NoMedia anterior;
	private NoMedia proximo;
	private Media media;
	
	public NoMedia() {
		this.media = null;
		this.proximo = null;
		this.anterior = null;
	}

	public NoMedia(Media media) {
		this.media = media;
		this.proximo = null;
		this.anterior = null;
	}

	public NoMedia getAnterior() {
		return anterior;
	}

	public void setAnterior(NoMedia anterior) {
		this.anterior = anterior;
	}

	public NoMedia getProximo() {
		return proximo;
	}

	public void setProximo(NoMedia proximo) {
		this.proximo = proximo;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}
}
