package exercicio05;

import exercicio04.Notebook;

public class InstanciarNotebook {

	public static void main(String[] args) {
		
		Notebook notebook01 = new Notebook("Notebook", "AN515-54-574Q", "Acer", "Intel Core i5 9300H", 8, "GeForce GTX 1650", true, 512, 15.6, "Endless OS");
		Notebook notebook02 = new Notebook("Macbook", "Pro", "Apple", "M1", 8, "Integrada (On-Board)", true, 512, 13.0, "Mac OS");
		Notebook notebook03 = new Notebook("Ultrabook", "UX330UA", "Asus", "Intel Core i5 6200U", 8, "Integrada (On-Board)", false, 1000, 13.3, "Windows 10 Home");
		
		System.out.println(notebook01.toString());
		notebook01.ligarNotebook();
		notebook01.reiniciarNotebook();
		notebook01.desligarNotebook();
		System.out.println();
		
		System.out.println(notebook02.toString());
		notebook02.ligarNotebook();
		notebook02.reiniciarNotebook();
		notebook02.desligarNotebook();
		System.out.println();
		
		System.out.println(notebook03.toString());
		notebook03.ligarNotebook();
		notebook03.reiniciarNotebook();
		notebook03.desligarNotebook();

	}

}
