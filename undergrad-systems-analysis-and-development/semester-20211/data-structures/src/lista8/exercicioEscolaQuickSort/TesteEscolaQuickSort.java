package lista8.exercicioEscolaQuickSort;

import javax.swing.JOptionPane;

public class TesteEscolaQuickSort {

	public static void main(String[] args) {
		int menuSecundario = 0;
		int menuPrincipal = 0;
		ListaAluno listaAluno = new ListaAluno();
		ListaDisciplina listaDisciplina = new ListaDisciplina();
		ListaMedia listaMedia = new ListaMedia();

		int idAluno;
		String nomeCompleto;
		String curso;
		int semestre;
		int idDisciplina;
		String nomeDisciplina;
		int mediaidAluno;
		int mediaidDisciplina;
		double mediaFinal;

		do {
			menuPrincipal = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Digite uma op��o v�lida " + "\n1 - Gerenciar Alunos " + "\n2 - Gerenciar Disciplinas "
							+ "\n3 - Gerenciar M�dias " + "\n4 - Ordenar Alunos " + "\n99 - Finalizar Programa",
					"Menu Principal", JOptionPane.QUESTION_MESSAGE));

			switch (menuPrincipal) {

			case 1:
				do {
					menuSecundario = Integer.parseInt(JOptionPane.showInputDialog(null,
							"1 - Adiciona inicio \n2 - Adiciona final \n3 - Remove inicio \n4 - Remove final \n5 - Mostrar Alunos \n99 - Voltar para o menu principal",
							"Menu Aluno", JOptionPane.QUESTION_MESSAGE));

					switch (menuSecundario) {
					case 1:
						idAluno = Integer.parseInt(JOptionPane.showInputDialog("Id do aluno: "));
						nomeCompleto = JOptionPane.showInputDialog("Nome Completo do aluno:");
						curso = JOptionPane.showInputDialog("Curso do aluno:");
						semestre = Integer.parseInt(JOptionPane.showInputDialog("Semestre do aluno: "));
						listaAluno.adicionaInicio(new Aluno(idAluno, nomeCompleto, curso, semestre));
						break;

					case 2:
						idAluno = Integer.parseInt(JOptionPane.showInputDialog("Id do aluno: "));
						nomeCompleto = JOptionPane.showInputDialog("Nome Completo do aluno:");
						curso = JOptionPane.showInputDialog("Curso do aluno:");
						semestre = Integer.parseInt(JOptionPane.showInputDialog("Semestre do aluno: "));
						listaAluno.adicionaFinal(new Aluno(idAluno, nomeCompleto, curso, semestre));
						break;

					case 3:
						if (!listaAluno.VerificaListaVazia()) {
							Aluno alunoRemovido = listaAluno.removerInicio();
							JOptionPane.showMessageDialog(null,
									alunoRemovido.toString() + " foi removido do inicio da lista.");
						} else {
							JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
									JOptionPane.ERROR_MESSAGE);
						}
						break;

					case 4:
						if (!listaAluno.VerificaListaVazia()) {
							Aluno alunoRemovido = listaAluno.removerFinal();
							JOptionPane.showMessageDialog(null,
									alunoRemovido.toString() + " foi removido do final da lista.");
						} else {
							JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
									JOptionPane.ERROR_MESSAGE);
						}
						break;

					case 5:
						listaAluno.percorre();
						break;
					}
				} while (menuPrincipal == 99);
				break;

			case 2:
				do {
					menuSecundario = Integer.parseInt(JOptionPane.showInputDialog(null,
							"1 - Adiciona inicio \n2 - Adiciona final \n3 - Remove inicio \n4 - Remove final \n5 - Mostrar Disciplinas \n99 - Voltar para o menu principal",
							"Menu Disciplina", JOptionPane.QUESTION_MESSAGE));

					switch (menuSecundario) {
					case 1:
						idDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Id da Disciplina: "));
						nomeDisciplina = JOptionPane.showInputDialog("Nome da Disciplina:");
						listaDisciplina.adicionaInicio(new Disciplina(idDisciplina, nomeDisciplina));
						break;

					case 2:
						idDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Id da Disciplina: "));
						nomeDisciplina = JOptionPane.showInputDialog("Nome da Disciplina:");
						listaDisciplina.adicionaFinal(new Disciplina(idDisciplina, nomeDisciplina));
						break;

					case 3:
						if (!listaDisciplina.VerificaListaVazia()) {
							Disciplina disciplinaRemovida = listaDisciplina.removerInicio();
							JOptionPane.showMessageDialog(null,
									disciplinaRemovida.toString() + " foi removida do inicio da lista.");
						} else {
							JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
									JOptionPane.ERROR_MESSAGE);
						}
						break;

					case 4:
						if (!listaDisciplina.VerificaListaVazia()) {
							Disciplina disciplinaRemovida = listaDisciplina.removerFinal();
							JOptionPane.showMessageDialog(null,
									disciplinaRemovida.toString() + " foi removida do final da lista.");
						} else {
							JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
									JOptionPane.ERROR_MESSAGE);
						}
						break;

					case 5:
						listaDisciplina.percorre();
						break;
					}
				} while (menuSecundario == 99);
				break;

			case 3:
				do {
					menuSecundario = Integer.parseInt(JOptionPane.showInputDialog(null,
							"1 - Adiciona inicio \n2 - Adiciona final \n3 - Remove inicio \n4 - Remove final \n5 - Mostrar M�dias \n99 - Voltar para o menu principal",
							"Menu M�dia", JOptionPane.QUESTION_MESSAGE));

					switch (menuSecundario) {
					case 1:
						mediaidAluno = Integer.parseInt(JOptionPane.showInputDialog("Id do aluno: "));
						mediaidDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Id da disciplina: "));
						mediaFinal = Double.parseDouble(JOptionPane.showInputDialog("M�dia Final: "));
						listaMedia.adicionaInicio(new Media(mediaidAluno, mediaidDisciplina, mediaFinal));
						break;

					case 2:
						mediaidAluno = Integer.parseInt(JOptionPane.showInputDialog("Id do aluno: "));
						mediaidDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Id da disciplina: "));
						mediaFinal = Double.parseDouble(JOptionPane.showInputDialog("M�dia Final: "));
						listaMedia.adicionaFinal(new Media(mediaidAluno, mediaidDisciplina, mediaFinal));
						break;

					case 3:
						if (!listaMedia.VerificaListaVazia()) {
							Media mediaRemovida = listaMedia.RemoverInicio();
							JOptionPane.showMessageDialog(null,
									mediaRemovida.toString() + " foi removida do inicio da lista.");
						} else {
							JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
									JOptionPane.ERROR_MESSAGE);
						}
						break;

					case 4:
						if (!listaMedia.VerificaListaVazia()) {
							Media mediaRemovida = listaMedia.removerFinal();
							JOptionPane.showMessageDialog(null,
									mediaRemovida.toString() + " foi removida do final da lista.");
						} else {
							JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
									JOptionPane.ERROR_MESSAGE);
						}
						break;

					case 5:
						listaMedia.percorre();
						break;
					}
				} while (menuSecundario == 99);
				break;

			case 4:
				if (!listaMedia.VerificaListaVazia()) {
					int contador = 0;
					Media[] medias = listaMedia.quickSort();
					JOptionPane.showMessageDialog(null,"Lista ordenada no console");
					for (int i = medias.length - 1; i >= 0; i--) {
						System.out.println("Aluno: " + listaAluno.getById(medias[i].getIdAluno()).getNomeCompleto() + " Disciplina: " + listaDisciplina.getById(medias[i].getIdDisciplina()).getNomeDisciplina() + "  M�dia Final: " + medias[i].getMediaFinal());
						if (medias[i].getMediaFinal() >= 8) {
							contador ++;
						}
					}
					System.out.println(contador + " alunos est�o com a m�dia maior ou igual que 8.");
				} else {
					JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia",
							JOptionPane.ERROR_MESSAGE);
				}
				
				break;
			}
		} while (menuPrincipal != 99);
	}
}