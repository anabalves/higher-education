/* 10 carros estacionados de 1 a 2 Km
 * Os carros rodam a velocidade m�dia de 100 m/s
 * O estacionamento tem 3 vagas
 * Os 3 primeiros a chegar estacionam e ficam entre 1 a 3 s.
 * Se o estacionamento estiver lotado, os outros aguardam em fila por ordem de chegada
 * Quando um carro sai o proximo da fila entra
 * Saber a ordem de chegada e saida � importante
 * 
 * bloco try..catch
 *  try {
 * 		Tentar executar essas
 * } catch (Exception e) {
 * 		Tratamento de exce��o
 * } finally {
 * 		linhas que ocorrem ao t�rmino do try OU do catch
 * }
 * */

package aula5.controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private int idCarro;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;

	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	public void run() {
		carroAndando();
//		---------------------- Inicio Se��o Critica ----------------------
		try {
			semaforo.acquire();
			carroEstacionado();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
//		---------------------- Fim Se��o Critica ----------------------
		carroSaindo();
	}

	private void carroAndando() {
		int distanciaTotal = (int) ((Math.random() * 1001) + 1000);
		int distanciaPercorrida = 0;
		int deslocamento = 100;
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			// distanciaPercorrida = distanciaPercorrida + deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idCarro + " j� andou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("#" + idCarro + " foi o " + posChegada + "� a chegar");
	}
	// Math.random() < 0 |------------ 0.9999999999999...>
	// De 0 a 1000
	// (Min) 0 * 1000 = 0 || (Max) 0.9999999 * 1001 = 1000.9999 -> (int)1000
	// De 1000 a 2000

	private void carroEstacionado() {
		System.out.println("#" + idCarro + " estacionou");
		int tempo = (int) ((Math.random() * 2001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void carroSaindo() {
		posSaida++;
		System.out.println("#" + idCarro + " foi o " + posSaida + "� a sair");
	}

}