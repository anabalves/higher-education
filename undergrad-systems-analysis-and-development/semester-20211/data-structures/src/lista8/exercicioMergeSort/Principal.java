package lista8.exercicioMergeSort;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		int[] lista = new int[] { 26, 69, 25, 53, 59, 27, 41, 0, 33, 16, 35, 43 };
		
		System.out.println("\nLista Inicial:");
		System.out.println(Arrays.toString(lista));
		
		MergeSort mSort = new MergeSort();
		mSort.mergeSort(lista, 0, lista.length - 1);

		System.out.println("Lista Ordenada: ");
		System.out.println(Arrays.toString(lista));

	}

}
