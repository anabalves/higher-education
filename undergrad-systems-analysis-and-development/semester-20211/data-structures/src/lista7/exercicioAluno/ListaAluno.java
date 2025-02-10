package lista7.exercicioAluno;

import javax.swing.JOptionPane;

public class ListaAluno {
	private No anterior;
	private No proximo;
	private int tamanho;

	public ListaAluno() {
		anterior = null;
		proximo = null;
		tamanho = 0;
	}

	public boolean VerificaListaVazia() {
		if (tamanho == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void AdicionarInicio(Aluno alunoInicio) {
		No novo = new No();
		novo.setAluno(alunoInicio);
		novo.setAnterior(novo);
		if (VerificaListaVazia()) {
			novo.setProximo(null);
			anterior = novo;
			proximo = novo;
		} else {
			novo.setProximo(anterior);
			anterior.setAnterior(novo);
			anterior = novo;
		}
		tamanho++;
		JOptionPane.showMessageDialog(null, "Aluno Adicionado no início da lista: \nID: " + novo.aluno.getIdAluno()
				+ "\nNome: " + novo.aluno.getNome() + "\nCurso: " + novo.aluno.getCurso());
	}

	public void AdicionarFinal(Aluno alunoFinal) {
		No novo = new No();
		novo.setAluno(alunoFinal);
		novo.setProximo(null);
		if (VerificaListaVazia()) {
			novo.setAnterior(null);
			anterior = novo;
			proximo = novo;
		} else {
			novo.setAnterior(proximo);
			proximo.setProximo(novo);
			proximo = novo;
		}
		tamanho++;
		JOptionPane.showMessageDialog(null, "Aluno Adicionado no final da lista: \nID: " + novo.aluno.getIdAluno()
				+ "\nNome: " + novo.aluno.getNome() + "\nCurso: " + novo.aluno.getCurso());
	}

	public Aluno RemoverInicio() {
		Aluno retorno = null;
		retorno = anterior.getAluno();
		No aux = anterior.getProximo();
		if (tamanho == 1) {
			anterior = null;
			proximo = null;
		} else {
			aux.setAnterior(null);
			anterior = aux;
		}
		tamanho--;
		return retorno;
	}

	public Aluno removerFinal() {
		Aluno retorno = null;
		retorno = proximo.getAluno();
		No aux = proximo.getAnterior();
		if (tamanho == 1) {
			anterior = null;
			proximo = null;
		} else {
			aux.setProximo(null);
			proximo = aux;
		}
		tamanho--;
		return retorno;
	}

	public void percorre() {
		if (VerificaListaVazia()) {
			JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Lista de alunos:");
			proximoToString(anterior);
		}
	}

	private void proximoToString(No aux) {
		if (aux.getProximo() == null) {
			JOptionPane.showMessageDialog(null, aux.getAluno());
		} else {
			JOptionPane.showMessageDialog(null, aux.getAluno());
			proximoToString(aux.getProximo());
		}
	}
	
}
