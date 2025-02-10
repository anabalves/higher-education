package lista8.exercicioArvoreBinaria;

import javax.swing.JOptionPane;

public class TesteArvore {

	public static void main(String[] args) {

		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
		int opc = 0;
		Integer elemento = null;

		while (opc != 8) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite uma op��o v�lida " + "\n 1- Adicionar um elemento " + "\n 2- Remover um elemento "
							+ "\n 3- Buscar elemento " + "\n 4- Ver o tamanho da �rvore " + "\n 5- Mostrar Pr�-Ordem "
							+ "\n 6- Mostrar Em Ordem " + "\n 7- Mostrar P�s-Ordem " + "\n 8- Sair",
					JOptionPane.QUESTION_MESSAGE));

			switch (opc) {

			case 1:
				elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite um elemento: "));
				arvoreBinaria.Adicionar(elemento);
				break;

			case 2:
				if (!arvoreBinaria.VerificaArvoreVazia()) {
					elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite um elemento: "));
					if (arvoreBinaria.Remover(elemento) != null) {
						JOptionPane.showMessageDialog(null, "O Elemento " + elemento + " foi removido da �rvore.");
					} else {
						JOptionPane.showMessageDialog(null, "O elemento n�o foi encontrado!", "Elemento n�o encontrado",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "A �rvore est� vazia!", "�rvore Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 3:
				if (!arvoreBinaria.VerificaArvoreVazia()) {
					elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite um elemento: "));
					if (arvoreBinaria.Buscar(elemento) != null) {
						JOptionPane.showMessageDialog(null, "O Elemento " + elemento + " foi encontrado da �rvore.");
					} else {
						JOptionPane.showMessageDialog(null, "O elemento n�o foi encontrado!", "Elemento n�o encontrado",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "A �rvore est� vazia!", "�rvore Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 4:
				if (!arvoreBinaria.VerificaArvoreVazia()) {
					JOptionPane.showMessageDialog(null,
							"O tamanho da �rvore � de " + arvoreBinaria.mostraTamanho(arvoreBinaria.obtemRaiz()) + " elementos.");
				} else {
					JOptionPane.showMessageDialog(null, "A �rvore est� vazia!", "�rvore Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 5:
				if (!arvoreBinaria.VerificaArvoreVazia()) {
					arvoreBinaria.mostraPreOrdem();
				} else {
					JOptionPane.showMessageDialog(null, "A �rvore est� vazia!", "�rvore Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 6:
				if (!arvoreBinaria.VerificaArvoreVazia()) {
					arvoreBinaria.mostraEmOrdem();
				} else {
					JOptionPane.showMessageDialog(null, "A �rvore est� vazia!", "�rvore Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 7:
				if (!arvoreBinaria.VerificaArvoreVazia()) {
					arvoreBinaria.mostraPosOrdem();
				} else {
					JOptionPane.showMessageDialog(null, "A �rvore est� vazia!", "�rvore Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 8:
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
