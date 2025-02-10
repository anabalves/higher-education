package lista8.exercicioEscolaQuickSort;

import javax.swing.JOptionPane;

public class ListaAluno {
	private NoAluno anterior;
	private NoAluno proximo;
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

	public void adicionaInicio(Aluno aluno) {
		NoAluno novo = new NoAluno();
		novo.setAluno(aluno);
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
		JOptionPane.showMessageDialog(null, "Aluno Adicionado no início da lista: " + novo.getAluno().toString());
	}

	public void adicionaFinal(Aluno aluno) {
		NoAluno novo = new NoAluno();
		novo.setAluno(aluno);
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
		JOptionPane.showMessageDialog(null, "Aluno Adicionado no final da lista: \nID: " + novo.getAluno().toString());
	}

	public Aluno removerInicio() {
		Aluno retorno = null;
		retorno = anterior.getAluno();
		NoAluno aux = anterior.getProximo();
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
		NoAluno aux = proximo.getAnterior();
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

	public Aluno getById(int id) {
		NoAluno aux = anterior;
		return getById(id, aux);
	}
	
	private Aluno getById(int id, NoAluno aux) {
		if (aux.getAluno().getIdAluno() == id) {
			return aux.getAluno();
		} else if (aux.getProximo() == null) {
			return null;
		} else {
			return getById(id, aux.getProximo());
		}
	}

	public void percorre() {
		if (VerificaListaVazia()) {
			JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Lista de alunos:");
			proximoToString(anterior);
		}
	}

	private void proximoToString(NoAluno aux) {
		if (aux.getProximo() == null) {
			JOptionPane.showMessageDialog(null, aux.getAluno().toString());
		} else {
			JOptionPane.showMessageDialog(null, aux.getAluno().toString());
			proximoToString(aux.getProximo());
		}
	}
}