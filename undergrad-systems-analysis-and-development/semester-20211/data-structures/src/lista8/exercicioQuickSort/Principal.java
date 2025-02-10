package lista8.exercicioQuickSort;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		int[] lista = { 99, 142, 192, 47, 152, 159, 195, 61, 66, 17, 167, 118, 64, 27, 80, 30, 105 };

		System.out.println("Lista inicial:");
		System.out.println(Arrays.toString(lista));

		QuickSort qSort = new QuickSort();
		qSort.quickSort(lista, 0, lista.length - 1);

		System.out.println("Lista ordenada:");
		System.out.print(Arrays.toString(lista));

	}

}