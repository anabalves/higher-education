package exercicio22.curso;

import java.util.List;

public interface CursoDAO {
	
    void adicionar(Curso c);
    List<Curso> pesquisarPorNome(String nome);
    void atualizar(long id, Curso c);
    void remover(long id);	

}
