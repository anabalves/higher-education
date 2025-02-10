package tarefa05ThreadSemaphore01Pag36.view;

import java.util.concurrent.Semaphore;

import tarefa05ThreadSemaphore01Pag36.controller.ThreadCorredores;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idCorredor = 1; idCorredor < 5; idCorredor++) {
			ThreadCorredores threadCorredores = new ThreadCorredores(idCorredor, semaforo);
			threadCorredores.start();
		}

	}

}
