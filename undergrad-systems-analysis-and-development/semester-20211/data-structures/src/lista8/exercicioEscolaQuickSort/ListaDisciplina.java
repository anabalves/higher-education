package lista8.exercicioEscolaQuickSort;

import javax.swing.JOptionPane;

public class ListaDisciplina {
	private NoDisciplina anterior;
	private NoDisciplina proximo;
	private int tamanho;

	public ListaDisciplina() {
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

	public void adicionaInicio(Disciplina disciplina) {
		NoDisciplina novo = new NoDisciplina();
		novo.setDisciplina(disciplina);
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
		JOptionPane.showMessageDialog(null,
				"Disciplina Adicionada no início da lista: " + novo.getDisciplina().toString());
	}

	public void adicionaFinal(Disciplina disciplina) {
		NoDisciplina novo = new NoDisciplina();
		novo.setDisciplina(disciplina);
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
		JOptionPane.showMessageDialog(null,
				"Disciplina Adicionada no final da lista: \nID: " + novo.getDisciplina().toString());
	}

	public Disciplina removerInicio() {
		Disciplina retorno = null;
		retorno = anterior.getDisciplina();
		NoDisciplina aux = anterior.getProximo();
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

	public Disciplina removerFinal() {
		Disciplina retorno = null;
		retorno = proximo.getDisciplina();
		NoDisciplina aux = proximo.getAnterior();
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

	public Disciplina getById(int id) {
		NoDisciplina aux = anterior;

		return getById(id, aux);
	}

	private Disciplina getById(int id, NoDisciplina aux) {
		if (aux.getDisciplina().getIdDisciplina() == id) {
			return aux.getDisciplina();
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
			JOptionPane.showMessageDialog(null, "Lista de disciplinas:");
			proximoToString(anterior);
		}
	}

	private void proximoToString(NoDisciplina aux) {
		if (aux.getProximo() == null) {
			JOptionPane.showMessageDialog(null, aux.getDisciplina().toString());
		} else {
			JOptionPane.showMessageDialog(null, aux.getDisciplina().toString());
			proximoToString(aux.getProximo());
		}
	}
}