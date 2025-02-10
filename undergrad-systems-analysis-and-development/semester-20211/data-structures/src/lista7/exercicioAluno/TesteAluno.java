package lista7.exercicioAluno;

import javax.swing.JOptionPane;

public class TesteAluno {
	
	public static void main(String[] args) {

		ListaAluno listaAluno = new ListaAluno();
		int opc = 0;

		int ID;
		String nome;
		String curso;

		while (opc != 6) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção válida "
					+ "\n 1- Adicionar um aluno no início da lista " 
					+ "\n 2- Adicionar um aluno no final da lista "
					+ "\n 3- Remover um aluno do início da lista "
					+ "\n 4- Remover um aluno do final da lista "
					+ "\n 5- Exibir alunos da lista " 
					+ "\n 6- Sair", JOptionPane.QUESTION_MESSAGE));

			switch (opc) {

			case 1:
				ID = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do aluno: "));
				nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
				curso = JOptionPane.showInputDialog("Digite o curso do aluno: ");
				listaAluno.AdicionarInicio(new Aluno(ID, nome, curso));
				break;

			case 2:
				ID = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do aluno: "));
				nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
				curso = JOptionPane.showInputDialog("Digite o curso do aluno: ");
				listaAluno.AdicionarFinal(new Aluno(ID, nome, curso));
				break;

			case 3:
				if (!listaAluno.VerificaListaVazia()) {
					Aluno alunoRemovido = listaAluno.RemoverInicio();
					JOptionPane.showMessageDialog(null,
							"O Aluno " + alunoRemovido.getNome() + " de ID: " + alunoRemovido.getIdAluno() + " do curso "
									+ alunoRemovido.getCurso() + " foi removido do inicio da lista.");
				} else {
					JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 4:
				if (!listaAluno.VerificaListaVazia()) {
					Aluno alunoRemovido = listaAluno.removerFinal();
					JOptionPane.showMessageDialog(null,
							"O Aluno " + alunoRemovido.getNome() + " de ID: " + alunoRemovido.getIdAluno() + " do curso "
									+ alunoRemovido.getCurso() + " foi removido do final da lista.");
				} else {
					JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 5:
				listaAluno.percorre();
				break;

			case 6:
				JOptionPane.showMessageDialog(null, "Programa Finalizado com sucesso!", "Programa Finalizado",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida", "Opção Inválida",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

		}

	}

}
