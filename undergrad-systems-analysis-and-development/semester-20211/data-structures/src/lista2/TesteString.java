package lista2;

public class TesteString {

	private String listaString[];
	private int tamanhoListaString;

	public TesteString() {
		listaString = new String[4];
		tamanhoListaString = 0;
	}

	public boolean verificaListaVazia() {
		boolean listaVazia;

		if (tamanhoListaString == 0) {
			listaVazia = true;
		} else {
			listaVazia = false;
		}

		return listaVazia;
	}

	public boolean verificaListaCheia() {
		boolean listaCheia;

		if (tamanhoListaString > listaString.length) {
			listaCheia = true;
		} else {
			listaCheia = false;
		}

		return listaCheia;
	}

	public String adicionaStringInicio(String string) {
		if (tamanhoListaString < listaString.length) {

			for (int i = tamanhoListaString; i > 0; i--) {
				listaString[i] = listaString[i - 1];
			}

			listaString[0] = string;
			tamanhoListaString++;

			return "Success: String adicionada! A String _" + string + "_ foi adicionada no inicio lista";
		} else {
			return "Error: a lista está cheia!";
		}
	}

	public String adicionaStringFinal(String string) {
		if (tamanhoListaString < listaString.length) {
			listaString[tamanhoListaString] = string;
			tamanhoListaString++;

			return "Success: String adicionada! A String _" + string + "_ foi adicionada no final da lista";
		} else {
			return "Error: a lista está cheia!";
		}
	}

	public String adicionaStringPosicaoEspecifica(String string, int posicao) {
		int i;

		if ((tamanhoListaString < listaString.length) && (posicao < tamanhoListaString + 1) && (posicao >= 0)) {

			for (i = tamanhoListaString; i != posicao; i--) {

				if (i != 0) {
					listaString[i] = listaString[i - 1];
				}

			}
			listaString[i] = string;
			tamanhoListaString++;

			return "Success: String adicionada! A String _" + string + "_ foi adicionada na " + posicao
					+ "ª posição da lista";
		} else {
			return "Error: posição do vetor inválida ou a lista está cheia!";
		}
	}

	public String removeStringInicio() {
		String retorno = null;

		if (tamanhoListaString > 0) {
			retorno = listaString[0];

			for (int i = 1; i < tamanhoListaString; i++) {
				listaString[i - 1] = listaString[i];
			}
			tamanhoListaString--;

			return "Success: String removida! A String _" + retorno + "_ foi removida do inicio da lista.";
		} else {
			return "Error: a lista está vazia, retorno vazio!";
		}
	}

	public String removeStringFinal() {
		String retorno = null;

		if (tamanhoListaString > 0) {
			retorno = listaString[tamanhoListaString - 1];

			for (int i = 0; i < tamanhoListaString; i++) {
				if (i == tamanhoListaString - 1) {
					tamanhoListaString--;
				}
			}
			return "Success: String removida! A String _" + retorno + "_ foi removida do final da lista.";
		} else {
			return "Error: a lista está vazia, retorno vazio!";
		}
	}

	public String removeStringPosicaoEspecifica(int posicao) {
		String retorno = null;
		int i;

		if ((tamanhoListaString > 0) && (posicao < tamanhoListaString) && (posicao >= 0)) {
			retorno = listaString[posicao];

			for (i = posicao; i < tamanhoListaString - 1; i++) {
				listaString[i] = listaString[i + 1];
			}
			tamanhoListaString--;

			return "Success: String removida! A String _" + retorno + "_ foi removida da " + posicao
					+ "ª posição da lista!";
		} else {
			return "Error: posição do vetor inválida ou a lista está vazia!";
		}
	}

	public String concatenaElementosString() {
		String strings = " ";

		for (int i = 0; i < tamanhoListaString; i++) {
			strings = strings + " " + listaString[i];

		}

		return strings;

	}

}
