package lista7.exercicioAluno;

public class Aluno {

	private int idAluno;
	private String nome;
	private String curso;
	
	public Aluno(int idAluno, String nome, String curso) {
		this.idAluno = idAluno;
		this.nome = nome;
		this.curso = curso;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno [Id: " + idAluno + ", Nome: " + nome + ", Curso: " + curso + "]";
	}
	
}
