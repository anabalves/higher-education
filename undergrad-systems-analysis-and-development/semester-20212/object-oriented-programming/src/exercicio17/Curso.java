package exercicio17;

public class Curso {
	
	private long id = 0;
    private String nome = "";
	private long codigoCurso = 0;
    private String nomeCoordenador = "";
    private int qtdAlunos = 0;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(long codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getNomeCoordenador() {
		return nomeCoordenador;
	}
	public void setNomeCoordenador(String nomeCoordenador) {
		this.nomeCoordenador = nomeCoordenador;
	}
	public int getQtdAlunos() {
		return qtdAlunos;
	}
	public void setQtdAlunos(int qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}
    
	@Override
    public String toString() {
        return this.nome;
    }

}
