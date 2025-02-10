package lista8.exercicioMergeSort;

public class MergeSort {

	public void mergeSort(int[] lista, int inicio, int fim) {
		if (fim <= inicio)
			return;

		int meio = (inicio + fim) / 2;
		mergeSort(lista, inicio, meio);
		mergeSort(lista, meio + 1, fim);
		merge(lista, inicio, meio, fim);
	}

	public static void merge(int[] lista, int inicio, int meio, int fim) {
		int particaoEsquerda[] = new int[meio - inicio + 1];
		int particaoDireita[] = new int[fim - meio];

		for (int i = 0; i < particaoEsquerda.length; i++)
			particaoEsquerda[i] = lista[inicio + i];
		for (int i = 0; i < particaoDireita.length; i++)
			particaoDireita[i] = lista[meio + i + 1];

		int indiceEsquerda = 0;
		int indiceDireita = 0;

		for (int i = inicio; i < fim + 1; i++) {
			if (indiceEsquerda < particaoEsquerda.length && indiceDireita < particaoDireita.length) {
				if (particaoEsquerda[indiceEsquerda] < particaoDireita[indiceDireita]) {
					lista[i] = particaoEsquerda[indiceEsquerda];
					indiceEsquerda++;
				} else {
					lista[i] = particaoDireita[indiceDireita];
					indiceDireita++;
				}
			} else if (indiceEsquerda < particaoEsquerda.length) {
				lista[i] = particaoEsquerda[indiceEsquerda];
				indiceEsquerda++;
			} else if (indiceDireita < particaoDireita.length) {
				lista[i] = particaoDireita[indiceDireita];
				indiceDireita++;
			}
		}
	}

}
