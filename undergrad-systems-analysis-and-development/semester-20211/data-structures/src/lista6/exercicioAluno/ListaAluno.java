package lista6.exercicioAluno;

import javax.swing.JOptionPane;

public class ListaAluno {

	private NO inicio;

	public ListaAluno() {
		this.inicio = null;
	}

	// M�todo para verificar se a lista est� vazia
	public boolean VerificaListaVazia() {
		if (this.inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	// M�todo para adicionar um Aluno no in�cio da lista
	public void AdicionarInicio(Aluno alunoInicio) {
		NO novo = new NO();
		novo.setAluno(alunoInicio);
		novo.setProximo(inicio);
		inicio = novo;
		JOptionPane.showMessageDialog(null,
				"Aluno Adicionado no in�cio da lista: \nNome: " + novo.getAluno().getNome() + "\nRA: "
						+ novo.getAluno().getRA() + "\nTurma: " + novo.getAluno().getTurma() + "\nSemestre: "
						+ novo.getAluno().getSemestre());
	}

	// M�todo para adicionar um Aluno no final da lista
	// Este m�todo utiliza recursividade direta, pois chama a si mesmo diretamente.
	// A vari�vel "aux" ser� igual ao pr�ximo elemento at� que o pr�ximo
	// elemento seja nulo. Dessa forma o objetivo dessa fun��o � chegar at� o final
	// da lista recursivamente.
	public void AdicionarFinal(Aluno alunoFinal) {
		NO novo = new NO();
		novo.setAluno(alunoFinal);
		novo.setProximo(null);

		if (inicio == null) {
			inicio = novo;
		} else {
			NO aux;
			aux = inicio;
			aux = AdicionarFinalRecursivo(aux);
			aux.setProximo(novo);
		}
		JOptionPane.showMessageDialog(null,
				"Aluno Adicionado no final da lista: \nNome: " + novo.getAluno().getNome() + "\nRA: "
						+ novo.getAluno().getRA() + "\nTurma: " + novo.getAluno().getTurma() + "\nSemestre: "
						+ novo.getAluno().getSemestre());
	}

	// Fun��o recursiva direta chamada no m�todo AdicionaFinal
	private NO AdicionarFinalRecursivo(NO aux) {
		if (aux.getProximo() == null) {
			return aux;
		} else {
			aux = aux.getProximo();
			return AdicionarFinalRecursivo(aux);
		}
	}

	// M�todo para adicionar um Aluno no meio da lista
	// Nesse m�todo foi preciso dividir em duas fun��es recursivas diretas.
	// A primeira tem como objetivo definir a vari�vel "count" e a segunda a
	// vari�vel "aux2".
	public void AdicionarMeio(Aluno alunoMeio) {
		NO novo = new NO();
		novo.setAluno(alunoMeio);
		int count = 1;

		if (inicio == null) {
			AdicionarInicio(alunoMeio);
		} else {
			NO aux1 = inicio;
			NO aux2 = inicio;

			count = AdicionarRemoverMeioRecursivoCount(aux1, count);
			if (count % 2 == 0) {
				count = (count / 2);
			} else {
				count = ((count / 2) + 1);
			}
			int contador = 1;
			aux2 = AdicionarRemoverMeioRecursivoAux2(aux2, count, contador);
			NO aux3 = aux2.getProximo();
			aux2.setProximo(novo);
			novo.setProximo(aux3);
		}
		JOptionPane.showMessageDialog(null,
				"Aluno Adicionado no meio da lista: \nNome: " + novo.getAluno().getNome() + "\nRA: "
						+ novo.getAluno().getRA() + "\nTurma: " + novo.getAluno().getTurma() + "\nSemestre: "
						+ novo.getAluno().getSemestre());
	}

	// Fun��o recursiva direta chamada no m�todo AdicionarMeio e RemoverMeio para
	// definir a variavel "count"
	private int AdicionarRemoverMeioRecursivoCount(NO aux1, int count) {
		if (aux1.getProximo() == null) {
			return count;
		} else {
			aux1 = aux1.getProximo();
			count++;
			return AdicionarRemoverMeioRecursivoCount(aux1, count);
		}
	}

	// Fun��o recursiva direta chamada no m�todo AdicionarMeio e RemoverMeio para
	// definir a variavel "aux2"
	private NO AdicionarRemoverMeioRecursivoAux2(NO aux2, int count, int contador) {
		if (contador == count) {
			return aux2;
		} else {
			aux2 = aux2.getProximo();
			contador++;
			return AdicionarRemoverMeioRecursivoAux2(aux2, count, contador);
		}
	}

	// M�todo para remover um Aluno do in�cio da lista
	public Aluno RemoverInicio() {
		NO aux = inicio;
		Aluno alunoRemovido = aux.getAluno();
		inicio = aux.getProximo();
		return alunoRemovido;
	}

	// M�todo para remover um Aluno do final da lista
	// Nesse m�todo foi preciso dividir em duas fun��es recursivas diretas.
	// A primeira tem como objetivo definir a vari�vel "aux1" e a segunda a
	// vari�vel "aux2".
	public Aluno removerFinal() {
		NO aux1 = inicio;
		NO aux2 = inicio;
		Aluno alunoRemovido;

		if (inicio.getProximo() == null) {
			alunoRemovido = aux1.getAluno();
			inicio = null;
		} else {
			aux2 = removerFinalRecursivoAux2(aux1, aux2);
			aux1 = removerFinalRecursivoAux1(aux1);
			alunoRemovido = aux1.getAluno();
			aux2.setProximo(null);
		}
		return alunoRemovido;
	}

	// Fun��o recursiva direta chamada no m�todo RemoveFinal para definir a variavel
	// "aux1"
	private NO removerFinalRecursivoAux1(NO aux1) {
		if (aux1.getProximo() == null) {
			return aux1;
		} else {
			aux1 = aux1.getProximo();
			return removerFinalRecursivoAux1(aux1);
		}
	}

	// Fun��o recursiva direta chamada no m�todo RemoveFinal para definir a variavel
	// "aux2"
	private NO removerFinalRecursivoAux2(NO aux1, NO aux2) {
		if (aux1.getProximo() == null) {
			return aux2;
		} else {
			aux2 = aux1;
			aux1 = aux1.getProximo();
			return removerFinalRecursivoAux2(aux1, aux2);
		}
	}

	// M�todo para remover um Aluno do meio da lista
	// Nesse m�todo foi preciso dividir em duas fun��es recursivas diretas.
	// A primeira tem como objetivo definir a vari�vel "count" e a segunda a
	// vari�vel "aux2".
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
			count = AdicionarRemoverMeioRecursivoCount(aux1, count);
			count = (count / 2);
			int contador = 1;
			aux2 = AdicionarRemoverMeioRecursivoAux2(aux2, count, contador);
			NO aux3 = aux2.getProximo();
			aux2.setProximo(aux3.getProximo());
			alunoRemovido = aux3.getAluno();
			return alunoRemovido;
		}
	}

