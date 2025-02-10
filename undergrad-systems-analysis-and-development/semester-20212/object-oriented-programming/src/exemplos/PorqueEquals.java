package exemplos;

public class PorqueEquals {

	public static void main(String[] args) {

//		String a = "A";
//
//		String b = "A";
//
//		if (a == b) {
//			System.out.println("São Iguais");
//		} else {
//			System.out.println("São Diferentes");
//		}

		String a = "JOAO";

		String b = "JOAO";

		b = b + ""; // "JOAO"

		if (a == b) {
			System.out.println("São Iguais");
		} else {
			System.out.println("São Diferentes");
		}

	}

}