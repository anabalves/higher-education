package exercicio05;

import exercicio04.Tenis;

public class InstanciarTenis {

	public static void main(String[] args) {
		
		Tenis tenis01 = new Tenis("Mizuno", "Wave Prophecy 8", "Corrida", "Feminino", 37, "Supinada", "Cadarço");
		Tenis tenis02 = new Tenis("Asics", "Gel Kayano 25", "Corrida", "Masculino", 42, "Pronada", "Cadarço");
		Tenis tenis03 = new Tenis("Adidas", "Ultra Boost", "Corrida", "Masculino", 42, "Neutra", "Cadarço");
		
		System.out.println(tenis01.toString());
		tenis01.amarrarTenis();
		tenis01.desamarrarTenis();
		tenis01.estahLimpo(false);
		System.out.println();
		
		System.out.println(tenis02.toString());
		tenis02.amarrarTenis();
		tenis02.desamarrarTenis();
		tenis02.estahLimpo(true);
		System.out.println();
		
		System.out.println(tenis03.toString());
		tenis03.amarrarTenis();
		tenis03.desamarrarTenis();
		tenis03.estahLimpo(false);

	}

}
