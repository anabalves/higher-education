package dao;

import model.Doacao;

import java.util.List;

public interface DoacaoDAO {

    boolean inserir(Doacao doacao);
    boolean alterar(Long id, Doacao doacao);
    boolean deletar(Long id);
    List<Doacao> listar();
    Doacao buscar(String nomeInstituicao);

}
