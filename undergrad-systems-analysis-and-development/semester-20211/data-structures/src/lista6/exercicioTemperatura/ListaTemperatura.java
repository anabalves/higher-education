package lista6.exercicioTemperatura;

import javax.swing.JOptionPane;

public class ListaTemperatura {

	private Temperatura inicio;

	public ListaTemperatura() {
		this.inicio = null;
	}

	// M�todo para verificar se a lista est� vazia
	public boolean VerificaListaVazia() {
		if (this.inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	// M�todo para adicionar uma temperatura no in�cio da lista
	public void AdicionaInicio(double temperatura) {
		Temperatura novo = new Temperatura();
		novo.setTemperatura(temperatura);
		novo.setProximo(inicio);
		inicio = novo;
		JOptionPane.showMessageDialog(null,
				"A temperatura " + inicio.getTemperatura() + "�C foi adicionada no in�cio da lista.");
	}

	// M�todo para adicionar uma temperatura no final da lista
	// Este m�todo utiliza recursividade direta, pois chama a si mesmo diretamente.
	// A vari�vel "aux" ser� igual ao pr�ximo elemento at� que o pr�ximo
	// elemento seja nulo. Dessa forma o objetivo dessa fun��o � chegar at� o final
	// da lista recursivamente.
	public void AdicionaFinal(double temperatura) {
		Temperatura novo = new Temperatura();
		novo.setTemperatura(temperatura);
		novo.setProximo(null);

		if (inicio == null) {
			inicio = novo;
		} else {
			Temperatura aux;
			aux = inicio;
			aux = AdicionaFinalRecursivo(aux);
			aux.setProximo(novo);
		}
		JOptionPane.showMessageDialog(null,
				"A temperatura " + novo.getTemperatura() + "�C foi adicionada no final da lista.");
	}

	// Fun��o recursiva direta chamada no m�todo AdicionaFinal
	private Temperatura AdicionaFinalRecursivo(Temperatura aux) {
		if (aux.getProximo() == null) {
			return aux;
		} else {
			return AdicionaFinalRecursivo(aux.getProximo());
		}
	}

	// M�todo para adicionar uma temperatura em qualquer posi��o da lista
	// Nesse m�todo foi preciso dividir em duas fun��es recursivas diretas.
	// A primeira tem como objetivo definir a vari�vel "count" e a segunda a
	// vari�vel "aux".
	public void AdicionaQualquerPosicao(double temperatura, int posicao) {
		Temperatura novo = new Temperatura();
		novo.setTemperatura(temperatura);

		if (posicao == 1) {
			AdicionaInicio(temperatura);
		} else {
			Temperatura aux = inicio;
			int contador = 1;
			int count = 1;

			count = AdicionaQualquerPosicaoRecursivoContador(aux, count, posicao);
			aux = AdicionaQualquerPosicaoRecursivoAux(aux, contador, posicao);

			if (count == (posicao - 1)) {
				novo.setProximo(aux.getProximo());
				aux.setProximo(novo);
				JOptionPane.showMessageDialog(null, "A temperatura " + novo.getTemperatura()
						+ "�C foi adicionada na posi��o " + posicao + " da lista.");
			} else {
				JOptionPane.showMessageDialog(null, "Posi��o inv�lida!", "Posi��o inv�lida!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Fun��o recursiva direta chamada no m�todo AdicionaQualquerPosicao para
	// definir a variavel "count"
	private int AdicionaQualquerPosicaoRecursivoContador(Temperatura aux, int count, int posicao) {
		if (aux.getProximo() == null || count == (posicao - 1)) {
			return count;
		} else {
			aux = aux.getProximo();
			count++;
			return AdicionaQualquerPosicaoRecursivoContador(aux, count, posicao);
		}
	}

	// Fun��o recursiva direta chamada no m�todo AdicionaQualquerPosicao para
	// definir a variavel "aux"
	private Temperatura AdicionaQualquerPosicaoRecursivoAux(Temperatura aux, int contador, int posicao) {
		if (aux.getProximo() == null || contador == (posicao - 1)) {
			return aux;
		} else {
			contador++;
			return AdicionaQualquerPosicaoRecursivoAux(aux.getProximo(), contador, posicao);
		}
	}

	// M�todo para remover uma temperatura do in�cio da lista
	public double RemoverInicio() {
		Temperatura aux = inicio;
		double temperaturaRemovida = aux.getTemperatura();
		inicio = aux.getProximo();
		return temperaturaRemovida;
	}

	// M�todo para remover uma temperatura do final da lista
	// Nesse m�todo foi preciso dividir em duas fun��es recursivas diretas.
	// A primeira tem como objetivo definir a vari�vel "aux1" e a segunda a
	// vari�vel "aux2".
	public double removerFinal() {
		Temperatura aux1 = inicio;
		Temperatura aux2 = inicio;
		double temperaturaRemovida;

		if (inicio.getProximo() == null) {
			temperaturaRemovida = aux1.getTemperatura();
			inicio = null;
		} else {
			aux2 = removerFinalRecursivoAux2(aux1, aux2);
			aux1 = removerFinalRecursivoAux1(aux1);
			temperaturaRemovida = aux1.getTemperatura();
			aux2.setProximo(null);
		}
		return temperaturaRemovida;
	}

	// Fun��o recursiva direta chamada no m�todo RemoveFinal para definir a variavel
	// "aux2"
	private Temperatura removerFinalRecursivoAux2(Temperatura aux1, Temperatura aux2) {
		if (aux1.getProximo() == null) {
			return aux2;
		} else {
			aux2 = aux1;
			aux1 = aux1.getProximo();
			return removerFinalRecursivoAux2(aux1, aux2);
		}
	}

	// Fun��o recursiva direta chamada no m�todo RemoveFinal para definir a variavel
	// "aux1"
	private Temperatura removerFinalRecursivoAux1(Temperatura aux1) {
		if (aux1.getProximo() == null) {
			return aux1;
		} else {
			aux1 = aux1.getProximo();
			return removerFinalRecursivoAux1(aux1);
		}
	}

	// M�todo para remover uma temperatura de qualquer posi��o da lista
	// Nesse m�todo foi preciso dividir em tr�s fun��es recursivas diretas.
	// A primeira tem como objetivo definir a vari�vel "aux1", a segunda a
	// vari�vel "aux2" e a terceira a vari�vel "count"
	public void removerQualquerPosicao(int posicao) {
		Temperatura aux1 = inicio;
		double temperaturaRemovida = 0;

		if (posicao == 1) {
			temperaturaRemovida = aux1.getTemperatura();
			inicio = aux1.getProximo();
			JOptionPane.showMessageDialog(null,
					"A temperatura " + temperaturaRemovida + "�C foi removida da posi��o " + posicao + " da lista.");

		} else {
			int contador = 1;
			int count = 1;
			Temperatura aux2 = inicio.getProximo();

			count = removerQualquerPosicaoRecursivoContador(aux1, count, posicao, aux2);
			aux1 = removerQualquerPosicaoRecursivoAux1(aux1, contador, posicao);
			aux2 = removerQualquerPosicaoRecursivoAux2(aux1, contador, posicao, aux2);

			if (count == (posicao - 1) && aux2 != null) {
				temperaturaRemovida = aux2.getTemperatura();
				aux1.setProximo(aux2.getProximo());
				JOptionPane.showMessageDialog(null, "A temperatura " + temperaturaRemovida
						+ "�C foi removida da posi��o " + posicao + " da lista.");
			} else {
				JOptionPane.showMessageDialog(null, "Posi��o inv�lida!", "Posi��o inv�lida!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Fun��o recursiva direta chamada no m�todo removerQualquerPosicao para definir a variavel
	// "count"
	private int removerQualquerPosicaoRecursivoContador(Temperatura aux1, int count, int posicao, Temperatura aux2) {
		if (aux1.getProximo() == null || count == (posicao - 1)) {
			return count;
		} else {
			aux1 = aux1.getProximo();
			aux2 = aux2.getProximo();
			count++;
			return removerQualquerPosicaoRecursivoContador(aux1, count, posicao, aux2);
		}
	}

	// Fun��o recursiva direta chamada no m�todo removerQualquerPosicao para definir a variavel
	// "aux1"
	private Temperatura removerQualquerPosicaoRecursivoAux1(Temperatura aux1, int contador, int posicao) {
		if (aux1.getProximo() == null || contador == (posicao - 1)) {
			return aux1;
		} else {
			contador++;
			return removerQualquerPosicaoRecursivoAux1(aux1.getProximo(), contador, posicao);
		}
	}

	// Fun��o recursiva direta chamada no m�todo removerQualquerPosicao para definir a variavel
	// "aux2"
	private Temperatura removerQualquerPosicaoRecursivoAux2(Temperatura aux1, int contador, int posicao,
			Temperatura aux2) {
		if (aux1.getProximo() == null || contador == (posicao - 1)) {
			return aux2;
		} else {
			aux1 = aux1.getProximo();
			aux2 = aux2.getProximo();
			contador++;
			return removerQualquerPosicaoRecursivoAux2(aux1, contador, posicao, aux2);
		}
	}

	// M�todo para percorrer a lista e exibir cada um de seus elementos.
	// Este m�todo utiliza recursividade direta, pois chama a si mesmo diretamente.
	// Essa fun��o tem como objetivo percorrer toda a lista de temperaturas
	// recursivamente.
	public void percorre() {
		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia", JOptionPane.ERROR_MESSAGE);
		} else {
			Temperatura aux = inicio;
			JOptionPane.showMessageDialog(null, "Lista de temperaturas:");
			percorreRecursivo(aux);
		}
	}

	// Fun��o recursiva direta chamada no m�todo percorre para exibir as temperaturas da lista
	private Temperatura percorreRecursivo(Temperatura aux) {
		if (aux.getProximo() == null) {
			JOptionPane.showMessageDialog(null, "Temperatura: " + aux.getTemperatura() + "�C.");
			return aux;
		} else {
			JOptionPane.showMessageDialog(null, "Temperatura: " + aux.getTemperatura() + "�C.");
			return percorreRecursivo(aux.getProximo());
		}
	}

}
