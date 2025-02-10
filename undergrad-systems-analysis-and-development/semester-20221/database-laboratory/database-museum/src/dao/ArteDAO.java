package dao;

import model.Arte;
import model.Funcionario;

import java.util.List;

public interface ArteDAO {

    boolean inserir(Arte arte);
    boolean alterar(Long id, Arte arte);
    boolean deletar(Long id);
    List<Arte> listar();
    Arte buscar(String nomeObra);

}
