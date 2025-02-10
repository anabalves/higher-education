package lista8.exercicioQuickSort;

public class QuickSort {
	
	public void quickSort(int[] lista, int inicio, int fim) {
		if (inicio < fim) {
			int indice = particionar(lista, inicio, fim);
			quickSort(lista, inicio, indice - 1);
			quickSort(lista, indice + 1, fim);
		}
	}
	
	private int particionar(int[] lista, int inicio, int fim) {

		int pivot = lista[fim];

		int i = (inicio - 1);

		for (int j = inicio; j <= fim - 1; j++) {

			if (lista[j] < pivot) {

				i++;
				trocar(lista, i, j);
			}
		}
		trocar(lista, i + 1, fim);
		return (i + 1);
	}
	
	private void trocar(int[] lista, int i, int j) {
		int aux = lista[i];
		lista[i] = lista[j];
		lista[j] = aux;
	}

}