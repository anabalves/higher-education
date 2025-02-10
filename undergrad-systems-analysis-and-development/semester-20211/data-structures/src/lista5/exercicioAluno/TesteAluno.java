package lista5.exercicioAluno;

import javax.swing.JOptionPane;

public class TesteAluno {

	public static void main(String[] args) {

		ListaAluno listaAluno = new ListaAluno();
		int opc = 0;

		int RA;
		String nome;
		String turma;
		String semestre;

		while (opc != 8) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção válida "
					+ "\n 1- Adicionar um aluno no início da lista " 
					+ "\n 2- Adicionar um aluno no final da lista "
					+ "\n 3- Adicionar um aluno no meio da lista " 
					+ "\n 4- Remover um aluno do início da lista "
					+ "\n 5- Remover um aluno do final da lista " 
					+ "\n 6- Remover um aluno do meio da lista "
					+ "\n 7- Exibir alunos da lista " 
					+ "\n 8- Sair"));

			switch (opc) {

			case 1:
				Aluno alunoInicio = new Aluno();
				nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
				alunoInicio.setNome(nome);
				RA = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do aluno: "));
				alunoInicio.setRA(RA);
				turma = JOptionPane.showInputDialog("Digite a turma do aluno: ");
				alunoInicio.setTurma(turma);
				semestre = JOptionPane.showInputDialog("Digite o semestre do aluno: ");
				alunoInicio.setSemestre(semestre);
				listaAluno.AdicionarInicio(alunoInicio);
				break;

			case 2:
				Aluno alunoFinal = new Aluno();
				nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
				alunoFinal.setNome(nome);
				RA = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do aluno: "));
				alunoFinal.setRA(RA);
				turma = JOptionPane.showInputDialog("Digite a turma do aluno: ");
				alunoFinal.setTurma(turma);
				semestre = JOptionPane.showInputDialog("Digite o semestre do aluno: ");
				alunoFinal.setSemestre(semestre);
				listaAluno.AdicionarFinal(alunoFinal);
				break;

			case 3:
				Aluno alunoMeio = new Aluno();
				nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
				alunoMeio.setNome(nome);
				RA = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do aluno: "));
				alunoMeio.setRA(RA);
				turma = JOptionPane.showInputDialog("Digite a turma do aluno: ");
				alunoMeio.setTurma(turma);
				semestre = JOptionPane.showInputDialog("Digite o semestre do aluno: ");
				alunoMeio.setSemestre(semestre);
				listaAluno.AdicionarMeio(alunoMeio);
				break;

			case 4:
				if (!listaAluno.VerificaListaVazia()) {
					Aluno alunoRemovido = listaAluno.RemoverInicio();
					JOptionPane.showMessageDialog(null,
							"O Aluno " + alunoRemovido.getNome() + " de RA " + alunoRemovido.getRA() + " da turma "
									+ alunoRemovido.getTurma() + " do " + alunoRemovido.getSemestre()
									+ "º semestre foi removido do inicio da lista.");
				} else {
					JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 5:
				if (!listaAluno.VerificaListaVazia()) {
					Aluno alunoRemovido = listaAluno.removerFinal();
					JOptionPane.showMessageDialog(null,
							"O Aluno " + alunoRemovido.getNome() + " de RA " + alunoRemovido.getRA() + " da turma "
									+ alunoRemovido.getTurma() + " do " + alunoRemovido.getSemestre()
									+ "º semestre foi removido do final da lista.");
				} else {
					JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 6:
				if (!listaAluno.VerificaListaVazia()) {
					Aluno alunoRemovido = listaAluno.removerMeio();
					JOptionPane.showMessageDialog(null,
							"O Aluno " + alunoRemovido.getNome() + " de RA " + alunoRemovido.getRA() + " da turma "
									+ alunoRemovido.getTurma() + " do " + alunoRemovido.getSemestre()
									+ "º semestre foi removido do meio da lista.");
				} else {
					JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 7:
				listaAluno.percorre();
				break;

			case 8:
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
