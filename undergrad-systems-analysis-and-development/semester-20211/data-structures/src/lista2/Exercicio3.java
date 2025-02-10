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
					"Digite a opção desejada: \n"
					+ "1 - Verificar se a lista está vazia\n"
					+ "2 - Verificar se a lista está cheia\n"
					+ "3 - Adicionar uma String no início da lista\n"
					+ "4 - Adicionar uma String no final da lista\n"
					+ "5 - Adicionar uma String em determinada posição da lista\n"
					+ "6 - Remover a String do início da lista\n"
					+ "7 - Remover a String do final da lista\n"
					+ "8 - Remover a String de determinada posição da lista\n"
					+ "9 - Percorrer a lista concatenando os elementos em uma String\n"
					+ "10 - Finalizar Programa!"
					));
			
			switch (opcao) {

			case 1:
				if (testeString.verificaListaVazia()) {
					System.out.println("True: A lista está vazia");
				} else {
					System.out.println("False: A lista não está vazia");
				}
				break;


			case 2:
				if (testeString.verificaListaCheia()) {
					System.out.println("True: A lista cheia");
				} else {
					System.out.println("False: A lista não está cheia");
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
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do vetor que você deseja inserir a String: "));
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
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do vetor que você deseja remover a String: "));
				System.out.println(testeString.removeStringPosicaoEspecifica(posicao));
				break;

			case 9:
				System.out.println("Strings concatenadas: " + testeString.concatenaElementosString());
				break;

			case 10:
				System.out.println("Programa Finalizado com sucesso!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida");
				break;
			
			}
		}
			
	}

}
