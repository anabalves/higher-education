package lista8.exercicioEscolaMergeSort;

public class NoDisciplina {

	private NoDisciplina anterior;
	private NoDisciplina proximo;
	private Disciplina disciplina;
	
	public NoDisciplina getAnterior() {
		return anterior;
	}
	
	public void setAnterior(NoDisciplina anterior) {
		this.anterior = anterior;
	}
	
	public NoDisciplina getProximo() {
		return proximo;
	}
	
	public void setProximo(NoDisciplina proximo) {
		this.proximo = proximo;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}