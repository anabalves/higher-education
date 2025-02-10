package dao;

import model.Funcionario;

import java.util.List;

public interface FuncionarioDAO {

    boolean login(String email, String senha);
    boolean inserir(Funcionario funcionario);
    boolean alterar(Long id, Funcionario funcionario);
    boolean deletar(Long id);
    List<Funcionario> listar();
    Funcionario buscar(String nome);
    boolean existeCpf(String cpf);
    boolean existeEmail(String email);
    boolean alterarSenha(String email, String senha);
}
