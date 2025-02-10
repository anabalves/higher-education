package lista2;

import javax.swing.JOptionPane;

public class Exercicio2 {

	public static void main(String[] args) {
		TesteChar testeChar = new TesteChar();

		int opcao = 0;
		int posicao = 0;
		char caractere;

		while (opcao != 10) {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: \n"
					+ "1 - Verificar se a lista est� vazia\n"
					+ "2 - Verificar se a lista est� cheia\n"
					+ "3 - Adicionar caractere no in�cio da lista\n" 
					+ "4 - Adicionar caractere no final da lista\n"
					+ "5 - Adicionar caractere em determinada posi��o da lista\n"
					+ "6 - Remover caractere do in�cio da lista\n" 
					+ "7 - Remover caractere do final da lista\n"
					+ "8 - Remover caractere de determinada posi��o da lista\n"
					+ "9 - Percorrer a lista concatenando os elementos em uma String\n" 
					+ "10 - Finalizar Programa!"));

			switch (opcao) {

			case 1:
				if (testeChar.verificaListaVazia()) {
					System.out.println("True: A lista est� vazia");
				} else {
					System.out.println("False: A lista n�o est� vazia");
				}
				break;

			case 2:
				if (testeChar.verificaListaCheia()) {
					System.out.println("True: A lista cheia");
				} else {
					System.out.println("False: A lista n�o est� cheia");
				}
				break;

			case 3:
				caractere = JOptionPane.showInputDialog("Digite o caractere desejado: ").charAt(0);
				System.out.println(testeChar.adicionaCaracterInicio(caractere));
				break;

			case 4:
				caractere = JOptionPane.showInputDialog("Digite o caractere desejado: ").charAt(0);
				System.out.println(testeChar.adicionaCaracterFinal(caractere));
				break;

			case 5:
				caractere = JOptionPane.showInputDialog("Digite o caractere desejado: ").charAt(0);
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posicao do vetor que voc� deseja inserir o caracter: "));
				posicao = posicao - 1;
				System.out.println(testeChar.adicionaCaracterPosicaoEspecifica(caractere, posicao));
				break;

			case 6:
				System.out.println(testeChar.removeCaracterInicio());
				break;

			case 7:
				System.out.println(testeChar.removeCaracterFinal());
				break;

			case 8:
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posicao do vetor que voc� deseja remover o caracter: "));
				System.out.println(testeChar.removeCaracterPosicaoEspecifica(posicao));
				break;

			case 9:
				System.out.println("Caracteres concatenados: " + testeChar.concatenaElementosString());
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
