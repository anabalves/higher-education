package lista8.exercicioEscolaMergeSort;

public class Aluno {

	private int idAluno;
	private String nomeCompleto;
	private String curso;
	private int semestre;
	
	public Aluno(int idAluno, String nomeCompleto, String curso, int semestre) {
		this.idAluno = idAluno;
		this.nomeCompleto = nomeCompleto;
		this.curso = curso;
		this.semestre = semestre;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String toString() {
		return "Aluno [Id: " + idAluno + ", Nome: " + nomeCompleto + ", Curso: " + curso + ", Semestre: " + semestre + "º]";
	}
	
}
