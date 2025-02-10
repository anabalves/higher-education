package lista8.exercicioEscolaMergeSort;

import javax.swing.JOptionPane;

public class ListaMedia {
	ListaAluno listaAluno = new ListaAluno();
	ListaDisciplina listaDisciplina = new ListaDisciplina();
	private NoMedia anterior;
	private NoMedia proximo;
	private int tamanho;

	public ListaMedia() {
		anterior = null;
		proximo = null;
		tamanho = 0;
	}

	public boolean VerificaListaVazia() {
		if (tamanho == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void adicionaInicio(Media media) {
		NoMedia novo = new NoMedia();
		novo.setMedia(media);
		novo.setAnterior(novo);
		if (VerificaListaVazia()) {
			novo.setProximo(null);
			anterior = novo;
			proximo = novo;
		} else {
			novo.setProximo(anterior);
			anterior.setAnterior(novo);
			anterior = novo;
		}
		tamanho++;
		JOptionPane.showMessageDialog(null, "Média Adicionada no início da lista: " + novo.getMedia().toString());
	}

	public void adicionaFinal(Media media) {
		NoMedia novo = new NoMedia();
		novo.setMedia(media);
		novo.setProximo(null);
		if (VerificaListaVazia()) {
			novo.setAnterior(null);
			anterior = novo;
			proximo = novo;
		} else {
			novo.setAnterior(proximo);
			proximo.setProximo(novo);
			proximo = novo;
		}
		tamanho++;
		JOptionPane.showMessageDialog(null, "Média Adicionada no final da lista: " + novo.getMedia().toString());
	}

	public Media RemoverInicio() {
		Media retorno = null;
		retorno = anterior.getMedia();
		NoMedia aux = anterior.getProximo();
		if (tamanho == 1) {
			anterior = null;
			proximo = null;
		} else {
			aux.setAnterior(null);
			anterior = aux;
		}
		tamanho--;
		return retorno;

	}

	public Media removerFinal() {
		Media retorno = null;
		retorno = proximo.getMedia();
		NoMedia aux = proximo.getAnterior();
		if (tamanho == 1) {
			anterior = null;
			proximo = null;
		} else {
			aux.setProximo(null);
			proximo = aux;
		}
		tamanho--;
		return retorno;
	}

	public NoMedia retornaNo(int posicao) {
		if (posicao > tamanho || posicao < 1) {
			return new NoMedia();
		} else {
			return retornaNo(posicao, anterior);
		}
	}

	private NoMedia retornaNo(int posicao, NoMedia aux) {
		if (posicao <= 1) {
			return aux;
		} else {
			return retornaNo(posicao - 1, aux.getProximo());
		}
	}

	public void percorre() {
		if (VerificaListaVazia()) {
			JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Lista de médias:");
			proximoToString(anterior);
		}
	}

	private void proximoToString(NoMedia aux) {
		if (aux.getProximo() == null) {
			JOptionPane.showMessageDialog(null, aux.getMedia().toString());
		} else {
			JOptionPane.showMessageDialog(null, aux.getMedia().toString());
			proximoToString(aux.getProximo());
		}
	}

	public int getTamanho() {
		return tamanho;
	}

	public Media[] mergeSort() {
		Media[] aux = new Media[tamanho];
		for (int i = 0; i < tamanho; i++) {
			aux[i] = retornaNo(i + 1).getMedia();
		}
		sort(aux, 0, aux.length - 1);
		return aux;
	}

	private void sort(Media[] vetor, int inicio, int fim) {
		if (inicio < fim) {

			int meio = (inicio + fim) / 2;

			sort(vetor, inicio, meio);
			sort(vetor, meio + 1, fim);
			merge(vetor, inicio, meio, fim);
		}
	}

	private void merge(Media[] vetor, int inicio, int meio, int fim) {

		int tamanho1 = meio - inicio + 1;
		int tamanho2 = fim - meio;

		Media particao1[] = new Media[tamanho1];
		Media particao2[] = new Media[tamanho2];

		for (int i = 0; i < tamanho1; ++i) {
			particao1[i] = vetor[inicio + i];
		}

		for (int j = 0; j < tamanho2; ++j) {
			particao2[j] = vetor[meio + 1 + j];
		}

		int i = 0, j = 0;
		int k = inicio;

		while (i < tamanho1 && j < tamanho2) {
			if (particao1[i].getMediaFinal() <= particao2[j].getMediaFinal()) {
				vetor[k] = particao1[i];
				i++;
			} else {
				vetor[k] = particao2[j];
				j++;
			}
			k++;
		}

		while (i < tamanho1) {
			vetor[k] = particao1[i];
			i++;
			k++;
		}

		while (j < tamanho2) {
			vetor[k] = particao2[j];
			j++;
			k++;
		}
	}
}