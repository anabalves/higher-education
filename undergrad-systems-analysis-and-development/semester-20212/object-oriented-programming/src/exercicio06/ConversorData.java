package exercicio06;

public class ConversorData {

	int dia;
	int mes;
	int ano;
	int diaJuliano;

	public ConversorData(int dia, int mes, int ano) {
		
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		
	}

	public int dataJuliana() {
		
		return diaJuliano = (1461 * (ano + 4800 + (mes - 14) / 12)) / 4
				+ (367 * (mes - 2 - 12 * ((mes - 14) / 12))) / 12 - (3 * ((ano + 4900 + (mes - 14) / 12) / 100)) / 4
				+ dia - 32075;
		
	}

	public static void main(String[] args) {
		
		ConversorData dataGregoriana = new ConversorData(5, 8, 2016);
		System.out.print(dataGregoriana.dataJuliana());
		
	}

}