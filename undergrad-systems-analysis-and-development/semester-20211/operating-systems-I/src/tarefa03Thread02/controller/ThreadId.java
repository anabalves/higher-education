package tarefa03Thread02.controller;

public class ThreadId extends Thread {

	private int idThread;
	
	public ThreadId(int idThread) {
		this.idThread = idThread;
	}

	@Override
	public void run() {
		System.out.println("ThreadId#" + idThread);
	}

}
