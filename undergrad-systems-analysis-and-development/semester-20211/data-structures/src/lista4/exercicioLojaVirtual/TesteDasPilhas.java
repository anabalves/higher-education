package lista4.exercicioLojaVirtual;

import javax.swing.JOptionPane;

public class TesteDasPilhas {

	public static void main(String[] args) {

		int ID;
		String nome;
		double valor;
		int quantidade;

		//Associacao entre classes
		PilhaPrincipalDeProdutos pilhaPrincipalProdutos = new PilhaPrincipalDeProdutos(4);
		PilhaDeProdutosRemovidos pilhaDeProdutosRemovidos = new PilhaDeProdutosRemovidos(4);

		int opcao = 0;
		String mostraPilhaDeProdutosRemovidos;
		String mostraPilhaPrincipalProdutos;
		int ordemEspera = 0;
		String nomeProduto = "";
		//Associacao entre classes	
		Produtos retorno;

		while (opcao != 99) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Opções: " + "\n 1 - Adicionar Produto na Pilha "
					+ "\n 2 - Remover Produto da Pilha " + "\n 3 - Pesquisar a ordem de espera de uma Produto na pilha "
					+ "\n 4 - Pesquisar um Produto na pilha por nome " + "\n 5 - Exibir Produtos da Pilha "
					+ "\n 6 - Exibir Produtos que foram removidos da Pilha "
					+ "\n 7 - Remover permanentemente um Produto removido da Pilha " + "\n 99- Sair"));

			switch (opcao) {

			case 1:
				//Associacao entre classes	
				if (!pilhaPrincipalProdutos.VerifCheia()) {
					ID = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da Produto (Apenas números)"));
					nome = JOptionPane.showInputDialog("Informe o nome do Produto");
					valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do produto (Apenas números , -> .)"));
					quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade do produto (Apenas números)"));
					//Associacao entre classes	
					pilhaPrincipalProdutos.AdicionarPilhaPrincipal(new Produtos(ID, nome, valor, quantidade));
				} else {
					JOptionPane.showMessageDialog(null, "A Pilha de Produtos está cheia!");
				}
				break;

			case 2:
				//Associacao entre classes	
				if (!pilhaPrincipalProdutos.VerifVazia()) {
					//Associacao entre classes	
					retorno = pilhaPrincipalProdutos.RemoverPilhaPrincipal();
					JOptionPane.showMessageDialog(null, "O Produto removido foi:\n" + retorno);
					//Associacao entre classes	
					pilhaDeProdutosRemovidos.AdicionarPilhaProdutosRemovidos(retorno);
				} else {
					JOptionPane.showMessageDialog(null, "A Pilha de Produtos está vazia!");
				}
				break;

			case 3:
				//Associacao entre classes	
				if (!pilhaPrincipalProdutos.VerifVazia()) {
					ordemEspera = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do pilha para pesquisar a ordem de espera"));
					//Associacao entre classes	
					JOptionPane.showMessageDialog(null, pilhaPrincipalProdutos.ordemEsperaPilha(ordemEspera));
				} else {
					JOptionPane.showMessageDialog(null, "A Pilha de Produtos está vazia!");
				}
				break;

			case 4:
				//Associacao entre classes	
				if (!pilhaPrincipalProdutos.VerifVazia()) {	
					nomeProduto = JOptionPane.showInputDialog("Digite um nome de um Produto para pesquisar ele na pilha");
					//Associacao entre classes	
					pilhaPrincipalProdutos.pesquisaNome(nomeProduto);
				} else {
					JOptionPane.showMessageDialog(null, "A Pilha de Produtos está vazia!");
				}
				break;

			case 5:
				//Associacao entre classes	
				mostraPilhaPrincipalProdutos = pilhaPrincipalProdutos.percorrePrincipalProdutos();
				JOptionPane.showMessageDialog(null, "Pilha Principal de Produtos: " + mostraPilhaPrincipalProdutos);
				break;

			case 6:
				//Associacao entre classes	
				mostraPilhaDeProdutosRemovidos = pilhaDeProdutosRemovidos.percorrePilhaDeProdutosRemovidos();
				JOptionPane.showMessageDialog(null, "Pilha de Produtos Removidos: " + mostraPilhaDeProdutosRemovidos);
				break;

			case 7:
				//Associacao entre classes	
				JOptionPane.showMessageDialog(null, pilhaDeProdutosRemovidos.RemoverPilhaDeProdutosRemovidos());
				break;

			case 99:
				JOptionPane.showMessageDialog(null, "Programa Finalizado com sucesso!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida");
				break;

			}
		}
	}
}
