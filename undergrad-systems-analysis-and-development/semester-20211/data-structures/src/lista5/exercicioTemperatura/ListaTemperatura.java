package lista5.exercicioTemperatura;

import javax.swing.JOptionPane;

public class ListaTemperatura {

	private Temperatura inicio;

	public ListaTemperatura() {
		this.inicio = null;
	}

	public boolean VerificaListaVazia() {
		if (this.inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	public void AdicionaInicio(double temperatura) {
		Temperatura novo = new Temperatura();
		novo.setTemperatura(temperatura);
		novo.setProximo(inicio);
		inicio = novo;
		JOptionPane.showMessageDialog(null,
				"A temperatura " + inicio.getTemperatura() + "ºC foi adicionada no início da lista.");
	}

	public void AdicionaFinal(double temperatura) {
		Temperatura novo = new Temperatura();
		novo.setTemperatura(temperatura);
		novo.setProximo(null);

		if (inicio == null) {
			inicio = novo;
		} else {
			Temperatura aux;
			aux = inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(novo);
		}
		JOptionPane.showMessageDialog(null,
				"A temperatura " + novo.getTemperatura() + "ºC foi adicionada no final da lista.");
	}

	public void AdicionaQualquerPosicao(double temperatura, int posicao) {
		Temperatura novo = new Temperatura();
		novo.setTemperatura(temperatura);

		if (posicao == 1) {
			AdicionaInicio(temperatura);
		} else {
			Temperatura aux = inicio;
			int count = 1;

			while (aux.getProximo() != null && count < (posicao - 1)) {
				aux = aux.getProximo();
				count++;
			}
			if (count == (posicao - 1)) {
				novo.setProximo(aux.getProximo());
				aux.setProximo(novo);
			} else {
				JOptionPane.showMessageDialog(null, "Posição inválida!", "Posição inválida!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (posicao > 1) {
			JOptionPane.showMessageDialog(null, "A temperatura " + novo.getTemperatura()
					+ "ºC foi adicionada na posição " + posicao + " da lista.");
		}
	}

	public double RemoverInicio() {
		Temperatura aux = inicio;
		double temperaturaRemovida = aux.getTemperatura();
		inicio = aux.getProximo();
		return temperaturaRemovida;
	}

	public double removerFinal() {
		Temperatura aux1 = inicio;
		Temperatura aux2 = inicio;
		double temperaturaRemovida;

		if (inicio.getProximo() == null) {
			temperaturaRemovida = aux1.getTemperatura();
			inicio = null;
		} else {

			while (aux1.getProximo() != null) {
				aux2 = aux1;
				aux1 = aux1.getProximo();
			}
			temperaturaRemovida = aux1.getTemperatura();
			aux2.setProximo(null);
		}
		return temperaturaRemovida;
	}

	public void removerQualquerPosicao(int posicao) {
		Temperatura aux1 = inicio;
		double temperaturaRemovida = 0;

		if (posicao == 1) {
			temperaturaRemovida = aux1.getTemperatura();
			inicio = aux1.getProximo();
			JOptionPane.showMessageDialog(null,
					"A temperatura " + temperaturaRemovida + "ºC foi removida da posição " + posicao + " da lista.");

		} else {
			int count = 1;
			Temperatura aux2 = inicio.getProximo();

			while (aux1.getProximo() != null && count < (posicao - 1)) {
				aux1 = aux1.getProximo();
				aux2 = aux1.getProximo();
				count++;
			}

			if (count == (posicao - 1) && aux2 != null) {
				temperaturaRemovida = aux2.getTemperatura();
				aux1.setProximo(aux2.getProximo());
				JOptionPane.showMessageDialog(null, "A temperatura " + temperaturaRemovida
						+ "ºC foi removida da posição " + posicao + " da lista.");
			} else {
				JOptionPane.showMessageDialog(null, "Posição inválida!", "Posição inválida!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void percorre() {
		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia", JOptionPane.ERROR_MESSAGE);
		} else {
			Temperatura aux = inicio;
			JOptionPane.showMessageDialog(null, "Lista de temperaturas:");
			while (aux != null) {
				JOptionPane.showMessageDialog(null, "Temperatura: " + aux.getTemperatura() + "ºC.");
				aux = aux.getProximo();
			}
		}
	}

}
