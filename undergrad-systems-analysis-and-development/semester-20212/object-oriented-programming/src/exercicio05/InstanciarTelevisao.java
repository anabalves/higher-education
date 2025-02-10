package exercicio05;

import exercicio04.Televisao;

public class InstanciarTelevisao {

	public static void main(String[] args) {
		
		Televisao televisao01 = new Televisao(true, "OLED", 55, "LG" , "4K", "OLED55CXPSA");
		Televisao televisao02 = new Televisao(true, "LED", 50, "Samsung" , "4K","UN50TU8000GXZD");
		Televisao televisao03 = new Televisao(false, "LED", 43, "Philips" , "Full HD","43PFG5000");
		
		televisao01.toString();
		televisao01.ligarTelevisao();
		televisao01.mudarCanalTelevisao();
		televisao01.desligarTelevisao();
		System.out.println();
		
		televisao02.toString();
		televisao02.ligarTelevisao();
		televisao02.mudarCanalTelevisao();
		televisao02.desligarTelevisao();
		System.out.println();
		
		televisao03.toString();
		televisao03.ligarTelevisao();
		televisao03.mudarCanalTelevisao();
		televisao03.desligarTelevisao();
		
	}

}