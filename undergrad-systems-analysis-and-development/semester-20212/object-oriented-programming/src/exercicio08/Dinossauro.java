package exercicio08;

public class Dinossauro {

	private int energia = 0;
	private int velocidade = 0;
	private int temperatura = 0;
	private int humor = 0;

	public void pular() {
		energia--;
		velocidade--;
		humor++;
		System.out.println("\nSkeep está pulando");
	}

	public void correr() {
		energia--;
		velocidade--;
		humor++;
		System.out.println("\nSkeep está correndo");
	}

	public void comer() {
		energia++;
		velocidade--;
		humor++;
		System.out.println("\nSkeep está comendo");
	}

	public void cantar() {
		energia--;
		humor++;
		System.out.println("\nSkeep está cantando");
	}

	public void tomarSol() {
		velocidade++;
		temperatura++;
		humor++;
		System.out.println("\nSkeep está tomando sol");
	}

	public void ficarNaSombra() {
		energia++;
		temperatura--;
		humor--;
		System.out.println("\nSkeep está na sombra");
	}

	public void status() {
		System.out.println("Energia: " + energia);
		System.out.println("Velocidade: " + velocidade);
		System.out.println("Temperatura: " + temperatura);
		System.out.println("Humor: " + humor);
	}

}