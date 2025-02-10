package tarefa05ThreadSemaphore02Pag37.view;

import java.util.concurrent.Semaphore;

import tarefa05ThreadSemaphore02Pag37.controller.ThreadCruzamento;

public class Principal {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idCarro = 1; idCarro < 5; idCarro++) {
			ThreadCruzamento threadCruzamento = new ThreadCruzamento(idCarro, semaforo);
			threadCruzamento.start();
		}

	}

}
