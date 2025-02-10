package lista8.exercicioEscolaQuickSort;

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

	public NoMedia getListaMedia() {
		return anterior;
	}

	public Media[] quickSort() {
		Media[] aux = new Media[tamanho];
		for (int i = 0; i < tamanho; i++) {
			aux[i] = retornaNo(i + 1).getMedia();
		}
		sort(aux, 0, aux.length - 1);
		return aux;
	}

	public int particionar(Media vetor[], int inicio, int fim) {
		Media pivo = vetor[(int) (inicio + Math.random() * (fim - inicio))];

		while (inicio <= fim) {
			while (vetor[inicio].getMediaFinal() < pivo.getMediaFinal()) {
				inicio++;
			}
			while (vetor[fim].getMediaFinal() > pivo.getMediaFinal()) {
				fim--;
			}
			if (inicio <= fim) {
				Media aux = vetor[inicio];
				vetor[inicio] = vetor[fim];
				vetor[fim] = aux;
				inicio++;
				fim--;
			}
		}
		return inicio;
	}

	public void sort(Media vetor[], int inicio, int fim) {
		int indice = particionar(vetor, inicio, fim);
		if (inicio < indice - 1) {
			sort(vetor, inicio, indice - 1);
		}
		if (indice < fim) {
			sort(vetor, indice, fim);
		}
	}
}