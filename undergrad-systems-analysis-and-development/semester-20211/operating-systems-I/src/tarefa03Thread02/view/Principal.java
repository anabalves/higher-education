package tarefa03Thread02.view;

import tarefa03Thread02.controller.ThreadId;

public class Principal {

	public static void main(String[] args) {
		
		for (int idThread = 0; idThread < 5; idThread++) {
			Thread threadId = new ThreadId(idThread);
			threadId.start();
		}
	
}
}
