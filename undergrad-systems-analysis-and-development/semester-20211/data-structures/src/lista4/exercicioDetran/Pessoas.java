package lista4.exercicioDetran;

public class Pessoas {

	private int ID;
	private String nome;
	private String RG;
	private String telefone;
	private String dataDeNascimento;
	
	public Pessoas(int iD, String nome, String rG, String telefone, String dataDeNascimento) {
		this.ID = iD;
		this.nome = nome;
		this.RG = rG;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
	}

	public int getID() {
		return (ID);
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getNome() {
		return (nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRG() {
		return (RG);
	}

	public void setRG(String rG) {
		this.RG = rG;
	}

	public String getTelefone() {
		return (telefone);
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataDeNascimento() {
		return (dataDeNascimento);
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String toString(){
		String retorno = "ID: "+ this.ID + ", Nome: "+ this.nome + ", RG: " + this.RG + ", Telefone: " + this.telefone + ", Data de Nascimento: " + this.dataDeNascimento;
		return retorno;
	}
}
