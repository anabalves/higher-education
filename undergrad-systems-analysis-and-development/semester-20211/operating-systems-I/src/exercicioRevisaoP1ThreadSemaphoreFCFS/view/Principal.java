package exercicioRevisaoP1ThreadSemaphoreFCFS.view;

import java.util.concurrent.Semaphore;
import exercicioRevisaoP1ThreadSemaphoreFCFS.controller.ThreadFCFS;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idProcesso = 1; idProcesso <= 20; idProcesso++) {
			ThreadFCFS threadFCFS = new ThreadFCFS(idProcesso, semaforo);
			threadFCFS.start();
		}
	}

}
