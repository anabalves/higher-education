package lista5.exercicioAluno;

import javax.swing.JOptionPane;

public class ListaAluno {

	private NO inicio;

	public ListaAluno() {
		this.inicio = null;
	}

	public boolean VerificaListaVazia() {
		if (this.inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	public void AdicionarInicio(Aluno alunoInicio) {
		NO novo = new NO();
		novo.setAluno(alunoInicio);
		novo.setProximo(inicio);
		inicio = novo;
		JOptionPane.showMessageDialog(null,
				"Aluno Adicionado no início da lista: \nNome: " + novo.getAluno().getNome() + "\nRA: "
						+ novo.getAluno().getRA() + "\nTurma: " + novo.getAluno().getTurma() + "\nSemestre: "
						+ novo.getAluno().getSemestre());
	}

	public void AdicionarFinal(Aluno alunoFinal) {
		NO novo = new NO();
		novo.setAluno(alunoFinal);
		novo.setProximo(null);

		if (inicio == null) {
			inicio = novo;
		} else {
			NO aux;
			aux = inicio;

			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(novo);
		}
		JOptionPane.showMessageDialog(null,
				"Aluno Adicionado no final da lista: \nNome: " + novo.getAluno().getNome() + "\nRA: "
						+ novo.getAluno().getRA() + "\nTurma: " + novo.getAluno().getTurma() + "\nSemestre: "
						+ novo.getAluno().getSemestre());
	}

	public void AdicionarMeio(Aluno alunoMeio) {
		NO novo = new NO();
		novo.setAluno(alunoMeio);
		int count = 1;

		if (inicio == null) {
			AdicionarInicio(alunoMeio);
		} else {
			NO aux1 = inicio;
			NO aux2 = inicio;

			while (aux1.getProximo() != null) {
				aux1 = aux1.getProximo();
				count++;
			}
			count = (count / 2);
			int count2 = 1;
			while (count2 < count) {
				aux2 = aux2.getProximo();
				count2++;
			}
			NO aux3 = aux2.getProximo();
			aux2.setProximo(novo);
			novo.setProximo(aux3);
		}
		JOptionPane.showMessageDialog(null,
				"Aluno Adicionado no meio da lista: \nNome: " + novo.getAluno().getNome() + "\nRA: "
						+ novo.getAluno().getRA() + "\nTurma: " + novo.getAluno().getTurma() + "\nSemestre: "
						+ novo.getAluno().getSemestre());
	}

	public Aluno RemoverInicio() {
		NO aux = inicio;
		Aluno alunoRemovido = aux.getAluno();
		inicio = aux.getProximo();
		return alunoRemovido;
	}

	public Aluno removerFinal() {
		NO aux1 = inicio;
		NO aux2 = inicio;
		Aluno alunoRemovido;

		if (inicio.getProximo() == null) {
			alunoRemovido = aux1.getAluno();
			inicio = null;
		} else {

			while (aux1.getProximo() != null) {
				aux2 = aux1;
				aux1 = aux1.getProximo();
			}
			alunoRemovido = aux1.getAluno();
			aux2.setProximo(null);
		}
		return alunoRemovido;
	}

	public Aluno removerMeio() {
		int count = 1;
		NO aux1 = inicio;
		NO aux2 = inicio;
		Aluno alunoRemovido;

		if (inicio.getProximo() == null) {
			NO aux3 = inicio;
			RemoverInicio();
			return aux3.getAluno();
		} else {

			while (aux1.getProximo() != null) {
				aux1 = aux1.getProximo();
				count++;
			}
			count = (count / 2);
			int count2 = 1;
			while (count2 < count) {
				aux2 = aux2.getProximo();
				count2++;
			}
			NO aux3 = aux2.getProximo();
			aux2.setProximo(aux3.getProximo());
			alunoRemovido = aux3.getAluno();
			return alunoRemovido;
		}
	}

	public void percorre() {
		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia", JOptionPane.ERROR_MESSAGE);
		} else {
			NO aux = inicio;
			JOptionPane.showMessageDialog(null, "Lista de alunos:");
			while (aux != null) {
				JOptionPane.showMessageDialog(null,
						"Aluno: \nNome: " + aux.getAluno().getNome() + "\nRA: " + aux.getAluno().getRA() + "\nTurma: "
								+ aux.getAluno().getTurma() + "\nSemestre: " + aux.getAluno().getSemestre());
				aux = aux.getProximo();
			}
		}
	}

}
