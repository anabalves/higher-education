package exercicio22.aluno;

import java.util.List;

public interface AlunoDAO {
	
    void adicionar(Aluno a);
    List<Aluno> pesquisarPorNome(String nome);
    void atualizar(long id, Aluno a);
    void remover(long id);	

}
