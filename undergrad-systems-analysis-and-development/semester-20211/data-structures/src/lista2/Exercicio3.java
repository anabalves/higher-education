package lista2;

import javax.swing.JOptionPane;

public class Exercicio3 {

	public static void main(String[] args) {
		TesteString testeString = new TesteString();
		
		int opcao = 0;
		int posicao = 0;
		String string;

		while (opcao != 10) {
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite a op��o desejada: \n"
					+ "1 - Verificar se a lista est� vazia\n"
					+ "2 - Verificar se a lista est� cheia\n"
					+ "3 - Adicionar uma String no in�cio da lista\n"
					+ "4 - Adicionar uma String no final da lista\n"
					+ "5 - Adicionar uma String em determinada posi��o da lista\n"
					+ "6 - Remover a String do in�cio da lista\n"
					+ "7 - Remover a String do final da lista\n"
					+ "8 - Remover a String de determinada posi��o da lista\n"
					+ "9 - Percorrer a lista concatenando os elementos em uma String\n"
					+ "10 - Finalizar Programa!"
					));
			
			switch (opcao) {

			case 1:
				if (testeString.verificaListaVazia()) {
					System.out.println("True: A lista est� vazia");
				} else {
					System.out.println("False: A lista n�o est� vazia");
				}
				break;


			case 2:
				if (testeString.verificaListaCheia()) {
					System.out.println("True: A lista cheia");
				} else {
					System.out.println("False: A lista n�o est� cheia");
				}
				break;

			case 3:
				string = JOptionPane.showInputDialog("Digite a String desejada: ");
				System.out.println(testeString.adicionaStringInicio(string));
				break;				

			case 4:
				string = JOptionPane.showInputDialog("Digite a String desejada: ");
				System.out.println(testeString.adicionaStringFinal(string));
				break;				

			case 5:
				string = JOptionPane.showInputDialog("Digite a String desejada: ");
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posi��o do vetor que voc� deseja inserir a String: "));
				posicao = posicao - 1;
				System.out.println(testeString.adicionaStringPosicaoEspecifica(string, posicao));
				break;

			case 6:
				System.out.println(testeString.removeStringInicio());
				break;

			case 7:
				System.out.println(testeString.removeStringFinal());
				break;
				
			case 8:
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posi��o do vetor que voc� deseja remover a String: "));
				System.out.println(testeString.removeStringPosicaoEspecifica(posicao));
				break;

			case 9:
				System.out.println("Strings concatenadas: " + testeString.concatenaElementosString());
				break;

			case 10:
				System.out.println("Programa Finalizado com sucesso!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma op��o v�lida");
				break;
			
			}
		}
			
	}

}
