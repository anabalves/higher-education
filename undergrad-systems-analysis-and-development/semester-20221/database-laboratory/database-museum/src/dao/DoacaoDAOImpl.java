package dao;

import model.Doacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoacaoDAOImpl implements DoacaoDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean inserir(Doacao doacao) {
        String sql = "INSERT INTO `TB_DOACAO`(`NOME_INSTITUICAO`, `CNPJ`, `VALOR_DOADO`, `DATA_DOACAO`, `DESCRICAO`) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, doacao.getNomeInstituicao());
            stmt.setString(2, doacao.getCnpj());
            stmt.setDouble(3, doacao.getValorDoado());
            stmt.setDate(4, java.sql.Date.valueOf(doacao.getDataDoacao()));
            stmt.setString(5, doacao.getDescricao());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean alterar(Long id, Doacao doacao) {
        String sql = "UPDATE `TB_DOACAO` SET `NOME_INSTITUICAO`=?, `CNPJ`=?, `VALOR_DOADO`=?, `DATA_DOACAO`=?, `DESCRICAO`=? WHERE `ID`=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, doacao.getNomeInstituicao());
            stmt.setString(2, doacao.getCnpj());
            stmt.setDouble(3, doacao.getValorDoado());
            stmt.setDate(4, java.sql.Date.valueOf(doacao.getDataDoacao()));
            stmt.setString(5, doacao.getDescricao());
            stmt.setLong(6, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean deletar(Long id) {
        String sql = "DELETE FROM `TB_DOACAO` WHERE `ID`=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Doacao> listar() {
        String sql = "SELECT `ID`,`NOME_INSTITUICAO`, `CNPJ`, `VALOR_DOADO`, `DATA_DOACAO`, `DESCRICAO` FROM `TB_DOACAO`;";
        List<Doacao> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Doacao doacao = new Doacao();
                doacao.setId(resultado.getLong("ID"));
                doacao.setNomeInstituicao(resultado.getString("NOME_INSTITUICAO"));
                doacao.setCnpj(resultado.getString("CNPJ"));
                doacao.setValorDoado(resultado.getDouble("VALOR_DOADO"));
                doacao.setDataDoacao(resultado.getDate("DATA_DOACAO").toLocalDate());
                doacao.setDescricao(resultado.getString("DESCRICAO"));
                retorno.add(doacao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public Doacao buscar(String nomeInstituicao) {
        String sql = "SELECT `ID`,`NOME_INSTITUICAO`, `CNPJ`, `VALOR_DOADO`, `DATA_DOACAO`, `DESCRICAO` FROM `TB_DOACAO` WHERE LOWER(`NOME_INSTITUICAO`) LIKE LOWER(?);";
        Doacao doacao = new Doacao();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + nomeInstituicao + "%");
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                doacao.setId(resultado.getLong("ID"));
                doacao.setNomeInstituicao(resultado.getString("NOME_INSTITUICAO"));
                doacao.setCnpj(resultado.getString("CNPJ"));
                doacao.setValorDoado(resultado.getDouble("VALOR_DOADO"));
                doacao.setDataDoacao(resultado.getDate("DATA_DOACAO").toLocalDate());
                doacao.setDescricao(resultado.getString("DESCRICAO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doacao;
    }

}
