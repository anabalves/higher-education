package video;

public class TesteTelevisao {

	public static void main(String[] args) {
		
		Televisao t1 = new Televisao(55, "LG", "lg55");
//		t1.tamanho = 55;
//		t1.marca = "LG";
//		t1.modelo = "lg55";
		
		Televisao t2 = new Televisao(50, "Samsung", "samsung50");
//		t2.tamanho = 50;
//		t2.marca = "Samsung";
//		t2.modelo = "samsung50";
		
		t1.ligar();
		t2.ligar();
		
		System.out.print("Televisao " + t1 + " esta ");
		System.out.println(t1.isLigada() ? "ligada" : "desligada");
		
		System.out.print("Televisao " + t2 + " esta ");
		System.out.println(t2.isLigada() ? "ligada" : "desligada");		
		
		t1.mudarCanal(10);
		t1.aumentarVolume(3);
		t2.mudarCanal(7);
		t2.diminuirVolume(5);
		
		System.out.println("Desligando Televisao " + t1);
		t1.desligar();
		System.out.println("Desligando Televisao " + t2);
		t2.desligar();
	}

}
