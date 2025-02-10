package lista6.exercicioAluno;

import javax.swing.JOptionPane;

public class ListaAluno {

	private NO inicio;

	public ListaAluno() {
		this.inicio = null;
	}

	// Método para verificar se a lista está vazia
	public boolean VerificaListaVazia() {
		if (this.inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	// Método para adicionar um Aluno no início da lista
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

	// Método para adicionar um Aluno no final da lista
	// Este método utiliza recursividade direta, pois chama a si mesmo diretamente.
	// A variável "aux" será igual ao próximo elemento até que o próximo
	// elemento seja nulo. Dessa forma o objetivo dessa função é chegar até o final
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

	// Função recursiva direta chamada no método AdicionaFinal
	private NO AdicionarFinalRecursivo(NO aux) {
		if (aux.getProximo() == null) {
			return aux;
		} else {
			aux = aux.getProximo();
			return AdicionarFinalRecursivo(aux);
		}
	}

	// Método para adicionar um Aluno no meio da lista
	// Nesse método foi preciso dividir em duas funções recursivas diretas.
	// A primeira tem como objetivo definir a variável "count" e a segunda a
	// variável "aux2".
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

	// Função recursiva direta chamada no método AdicionarMeio e RemoverMeio para
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

	// Função recursiva direta chamada no método AdicionarMeio e RemoverMeio para
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

	// Método para remover um Aluno do início da lista
	public Aluno RemoverInicio() {
		NO aux = inicio;
		Aluno alunoRemovido = aux.getAluno();
		inicio = aux.getProximo();
		return alunoRemovido;
	}

	// Método para remover um Aluno do final da lista
	// Nesse método foi preciso dividir em duas funções recursivas diretas.
	// A primeira tem como objetivo definir a variável "aux1" e a segunda a
	// variável "aux2".
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

	// Função recursiva direta chamada no método RemoveFinal para definir a variavel
	// "aux1"
	private NO removerFinalRecursivoAux1(NO aux1) {
		if (aux1.getProximo() == null) {
			return aux1;
		} else {
			aux1 = aux1.getProximo();
			return removerFinalRecursivoAux1(aux1);
		}
	}

	// Função recursiva direta chamada no método RemoveFinal para definir a variavel
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

	// Método para remover um Aluno do meio da lista
	// Nesse método foi preciso dividir em duas funções recursivas diretas.
	// A primeira tem como objetivo definir a variável "count" e a segunda a
	// variável "aux2".
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

	// Método para percorrer a lista e exibir cada um de seus elementos.
	// Este método utiliza recursividade direta, pois chama a si mesmo diretamente.
	// Essa função tem como objetivo percorrer toda a lista de alunos
	// recursivamente.
	public void percorre() {
		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "A lista está vazia!", "Lista Vazia", JOptionPane.ERROR_MESSAGE);
		} else {
			NO aux = inicio;
			JOptionPane.showMessageDialog(null, "Lista de alunos:");
			percorreRecursivo(aux);
		}
	}

	// Função recursiva direta chamada no método percorre para exibir os alunos da
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
