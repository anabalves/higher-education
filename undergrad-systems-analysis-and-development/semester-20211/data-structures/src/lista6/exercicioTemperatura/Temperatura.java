package lista6.exercicioTemperatura;

public class Temperatura {

	private Temperatura proximo;
	private double temperatura;

	public Temperatura getProximo() {
		return proximo;
	}

	public void setProximo(Temperatura proximo) {
		this.proximo = proximo;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

}