	// M�todo para percorrer a lista e exibir cada um de seus elementos.
	// Este m�todo utiliza recursividade direta, pois chama a si mesmo diretamente.
	// Essa fun��o tem como objetivo percorrer toda a lista de alunos
	// recursivamente.
	public void percorre() {
		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "A lista est� vazia!", "Lista Vazia", JOptionPane.ERROR_MESSAGE);
		} else {
			NO aux = inicio;
			JOptionPane.showMessageDialog(null, "Lista de alunos:");
			percorreRecursivo(aux);
		}
	}

	// Fun��o recursiva direta chamada no m�todo percorre para exibir os alunos da
	// lista
	private NO percorreRecursivo(NO aux) {
		if (aux.getProximo() == null) {
			JOptionPane.showMessageDialog(null,
					"Aluno: \nNome: " + aux.getAluno().getNome() + "\nRA: " + aux.getAluno().getRA() + "\nTurma: "
							+ aux.getAluno().getTurma() + "\nSemestre: " + aux.getAluno().getSemestre());
			return aux;
		} else {
			JOptionPane.showMessageDialog(null,
					"Aluno: \nNome: " + aux.getAluno().getNome() + "\nRA: " + aux.getAluno().getRA() + "\nTurma: "
							+ aux.getAluno().getTurma() + "\nSemestre: " + aux.getAluno().getSemestre());
			return percorreRecursivo(aux.getProximo());
		}

	}

}
