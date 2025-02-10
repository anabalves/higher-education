package dao;

import model.Funcionario;
import util.Security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAOImpl implements FuncionarioDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean login(String email, String senha) {
        String sql = "SELECT count(1) FROM `TB_FUNCIONARIO` WHERE `EMAIL`=? AND `SENHA`=?;";
        String hash = Security.encrypt(senha);
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, hash);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                return resultado.getInt(1) == 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean inserir(Funcionario funcionario) {
        String sql = "INSERT INTO `TB_FUNCIONARIO`(`NOME`, `CPF`, `TELEFONE`,`CARGO`,`TURNO`,`EMAIL`,`SENHA`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        String hash = Security.encrypt(funcionario.getSenha());
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getCargo());
            stmt.setString(5, funcionario.getTurno());
            stmt.setString(6, funcionario.getEmail());
            stmt.setString(7, hash);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean alterar(Long id, Funcionario funcionario) {
        String sql = "UPDATE `TB_FUNCIONARIO` SET `NOME`=?, `TELEFONE`=?, `CARGO`=?, `TURNO`=? WHERE `ID`=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getTelefone());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getTurno());
            stmt.setLong(5, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean deletar(Long id) {
        String sql = "DELETE FROM `TB_FUNCIONARIO` WHERE `ID`=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Funcionario> listar() {
        String sql = "SELECT `ID`,`NOME`, `CPF`, `TELEFONE`, `CARGO`, `TURNO`, `EMAIL`, `SENHA`  FROM `TB_FUNCIONARIO`;";
        List<Funcionario> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultado.getLong("ID"));
                funcionario.setNome(resultado.getString("NOME"));
                funcionario.setCpf(resultado.getString("CPF"));
                funcionario.setTelefone(resultado.getString("TELEFONE"));
                funcionario.setCargo(resultado.getString("CARGO"));
                funcionario.setTurno(resultado.getString("TURNO"));
                funcionario.setEmail(resultado.getString("EMAIL"));
                funcionario.setSenha(resultado.getString("SENHA"));
                retorno.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public Funcionario buscar(String nome) {
        String sql = "SELECT `ID`,`NOME`, `CPF`, `TELEFONE`, `CARGO`, `TURNO`, `EMAIL`, `SENHA` FROM `TB_FUNCIONARIO` WHERE LOWER(`NOME`) LIKE LOWER(?);";
        Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                funcionario.setId(resultado.getLong("ID"));
                funcionario.setNome(resultado.getString("NOME"));
                funcionario.setCpf(resultado.getString("CPF"));
                funcionario.setTelefone(resultado.getString("TELEFONE"));
                funcionario.setCargo(resultado.getString("CARGO"));
                funcionario.setTurno(resultado.getString("TURNO"));
                funcionario.setEmail(resultado.getString("EMAIL"));
                funcionario.setSenha(resultado.getString("SENHA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    @Override
    public boolean existeCpf(String cpf) {
        String sql = "SELECT count(1) FROM `TB_FUNCIONARIO` WHERE `CPF`=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                return resultado.getInt(1) == 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean existeEmail(String email) {
        String sql = "SELECT count(1) FROM `TB_FUNCIONARIO` WHERE `EMAIL`=?;";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                return resultado.getInt(1) == 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean alterarSenha(String email, String senha) {
        String sql = "UPDATE `TB_FUNCIONARIO` SET `SENHA`=? WHERE `EMAIL`=?;";
        String hash = Security.encrypt(senha);
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, hash);
            stmt.setString(2, email);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
