package lista8.exercicioEscolaMergeSort;

public class Media {

	ListaAluno listaAluno = new ListaAluno();
	ListaDisciplina listaDisciplina = new ListaDisciplina();
	private int idAluno;
	private int idDisciplina;
	private double mediaFinal;

	public Media(int idAluno, int idDisciplina, double mediaFinal) {
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
		this.mediaFinal = mediaFinal;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	@Override
	public String toString() {
		return "Média [Aluno: " + getIdAluno() + ", Disciplina: " + getIdDisciplina() + ", Média Final: " + mediaFinal
				+ "]";
	}
}
