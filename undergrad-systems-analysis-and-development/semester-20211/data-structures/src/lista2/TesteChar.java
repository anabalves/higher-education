package lista2;

public class TesteChar {

	private char listaChar[];
	private int tamanhoListaChar;

	public TesteChar() {
		listaChar = new char[4];
		tamanhoListaChar = 0;
	}

	public boolean verificaListaVazia() {
		boolean listaVazia;

		if (tamanhoListaChar == 0) {
			listaVazia = true;
		} else {
			listaVazia = false;
		}

		return listaVazia;
	}

	public boolean verificaListaCheia() {
		boolean listaCheia;

		if (tamanhoListaChar > listaChar.length) {
			listaCheia = true;
		} else {
			listaCheia = false;
		}

		return listaCheia;
	}

	public String adicionaCaracterInicio(char caractere) {
		if (tamanhoListaChar < listaChar.length) {

			for (int i = tamanhoListaChar; i > 0; i--) {
				listaChar[i] = listaChar[i - 1];
			}

			listaChar[0] = caractere;
			tamanhoListaChar++;

			return "Success: Caractere adicionado! O Caractere _" + caractere + "_ foi adicionado no inicio lista";
		} else {
			return "Error: a lista está cheia!";
		}
	}

	public String adicionaCaracterFinal(char caractere) {
		if (tamanhoListaChar < listaChar.length) {
			listaChar[tamanhoListaChar] = caractere;
			tamanhoListaChar++;

			return "Success: Caractere adicionado! O Caractere _" + caractere + "_ foi adicionado no final da lista";
		} else {
			return "Error: a lista está cheia!";
		}
	}

	public String adicionaCaracterPosicaoEspecifica(char caractere, int posicao) {
		int i;

		if ((tamanhoListaChar < listaChar.length) && (posicao < tamanhoListaChar + 1) && (posicao >= 0)) {

			for (i = tamanhoListaChar; i != posicao; i--) {

				if (i != 0) {
					listaChar[i] = listaChar[i - 1];
				}

			}
			listaChar[i] = caractere;
			tamanhoListaChar++;

			return "Success: Caractere adicionado! O Caractere _" + caractere + "_ foi adicionado na " + posicao
					+ "ª posição da lista";
		} else {
			return "Error: posição do vetor inválida ou a lista está cheia!";
		}
	}

	public String removeCaracterInicio() {
		char caractere;

		if (tamanhoListaChar > 0) {
			caractere = listaChar[0];

			for (int i = 1; i < tamanhoListaChar; i++) {
				listaChar[i - 1] = listaChar[i];
			}
			tamanhoListaChar--;

			return "Caractere removido! O Caractere _" + caractere + "_ foi removido do inicio da lista.";
		} else {
			return "Error: a lista está vazia, retorno vazio!";
		}
	}

	public String removeCaracterFinal() {
		char caractere;

		if (tamanhoListaChar > 0) {
			caractere = listaChar[tamanhoListaChar - 1];

			for (int i = 0; i < tamanhoListaChar; i++) {
				if (i == tamanhoListaChar - 1) {
					tamanhoListaChar--;
				}
			}
			return "Success: Caractere removido! O Caractere _" + caractere + "_ foi removido do final da lista.";
		} else {
			return "Error: a lista está vazia, retorno vazio!";
		}
	}

	public String removeCaracterPosicaoEspecifica(int posicao) {
		char caractere;
		int i;

		if ((tamanhoListaChar > 0) && (posicao < tamanhoListaChar) && (posicao >= 0)) {
			caractere = listaChar[posicao];

			for (i = posicao; i < tamanhoListaChar - 1; i++) {
				listaChar[i] = listaChar[i + 1];
			}
			tamanhoListaChar--;

			return "Success: Caractere removido! O Caractere _" + caractere + "_ foi removido da " + posicao
					+ "ª posição da lista!";
		} else {
			return "Error: posição do vetor inválida ou a lista está vazia!";
		}
	}

	public String concatenaElementosString() {
		String caracteres = " ";

		for (int i = 0; i < tamanhoListaChar; i++) {
			caracteres = caracteres + " " + listaChar[i];
		}

		return caracteres;

	}

}
