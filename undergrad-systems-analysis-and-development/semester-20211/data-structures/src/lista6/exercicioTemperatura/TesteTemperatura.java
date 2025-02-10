package lista6.exercicioTemperatura;

import javax.swing.JOptionPane;

public class TesteTemperatura {

	public static void main(String[] args) {
		ListaTemperatura listaTemperatura = new ListaTemperatura();
		int opc = 0;
		double temperatura = 0;
		int posicao = 0;

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite uma op��o v�lida "
					+ "\n 1- Verifica se a lista est� vazia " 
					+ "\n 2- Adicionar uma temperatura no in�cio da lista "
					+ "\n 3- Adicionar uma temperatura no final da lista "
					+ "\n 4- Adicionar uma temperatura em qualquer posi��o da lista "
					+ "\n 5- Remover uma temperatura do in�cio da lista "
					+ "\n 6- Remover uma temperatura do final da lista "
					+ "\n 7- Remover uma temperatura de qualquer posi��o da lista "
					+ "\n 8- Exibir temperaturas da lista " 
					+ "\n 9- Sair", JOptionPane.QUESTION_MESSAGE));

			switch (opc) {

			case 1:
				if (listaTemperatura.VerificaListaVazia() == true) {
					JOptionPane.showMessageDialog(null, "TRUE - A Lista est� vazia");
				} else {
					JOptionPane.showMessageDialog(null, "FALSE - A Lista n�o est� vazia");
				}
				break;

			case 2:
				temperatura = Double.parseDouble(
						JOptionPane.showInputDialog("Digite uma temperatura para adicionar no in�cio da lista: "));
				listaTemperatura.AdicionaInicio(temperatura);
				break;

			case 3:
				temperatura = Double.parseDouble(
						JOptionPane.showInputDialog("Digite uma temperatura para adicionar no final da lista: "));
				listaTemperatura.AdicionaFinal(temperatura);
				break;

			case 4:
				temperatura = Double
						.parseDouble(JOptionPane.showInputDialog("Digite uma temperatura para adicionar na lista: "));
				posicao = Integer.parseInt(
						JOptionPane.showInputDialog("Digite a posi��o da lista que deseja adicionar a temperatura: "));
				listaTemperatura.AdicionaQualquerPosicao(temperatura, posicao);
				break;

			case 5:
				if (!listaTemperatura.VerificaListaVazia()) {
					double tempRemovida = listaTemperatura.RemoverInicio();
					JOptionPane.showMessageDialog(null,
							"A temperatura " + tempRemovida + "�C foi removida do in�cio lista.");
				} else {
					JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 6:
				if (!listaTemperatura.VerificaListaVazia()) {
					double tempRemovida = listaTemperatura.removerFinal();
					JOptionPane.showMessageDialog(null,
							"A temperatura " + tempRemovida + "�C foi removida do final da lista.");
				} else {
					JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 7:
				if (!listaTemperatura.VerificaListaVazia()) {
					posicao = Integer.parseInt(JOptionPane
							.showInputDialog("Digite a posi��o da lista que deseja remover a temperatura: "));
					listaTemperatura.removerQualquerPosicao(posicao);
				} else {
					JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 8:
				listaTemperatura.percorre();
				break;

			case 9:
				JOptionPane.showMessageDialog(null, "Programa Finalizado com sucesso!", "Programa Finalizado",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma op��o v�lida", "Op��o Inv�lida",
						JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}

}
