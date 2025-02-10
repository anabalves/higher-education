package lista4.exercicioDetran;

import javax.swing.JOptionPane;

public class TesteDasClasses {

	public static void main(String[]args) {
		
		int ID;
		String nome;
		String RG;
		String telefone;
		String dataDeNascimento;
		
		//Associacao entre classes	
		Fila filaPessoas = new Fila(4);
		Pilha pilhaPessoas = new Pilha(4);
	
		int opcao = 0;
		String mostraFila;
		String mostraPilha;
		int ordemEspera = 0;
		//Associacao entre classes	
		Pessoas retorno;
		
		while(opcao != 99) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Op��es: "
					+ "\n 1 - Adicionar Pessoa na Fila "
					+ "\n 2 - Remover Pessoa da Fila "
					+ "\n 3 - Pesquisar a ordem de espera de uma pessoa na fila "
					+ "\n 4 - Exibir Pessoas da Fila "
					+ "\n 5 - (Pilha)Exibir Pessoas que foram removidas da Fila "
					+ "\n 6 - (Pilha)Remover permanentemente uma Pessoa removida da Fila "
					+ "\n 99- Sair"));

			switch(opcao) {
			
			case 1:
				//Associacao entre classes	
				if (!filaPessoas.VerifCheia()) {
					ID = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da Pessoa (Apenas n�meros)"));
					nome = JOptionPane.showInputDialog("Informe o nome da Pessoa");
					RG = JOptionPane.showInputDialog("Informe o RG da Pessoa (Apenas n�meros)");
					telefone = JOptionPane.showInputDialog("Informe o telefone da Pessoa (Apenas n�meros)");
					dataDeNascimento = JOptionPane.showInputDialog("Informe a Data de Nascimento da Pessoa (Formato ##/##/#### - Digite os n�meros e barras)");
					//Associacao entre classes	
					filaPessoas.AdicionarFila(new Pessoas(ID, nome, RG, telefone, dataDeNascimento));
				} else {
					JOptionPane.showMessageDialog(null, "A Fila de Pessoas est� cheia!");
				}
				break;

			case 2:
				//Associacao entre classes	
				if (!filaPessoas.VerifVazia()) {
					//Associacao entre classes	
					retorno = filaPessoas.RemoverFila();
					JOptionPane.showMessageDialog(null, "A pessoa removida foi:\n" + retorno);
					//Associacao entre classes	
					pilhaPessoas.AdicionarPilha(retorno);
				} else {
					JOptionPane.showMessageDialog(null, "A Fila de Pessoas est� vazia!");
				}
				break;

			case 3:
				//Associacao entre classes	
				if (!filaPessoas.VerifVazia()) {
					ordemEspera = Integer.parseInt(JOptionPane.showInputDialog("Digite a posi��o do fila para pesquisar a ordem de espera"));
					//Associacao entre classes	
					JOptionPane.showMessageDialog(null, filaPessoas.ordemEsperaFila(ordemEspera));
				} else {
					JOptionPane.showMessageDialog(null, "A Fila de Pessoas est� vazia!");
				}
				break;

			case 4:
				//Associacao entre classes	
				mostraFila = filaPessoas.percorreFila();
				JOptionPane.showMessageDialog(null,"Fila: " + mostraFila);
				break;

			case 5:
				//Associacao entre classes	
				mostraPilha = pilhaPessoas.percorrePilha();
				JOptionPane.showMessageDialog(null,"Pilha: " + mostraPilha);
				break;

			case 6:
				//Associacao entre classes	
				JOptionPane.showMessageDialog(null, pilhaPessoas.RemoverPilha());
				break;

			case 99:
				JOptionPane.showMessageDialog(null, "Programa Finalizado com sucesso!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma op��o v�lida");
				break;

			}
		}
	}
}
