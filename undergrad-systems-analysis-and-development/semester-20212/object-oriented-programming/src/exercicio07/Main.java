package exercicio07;

public class Main {

	public static void main(String[] args) {

		Passageiro passageiro = new Passageiro("Fernanda", 14645157000L, 29, 60, 110, 0, "Business");
		Piloto piloto = new Piloto("Marcos", 26508849085L, 42, 80, 4451, 16054, "Piloto de linha aérea");
		Aeronave aeronave = new Aeronave(001, 144, "A319", "LATAM", "Airbus", piloto);
		Aeroporto aeroportoOrigem = new Aeroporto("GRU", "Aeroporto de São Paulo Cumbica", "São Paulo", 1, aeronave);
		Aeroporto aeroportoDestino = new Aeroporto("BSB", "Aeroporto Internacional de Brasília", "Brasília", 3,
				aeronave);

		passageiro.embarcando();
		passageiro.sentarLugar();
		passageiro.colocarCinto();
		piloto.embarcando();
		piloto.pilotando();
		aeronave.voando();
		aeroportoOrigem.levantandoVoo();
		piloto.avisarTurbulencia();
		aeroportoDestino.pousando();
		aeronave.desembarcando();

	}

}